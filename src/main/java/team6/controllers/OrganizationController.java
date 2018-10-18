package team6.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class OrganizationController {
    
    @RequestMapping("/organizations")
    public String index() {
        return "Greetings from Chedy!";
    }
    
}
