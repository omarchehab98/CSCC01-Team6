package team6.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team6.repositories.ChartRepository;
import team6.models.Chart;

import team6.repositories.QueryRepository;
import team6.models.Query;

@Controller
public class ChartController {
	@Autowired
	private ChartRepository chartRepository;
	@Autowired
	private QueryRepository queryRepository;


	@PostMapping("/charts")
	public String readAllView(Model model) {
		Iterable<Chart> charts = chartRepository.findAll(); 
        	model.addAttribute("charts", charts);
        	return "reports/chart-read-list";
	}
	
    	@GetMapping("/charts/{id}/embed")
    	public String readSingleView(Model model) {
		// Type for the chart, must be one of Bar, Line, or Pie
		String type = "Bar";

		// List containing all the labels for the chart
		// i.e. String[] labels = {"Label1", "Label2", "Label3"};
		String[] labels = {};

		// List containing the datasets for the chart, each dataset needs a datapoint for each label
		// i.e. int[][] data = {{1, 2, 3}, {4, 5, 6}};
		int[][] data = {};

		// List containing the labels for each dataset, need one label for each dataset
		// i.e. String[] sourceLabels = {"Fruit","Bagels"};
		String[] sourceLabels = {};

		model.addAttribute("type", type);
		model.addAttribute("labels", labels);
		model.addAttribute("data", data);
		model.addAttribute("sourceLabels", sourceLabels);
        	return "reports/chart";
    	}

    	@GetMapping("/charts/create")
   	public String createView(Model model) {
		// Convert queries to JSON
		Iterable<Query> queries = queryRepository.findAll();
		JSONArray queriesJSON = new JSONArray();
		for (Query query : queries) {
			JSONObject queryJSON = new JSONObject();
			queryJSON.put("id", query.getId());
			queryJSON.put("name", query.getName());
			queriesJSON.put(queryJSON);
		}
		model.addAttribute("queriesJSON", queriesJSON.toString());

        	return "reports/create-chart";
    	}

   	@PostMapping("/charts")
    	public String create() {
        	return "redirect:/charts";
    	}
}
