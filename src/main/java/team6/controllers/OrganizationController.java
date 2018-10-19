package team6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import team6.models.Organization;
import team6.repositories.OrganizationRepository;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;
    
    @RequestMapping("/organizations")
    public String index() {
        return "Greetings from Chedy!";
    }

    @GetMapping("/organizations/new")
    public String organizationForm(Model model) {
        model.addAttribute("organization", new Organization(null, null, null, null, null, null, null, null));
	    return "organization-create";
    }
    
    @PostMapping("/organizations")
    public String create(@ModelAttribute Organization organization) {
        organizationRepository.save(organization);
        return "redirect:/organizations";
    }
}
