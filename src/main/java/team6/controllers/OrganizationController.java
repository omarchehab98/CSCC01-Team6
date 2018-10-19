package team6.controllers;



import team6.models.DummyOrganizationAddress;
import team6.models.Organization;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class OrganizationController {
    
    @RequestMapping("/organizations")
    public String index() {
        return "Greetings from Chedy!";
    }

    @GetMapping("/organizations")
    public String organizationList(Model model){
        ArrayList<Organization> allOrgs = DummyOrganizationAddress.getAllOrgs();
        model.addAttribute("greets", allOrgs);
        return "orgs";
    }
    
}
