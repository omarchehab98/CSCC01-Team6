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
	// Type for the chart, must be one of Bar, Line, or Pie
	// String type = "Bar";
	// List containing all the labels for the chart
	String[] labels = {"Apple", "Orange", "Banana"};
	// List containing the datasets for the chart, each dataset needs a datapoint for each label
	int[][] data = {{1, 2, 3},{4,5,6}};
	// List containing the labels for each dataset, need one label for each dataset
	String[] sourceLabels = {"Fruit","Bagels"};
	model.addAttribute("type", "bar");
	model.addAttribute("labels", labels);
	model.addAttribute("data", data);
	model.addAttribute("sourceLabels", sourceLabels);
        return "reports/chart";
    }
}
