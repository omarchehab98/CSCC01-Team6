package team6.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public String readAllNARsView(Model model) {
        Iterable<NARsTemplate> templates = narsRepository.findAll();
        model.addAttribute("templates", templates);
        HashMap<String, String> attributes = new NARsTemplate().getAttributes();
        ArrayList<String> attributeNames = new ArrayList<>();
        ArrayList<String> friendlyNames = new ArrayList<>();
        for (String attribute : attributes.keySet()) {
            attributeNames.add(attributes.get(attribute));
            friendlyNames.add(attribute);
        }
        model.addAttribute("friendlyNames", friendlyNames);
        model.addAttribute("attributeNames", attributeNames);
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