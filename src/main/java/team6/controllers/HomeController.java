package team6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team6.repositories.OrganizationRepository;

@Controller
public class HomeController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/")
    public String homeView(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        return "index";
    }
}
