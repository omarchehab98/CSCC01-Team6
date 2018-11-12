package team6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team6.models.Organization;
import team6.models.Query;
import team6.repositories.QueryRepository;

@Controller
public class QueryController {
	@Autowired
	private QueryRepository queryRepository;
	
    @GetMapping("/queries")
    public String readAllView(Model model) {
        Iterable<Query> queries = queryRepository.findAll(); 
        model.addAttribute("queries", queries);
        return "queries/read-queries";
    }
    
    @GetMapping("/queries/create")
    public String createView(Model model) {
        model.addAttribute("query", new Query());
        return "queries/create";
    }
    
}
