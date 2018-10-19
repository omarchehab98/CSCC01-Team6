package team6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team6.models.DummyOrganizationAddress;
import team6.models.Organization;
import team6.repositories.OrganizationRepository;
import team6.throwables.OrganizationNotFoundException;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;
    
    @GetMapping("/organizations")
    public String index(Model model) {
        Iterable <Organization> organizations =  organizationRepository.findAll();
        model.addAttribute("organizations",organizations);
        return "organizations-read-list";
    }

    @GetMapping("/organizations/create")
    public String organizationForm(Model model) {
        model.addAttribute("organization", new Organization(null, null, null, null, null, null, null, null));
	    return "organization-create";
    }
    
    @PostMapping("/organizations")
    public String create(@ModelAttribute Organization organization) {
        organizationRepository.save(organization);
        return "redirect:/organizations";
    }

    @DeleteMapping("/organizations/{id}")
    public String deleteById(@PathVariable String id) {
        try {
            organizationRepository.deleteById(Long.parseLong(id));
            return "redirect:/organizations";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new OrganizationNotFoundException();
        }
    }
}
