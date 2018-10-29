package team6.controllers;

import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.ModelMap;

import team6.models.NARsTemplate;
import team6.repositories.NARsTemplateRepository;


@Controller
public class TemplateController {

    @Autowired
    private NARsTemplateRepository narsRepository;

    @GetMapping("/templates")
    public String readAllView() {
        return "templates/type-list";
    }

    @PostMapping("/templates")
    public String uploadFile(Model model, MultipartFile file, @RequestParam String templateType) throws IOException {
        //Converting the multipart file into a filestream, to be parseable
        InputStream in = file.getInputStream();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = fileRead.readLine()) != null){
            result.append(line);
            result.append("\n");
        }
        model.addAttribute("file", result);
        return "templates/type-list";
    }

    @GetMapping("/templates/NARs")
    public String readAllNARsView(Model model) {
	Iterable<NARsTemplate> templates = narsRepository.findAll();
        model.addAttribute("templates", templates);
	return "templates/read-list";
    }
}