package team6.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import team6.factories.TemplateFactoryWrapper;
import team6.models.ClientProfileTemplate;
import team6.models.CommunityConnectionsTemplate;
import team6.models.NARsTemplate;
import team6.models.Organization;
import team6.models.Template;
import team6.repositories.ClientProfileTemplateRepository;
import team6.repositories.CommunityConnectionsTemplateRepository;
import team6.repositories.NARsTemplateRepository;
import team6.repositories.OrganizationRepository;
import team6.throwables.IllegalTemplateException;
import team6.util.AttributeResolver;
import team6.util.CartesianProduct;
import team6.util.SheetAdapterWrapper;
import team6.util.expressions.BooleanExpression;
import team6.util.parameters.GroupParameter;
import team6.util.parameters.JoinParameter;
import team6.util.parameters.SelectParameter;
import team6.util.parameters.SortParameter;
import team6.util.parameters.WhereParameter;

@Controller
public class TemplateController {
    @Autowired
    private NARsTemplateRepository narsTemplateRepository;
    @Autowired
    private ClientProfileTemplateRepository clientProfileTemplateRepository;
    @Autowired
    private CommunityConnectionsTemplateRepository communityConnectionsTemplateRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/templates")
    public String readAllView() {
        return "templates/type-list";
    }

    @PostMapping("/templates")
    public String createTemplateByFile(Model model, MultipartFile file, @RequestParam String organizationId,
            @RequestParam String templateType) throws IOException, IllegalTemplateException {
        // Converting the multipart file into a filestream, to be parseable
        InputStream in = file.getInputStream();
        String fileName = file.getOriginalFilename();

        BufferedReader fileRead = new BufferedReader(new InputStreamReader(in));
        // send BufferedReader to SheetAdapterWrapper
        SheetAdapterWrapper saw = new SheetAdapterWrapper();

        // get HashMap representation from the wrapper
        List<HashMap<String, String>> dataMap = saw.parse(file.getContentType(), fileRead, 1, 3);

        TemplateFactoryWrapper templateFactoryWrapper = new TemplateFactoryWrapper();

        // find which repository is needed to be saved to:
        CrudRepository templateRepository = getRepo(templateType);

        // get the organization for this template:
        Long orgId = Long.parseLong(organizationId);
        Optional<Organization> org = organizationRepository.findById(orgId);
        Organization organization = org.get();

        ArrayList<Template> templateList = new ArrayList<Template>();
        // first make sure that all templates are converted as the right template
        for (HashMap<String, String> item : dataMap) {
            // find out which template it is and store it in respective repo
            try{
                Template template = templateFactoryWrapper.build(templateType, item, organization);
                templateList.add(template);
            }catch(IllegalTemplateException | IllegalArgumentException e){
                model.addAttribute("templateType" ,templateType.toString());
                model.addAttribute("fileName" ,fileName.toString());
                return "error-template-upload-fail";
            }
            
        }
        for (Template template : templateList){
            templateRepository.save(template);
        }
        // model.addAttribute("file", result);
        return "templates/type-list";
    }

    @GetMapping("/templates/NARs")
    public String readAllNARsView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Needs Assessment & Referrals");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new NARsTemplate(), narsTemplateRepository);
    }

    @GetMapping("/templates/clientProfile")
    public String readAllClientProfileView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Client Profiles");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new ClientProfileTemplate(), clientProfileTemplateRepository);
    }

    @GetMapping("/templates/communityConnections")
    public String readAllCommunityConnectionsView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Community Connections");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new CommunityConnectionsTemplate(), communityConnectionsTemplateRepository);
    }

    private String templateReadList(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join,
            Template template, JpaRepository repository) throws IllegalTemplateException {
        final Sort sortObj = SortParameter.parse(sort.orElse("id"), sortDirection.orElse("asc"));
        final Map<String, String> attributeToFriendlyNameMap = new HashMap<>();
        final Map<String, Integer> entityNameToIndex = new HashMap<>();
        List<Attribute> attributes = new ArrayList<>();
        List<String> attributeNames = template.getAttributeNames();
        List<String> friendlyNames = template.getFriendlyNames();
        List<List<Object>> joinedRows;
        entityNameToIndex.put(template.getClass().getSimpleName(), 0);
        if (join.isPresent()) {
            final String[] joinEntities = JoinParameter.parse(join.get());
            List<List<Object>> allRows = new ArrayList<>();
            allRows.add(repository.findAll(sortObj));
            int i = 1;
            for (String entity : joinEntities) {
                entityNameToIndex.put(entity, i++);
                final JpaRepository otherRepository = getRepo(entity);
                final Template otherTemplate = new TemplateFactoryWrapper().build(entity, new HashMap<>(), null);
                final List<Object> otherRows = otherRepository.findAll();
                attributeToFriendlyNameMap.putAll(otherTemplate.getAttributeToFriendlyNameMap());
                List<String> selectAttributes = otherTemplate.getAttributeNames()
                    .stream()
                    .map(attributeName -> entity + "." + attributeName)
                    .collect(Collectors.toList());
                attributeNames.addAll(selectAttributes);
                friendlyNames.addAll(otherTemplate.getFriendlyNames());
                allRows.add(otherRows);
            }
            joinedRows = CartesianProduct.evaluate(allRows);
        } else {
            final List<Object> rows = repository.findAll(sortObj);
            joinedRows = rows.stream()
                .map(row -> {
                    List<Object> rowInList = new ArrayList<>();
                    rowInList.add(row);
                    return rowInList;
                })
                .collect(Collectors.toList());
        }
        attributeToFriendlyNameMap.putAll(template.getAttributeToFriendlyNameMap());
        if (select.isPresent()) {
            attributeNames = SelectParameter.parse(select.get());
            friendlyNames = attributeNames.stream()
                .map(attributeName -> attributeToFriendlyNameMap.get(attributeName.replaceFirst("(.+\\.)?", "")))
                .collect(Collectors.toList());
        }

        attributes = attributeNames.stream()
            .map(attributeName -> {
                final String[] defaultedAttributeName = getEntityAndAttributeName(attributeName, template.getClass().getSimpleName());
                return new Attribute(entityNameToIndex.get(defaultedAttributeName[0]), defaultedAttributeName[1]);
            })
            .collect(Collectors.toList());
        List<List<Object>> filteredJoinedRows;
        if (where.isPresent()) {
            filteredJoinedRows = joinedRows.stream()
                .filter(joinedRow -> {
                    final BooleanExpression expression = WhereParameter.parse(where.get());
                    expression.populateWithObject(joinedRow.get(0));
                    for (Object object : joinedRow) {
                        expression.populateWithObject(object, object.getClass().getSimpleName() + ".");
                    }
                    return expression.isTrue();
                })
                .collect(Collectors.toList());
        } else {
            filteredJoinedRows = joinedRows;
        }
        List<List<List<Object>>> groupedFilteredJoinedRows;
        if (group.isPresent()) {
            final String groupBy = GroupParameter.parse(group.get());
            final String[] defaultedGroupBy = getEntityAndAttributeName(groupBy, template.getClass().getSimpleName());
            final HashMap<Object, List<List<Object>>> rowGroupsMap = new HashMap<>();
            filteredJoinedRows.forEach(row -> {
                final Object attribute = AttributeResolver.get(defaultedGroupBy[1], row.get(entityNameToIndex.get(defaultedGroupBy[0])));
                final List<List<Object>> rowGroup = rowGroupsMap.getOrDefault(attribute, new ArrayList<>());
                rowGroup.add(row);
                rowGroupsMap.put(attribute, rowGroup);
            });
            groupedFilteredJoinedRows = new ArrayList<>(rowGroupsMap.values());
        } else {
            List<List<Object>> rowGroup = new ArrayList<>();
            filteredJoinedRows.forEach(rowGroup::add);
            groupedFilteredJoinedRows = new ArrayList<>();
            groupedFilteredJoinedRows.add(rowGroup);
        }
        model.addAttribute("attributes", attributes);
        model.addAttribute("friendlyNames", friendlyNames);
        model.addAttribute("groupsOfRows", groupedFilteredJoinedRows);
        return "templates/read-list";
    }

    private String[] getEntityAndAttributeName(String entityAndName, String defaultEntityName) {
        String[] entityAndNameArr = entityAndName.split("\\.");
        if (entityAndNameArr.length == 1) {
            final String entityName = defaultEntityName;
            final String attributeName = entityAndNameArr[0];
            return new String[]{entityName, attributeName};
        } else if (entityAndNameArr.length == 2) {
            final String entityName = entityAndNameArr[0];
            final String attributeName = entityAndNameArr[1];
            return new String[]{entityName, attributeName};
        } else {
            throw new IllegalArgumentException();
        }
    }

    public JpaRepository getRepo(String templateType) throws IllegalTemplateException {
        switch (templateType) {
        case "ClientProfileTemplate":
        case "clientProfile":
            return clientProfileTemplateRepository;
        case "NARsTemplate":
        case "NARs":
            return narsTemplateRepository;
        case "communityConnections":
        	return communityConnectionsTemplateRepository;
        }
        throw new IllegalTemplateException(String.format("invalid template: %s", templateType));
    }

}

class Attribute {
    private Integer entityIndex;
    private String name;

    public Attribute(Integer entityIndex, String name) {
        this.entityIndex = entityIndex;
        this.name = name;
    }

    public Integer getEntityIndex() {
        return this.entityIndex;
    }

    public void setEntityIndex(Integer entityIndex) {
        this.entityIndex = entityIndex;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}