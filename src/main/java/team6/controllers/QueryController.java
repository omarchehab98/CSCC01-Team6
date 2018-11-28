package team6.controllers;

import java.util.HashMap;
import java.util.Optional;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import team6.factories.TemplateFactoryWrapper;
import team6.models.Query;
import team6.models.Template;
import team6.repositories.QueryRepository;
import team6.throwables.QueryNotFoundException;
import team6.util.JSONStringHelper;

@Controller
public class QueryController {
	@Autowired
	private QueryRepository queryRepository;
	
    @GetMapping("/queries")
    public String readAllView(Model model) {
        Iterable<Query> queries = queryRepository.findAll(); 
        model.addAttribute("queries", queries);
        return "queries/read-list";
    }
    
    @GetMapping("/queries/create")
    public String createView(Model model) {
        model.addAttribute("isCreate", true);
        populateUpsertViewAttributes(model, new Query());
        return "queries/upsert";
    }

    @GetMapping("/queries/{id}")
    public String readByIdView(@PathVariable String id, Model model) {
        try {
            Long queryId = Long.parseLong(id);
            Optional<Query> query = queryRepository.findById(queryId);
            model.addAttribute("query", query.get());
            return "queries/read-single.html";

        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new QueryNotFoundException();
        }
    }

    @PostMapping("/queries")
    public String create(@ModelAttribute Query query){
        queryRepository.save(query);
        return "redirect:/queries";
    }
    
    @GetMapping("/queries/{id}/update")
    public String updateByIdView(@PathVariable String id, Model model) {
        try {
            Long queryId = Long.parseLong(id);
            Optional<Query> query = queryRepository.findById(queryId);
            model.addAttribute("isCreate", false);
            populateUpsertViewAttributes(model, query.get());
            return "queries/upsert";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new QueryNotFoundException();
        }
    }

    @PostMapping("/queries/{id}")
    public String updateById(Model model, @ModelAttribute Query query, @PathVariable String id) {
        queryRepository.save(query);
        model.addAttribute("query", query);
        return "redirect:/queries/{id}";
    }

    @DeleteMapping("/queries/{id}")
    public String deleteById(@PathVariable String id) {
        try {
            queryRepository.deleteById(Long.parseLong(id));
            return "redirect:/queries";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new QueryNotFoundException();
        }
    }

    private void populateUpsertViewAttributes(Model model, Query query) {
        String[] templates = new String[]{
            "ClientProfileTemplate",
            "NARsTemplate",
            "CommunityConnectionsTemplate",
            "EmploymentTemplate",
            "InformationAndOrientationTemplate",
            "LTClientEnrolTemplate",
            "LTCourseSetupTemplate",
            "LTClientExitTemplate"
        };
        model.addAttribute("query", query);
        model.addAttribute("queryStringJSON", new JSONStringHelper(query.getQueryString()).toString());
        model.addAttribute("templateJSON", new JSONStringHelper(query.getTemplate()).toString());
        model.addAttribute("templateNames", templates);
        model.addAttribute("templateNamesJSON", new JSONArray(templates).toString());
        for (String template : templates) {
            Template templateObj = new TemplateFactoryWrapper().build(template, new HashMap<>(), null);
            model.addAttribute(template + "AttributeNamesJSON", new JSONArray(templateObj.getAttributeNames()).toString());
            model.addAttribute(template + "FriendlyNamesJSON", new JSONArray(templateObj.getFriendlyNames()).toString());
        }
    }
}
