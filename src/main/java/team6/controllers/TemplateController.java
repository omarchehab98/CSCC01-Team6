package team6.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import team6.factories.TemplateFactoryWrapper;
import team6.models.NARsTemplate;
import team6.models.Template;
import team6.repositories.NARsTemplateRepository;
import team6.throwables.IllegalTemplateException;
import team6.util.SheetAdapterWrapper;
import team6.util.parameters.SelectParameter;
import team6.util.parameters.WhereParameter;

@Controller
public class TemplateController {
    @Autowired
    private NARsTemplateRepository narsTemplateRepository;

    private CrudRepository templateRepository;

    @Autowired
    private NARsTemplateRepository narsRepository;

    @GetMapping("/templates")
    public String readAllView() {
        return "templates/type-list";
    }

    @PostMapping("/templates")
    public String uploadFile(Model model, MultipartFile file, @RequestParam String templateType)
            throws IOException, IllegalTemplateException {
        // Converting the multipart file into a filestream, to be parseable
        InputStream in = file.getInputStream();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(in));

        // send BufferedReader to SheetAdapterWrapper
        SheetAdapterWrapper saw = new SheetAdapterWrapper();

        // get HashMap representation from the wrapper
        List<HashMap<String, String>> dataMap = saw.parse("csv", fileRead, 1, 3);

        TemplateFactoryWrapper templateFactoryWrapper = new TemplateFactoryWrapper();

        // find which repository is needed to be saved to:
        templateRepository = getRepo(templateType);

        for (HashMap<String, String> item : dataMap) {
            // find out which template it is and store it in respective repo
            Template template = templateFactoryWrapper.build(templateType, item);

            templateRepository.save(template);
        }
        // model.addAttribute("file", result);
        return "templates/type-list";
    }

    @GetMapping("/templates/NARs")
    public String readAllNARsView(Model model, @RequestParam Optional<String> select,
            @RequestParam Optional<String> where) {
        NARsTemplate nARsTemplate = new NARsTemplate();
        Map<String, String> attributeToFriendlyNameMap = nARsTemplate.getAttributeToFriendlyNameMap();
        List<String> attributeNames = nARsTemplate.getAttributeNames();
        List<String> friendlyNames = nARsTemplate.getFriendlyNames();
        if (select.isPresent()) {
            attributeNames = SelectParameter.parse(select.get());
            friendlyNames = attributeNames.stream().map(attributeToFriendlyNameMap::get).collect(Collectors.toList());
        }
        final Iterable<NARsTemplate> allTemplates = narsRepository.findAll();
        Iterable<NARsTemplate> templates = allTemplates;
        if (where.isPresent()) {
            templates = () -> StreamSupport.stream(allTemplates.spliterator(), false)
                    .filter(template -> template.matches(WhereParameter.parse(where.get()))).iterator();
        }
        model.addAttribute("attributeNames", attributeNames);
        model.addAttribute("friendlyNames", friendlyNames);
        model.addAttribute("templates", templates);
        return "templates/read-list";
    }

    public CrudRepository getRepo(String templateType) {
        switch (templateType) {
        case "NARs":
            return narsTemplateRepository;
        }
        throw new IllegalArgumentException();
    }
}