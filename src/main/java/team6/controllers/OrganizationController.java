package team6.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import team6.models;

@RestController
public class OrganizationController {
    
    @RequestMapping("/organizations")
    public String index() {
        return "Greetings from Chedy!";
    }

    @GetMapping("/organizations/new")
    public String organizationForm(Model model) {
        model.addAttribute("organization", new Organization());
        return "organizations";
    }
    
}
