package team6.controllers;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.ModelMap;

import team6.models.Organization;
import team6.repositories.OrganizationRepository;
import team6.throwables.OrganizationNotFoundException;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;
    

    @GetMapping("/organizations")
    public String readAllView(Model model) {
        Iterable<Organization> organizations = organizationRepository.findAll();
        model.addAttribute("organizations", organizations);
        return "organizations/read-list";
    }

    @GetMapping("/organizations/{id}")
    public String readByIdView(@PathVariable String id, Model model) {
        try {
            Long orgId = Long.parseLong(id);
            Optional<Organization> org = organizationRepository.findById(orgId);
            model.addAttribute("organization", org.get());
            return "organizations/read-single.html";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new OrganizationNotFoundException();
        }
    }

    @GetMapping("/organizations/create")
    public String createView(Model model) {
        model.addAttribute("organization", new Organization());
        return "organizations/create";
    }

    @PostMapping("/organizations")
    public String create(@ModelAttribute Organization organization) {
        organizationRepository.save(organization);
        return "redirect:/organizations";
    }

    @GetMapping("/organizations/{id}/update")
    public String updateByIdView(@PathVariable String id, Model model) {
        try {
            Long orgId = Long.parseLong(id);
            Optional<Organization> org = organizationRepository.findById(orgId);
            model.addAttribute("organization", org.get());
            return "organizations/update";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new OrganizationNotFoundException();
        }
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
