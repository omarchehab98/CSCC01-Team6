package team6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team6.repositories.ClientProfileTemplateRepository;
import team6.repositories.NARsTemplateRepository;
import team6.repositories.OrganizationRepository;
import team6.repositories.QueryRepository;

@Controller
public class HomeController {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private ClientProfileTemplateRepository clientProfileRepository;
    @Autowired
    private NARsTemplateRepository narsRepository;
    @Autowired
    private QueryRepository queryRepository;

    @GetMapping("/")
    public String homeView(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        model.addAttribute("clientProfiles", clientProfileRepository.findAll());
        model.addAttribute("nars", narsRepository.findAll());
        model.addAttribute("queries", queryRepository.findAll());
        return "index";
    }
}
