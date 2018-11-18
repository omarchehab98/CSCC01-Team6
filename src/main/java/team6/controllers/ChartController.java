package team6.controllers;

import java.util.HashMap;
import java.util.Optional;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ChartController {
	
    @GetMapping("/charts")
    public String readAllView(Model model) {
	model.addAttribute("type", "bar");
	String[] labels = {"Apple", "Orange", "Banana"};
	int[] data = {1, 2, 3};
	model.addAttribute("labels", labels);
	model.addAttribute("data", data);
	model.addAttribute("dataLabel", "Fruit");
        return "reports/chart";
    }
}
