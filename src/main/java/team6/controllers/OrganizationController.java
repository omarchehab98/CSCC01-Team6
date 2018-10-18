package team6.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import team6.models.Organization;

@RestController
public class OrganizationController {
    
    @RequestMapping("/organizations")
    public String index() {
        return "Greetings from Chedy!";
    }

    @GetMapping("/organizations")
    public String organizationForm(Model model) {
        model.addAttribute("organization", new Organization(null, null));
        return "organizations";
    }
    
}
