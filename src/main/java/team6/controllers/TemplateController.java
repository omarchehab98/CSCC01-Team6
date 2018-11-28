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

import org.springframework.beans.factory.annotation.Autowired;
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
import team6.models.EmploymentTemplate;
import team6.models.InformationAndOrientationTemplate;
import team6.models.LTClientEnrolTemplate;
import team6.models.LTClientExitTemplate;
import team6.models.LTCourseSetupTemplate;
import team6.models.NARsTemplate;
import team6.models.Organization;
import team6.models.Template;
import team6.repositories.ClientProfileTemplateRepository;
import team6.repositories.CommunityConnectionsTemplateRepository;
import team6.repositories.EmploymentTemplateRepository;
import team6.repositories.InformationAndOrientationTemplateRepository;
import team6.repositories.LTClientEnrolTemplateRepository;
import team6.repositories.LTClientExitTemplateRepository;
import team6.repositories.LTCourseSetupTemplateRepository;
import team6.repositories.NARsTemplateRepository;
import team6.repositories.OrganizationRepository;
import team6.throwables.IllegalTemplateException;
import team6.util.SheetAdapterWrapper;
import team6.util.TemplateQuery;
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
    private EmploymentTemplateRepository employmentTemplateRepository;
    @Autowired
    private InformationAndOrientationTemplateRepository informationAndOrientationTemplateRepository;
    @Autowired
    private LTClientEnrolTemplateRepository ltClientEnrolTemplateRepository;
    @Autowired
    private LTCourseSetupTemplateRepository ltCourseSetupTemplateRepository;
    @Autowired
    private LTClientExitTemplateRepository ltClientExitTemplateRepository;

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
        List<HashMap<String, String>> dataMap = saw.parse(".csv", fileRead, 1, 3);

        TemplateFactoryWrapper templateFactoryWrapper = new TemplateFactoryWrapper();

        // find which repository is needed to be saved to:
        CrudRepository templateRepository = getEntityNameToRepositoryMap().get(templateType);

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
                e.printStackTrace();
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
    
    
    @GetMapping("/templates/NARsTemplate")
    public String readAllNARsView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Needs Assessment & Referrals");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new NARsTemplate());
    }

    @GetMapping("/templates/ClientProfileTemplate")
    public String readAllClientProfileView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Client Profiles");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new ClientProfileTemplate());
    }

    @GetMapping("/templates/CommunityConnectionsTemplate")
    public String readAllCommunityConnectionsView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Community Connections");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new CommunityConnectionsTemplate());
    }

    @GetMapping("/templates/EmploymentTemplate")
    public String readAllEmploymentView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Employment");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new EmploymentTemplate());
    }

    @GetMapping("/templates/InformationAndOrientationTemplate")
    public String readAllInformationAndOrientationView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "Information and Orientation");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new InformationAndOrientationTemplate());
    }

    @GetMapping("/templates/LTClientEnrolTemplate")
    public String readAllLTClientEnrolView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "LT Client Enrol");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new LTClientEnrolTemplate());
    }

    @GetMapping("/templates/LTCourseSetupTemplate")
    public String readAllLTCourseSetupView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "LT Course Setup");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new LTCourseSetupTemplate());
    }

    @GetMapping("/templates/LTClientExitTemplate")
    public String readAllLTClientExitView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join) throws IllegalTemplateException {
        model.addAttribute("templateName", "LT Client Exit");
        return templateReadList(model, select, where, sort, sortDirection, group, join, new LTClientExitTemplate());
    }

    private String templateReadList(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where, @RequestParam Optional<String> sort,
            @RequestParam Optional<String> sortDirection, @RequestParam Optional<String> group,
            @RequestParam Optional<String> join,
            Template template) throws IllegalTemplateException {
        List<String> attributeNames = template.getAttributeNames();
        List<String> friendlyNames = template.getFriendlyNames();
        TemplateQuery.Table table = new TemplateQuery(
            template.getClass().getSimpleName(),
            template.getAttributeToFriendlyNameMap(),
            attributeNames,
            friendlyNames,
            getEntityNameToRepositoryMap()
        )
            .execute(
                SortParameter.parse(sort.orElse("id"), sortDirection.orElse("asc")),
                JoinParameter.parse(join.orElse(null)),
                SelectParameter.parse(select.orElse(null)),
                WhereParameter.parse(where.orElse(null)),
                GroupParameter.parse(group.orElse(null))
            );

        model.addAttribute("attributes", table.attributes);
        model.addAttribute("friendlyNames", friendlyNames);
        model.addAttribute("groupsOfRows", table.data);
        return "templates/read-list";
    }

    public Map<String, JpaRepository> getEntityNameToRepositoryMap() {
        Map<String, JpaRepository> map = new HashMap<>();
        map.put("ClientProfileTemplate", clientProfileTemplateRepository);
        map.put("NARsTemplate", narsTemplateRepository);
        map.put("CommunityConnectionsTemplate", communityConnectionsTemplateRepository);
        map.put("EmploymentTemplate", employmentTemplateRepository);
        map.put("InformationAndOrientationTemplate", informationAndOrientationTemplateRepository);
        map.put("LTClientEnrolTemplate", ltClientEnrolTemplateRepository);
        map.put("LTCourseSetupTemplate", ltCourseSetupTemplateRepository);
        map.put("LTClientExitTemplate", ltClientExitTemplateRepository);
        return map;
    }

}
