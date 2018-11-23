package team6.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import team6.repositories.ChartQueryRepository;
import team6.repositories.ChartRepository;
import team6.repositories.QueryRepository;
import team6.throwables.ChartNotFoundException;
import team6.throwables.OrganizationNotFoundException;
import team6.throwables.QueryNotFoundException;
import team6.util.JSONStringHelper;
import team6.models.Chart;
import team6.models.ChartQuery;
import team6.models.Query;

@Controller
public class ChartController {
	@Autowired
	private QueryRepository queryRepository;
	@Autowired
	private ChartRepository chartRepository;
	@Autowired
	private ChartQueryRepository chartQueryRepository;

	@GetMapping("/charts")
    public String readAllView(Model model) {
        Iterable<Chart> charts = chartRepository.findAll();
        model.addAttribute("charts", charts);
        return "reports/chart-read-list";
    }

	@GetMapping("/charts/{id}/embed")
    public String readByIdView(@PathVariable String id, Model model) {
        try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            addChartAttributes(model, chart.get());
            // model.addAttribute("chart", chart.get());
            return "reports/chart";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
    }

	private void addChartAttributes(Model model, Chart chart) {
		String name = chart.getName();
		String type =  "bar"; /* chart.getType(); */
		// got to parse these.
		String[] labels = {"yep", "yep", "yep"};
		// set arbitrary for now
		int[][] datasets = {{1, 2, 3},{4, 4, 4}};
		String[] sourceLabels = {};
		
		model.addAttribute("name", name);
		model.addAttribute("type", type);
		model.addAttribute("labels", labels);
		model.addAttribute("datasets", datasets);
		model.addAttribute("sourceLabels", sourceLabels);
	} 

	/*
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
    */
	

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

		model.addAttribute("chart", new Chart());

        return "reports/create-chart";
    }

    @PostMapping("/charts")
    public String create(@ModelAttribute Chart chart , @ModelAttribute String queries) {
    	System.out.println(queries);
    	System.out.println("Here");
    	// makeChartQueries(model, chart, queries);
    	chartRepository.save(chart);
    	return "redirect:/charts";
    }

    /*
    private void makeChartQueries(Model model, Chart chart, String[] queries) {
    	for (String id : queries) {
    		ChartQuery chartQuery = new ChartQuery();
    		// System.out.println(id.toString());
    		
    		/*
    		Long queryId = Long.parseLong(id);
            Optional<Query> optionalQuery = queryRepository.findById(queryId);
            Query query = optionalQuery.get();
            */
    		
            /*
    		chartQuery.setChart(chart);
    		chartQuery.setQuery(query);

    		Set<ChartQuery> chartQueryChart = chart.getChartQueries();
    		chartQueryChart.add(chartQuery);
    		chart.setChartQueries(chartQueryChart);

    		Set<ChartQuery> chartQueryQuery = query.getChartQueries();
    		chartQueryQuery.add(chartQuery);
    		query.setChartQueries(chartQueryQuery);
    		*/

    		/*
    		model.addAttribute("chartQuery", chartQuery);
    		chartQueryRepository.save(chartQuery);
    	}
    }
    */
    

    /*
     * To manage test populations.
     */
    @DeleteMapping("/charts/{id}/embed")
    public String deleteById(@PathVariable String id) {
        try {
            chartRepository.deleteById(Long.parseLong(id));
            return "redirect:/charts";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new OrganizationNotFoundException();
        }
    }

    /*
    @GetMapping("/charts/{id}/update")
    public String updateByIdView(@PathVariable String id, Model model) {
        try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            // populateUpsertViewAttributes(model, query.get());
            return "reports/charts/update";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new QueryNotFoundException();
        }
    }

    @PostMapping("/charts/{id}")
    public String updateById(Model model, @ModelAttribute Chart chart, @PathVariable String id) {
        chartRepository.save(chart);
        model.addAttribute("chart", chart);
        return "redirect:reports/charts/{id}";
    }
    */

    /*
    @GetMapping("/charts/{id}")
    public JSONArray chartDatasetsAndLabels(Model model, @PathVariable String id) {
    	try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            return retrieveDataAndLabels(chart.get());
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new QueryNotFoundException();
        }
    }

    private JSONArray retrieveDataAndLabels(Chart chart) {
    	ArrayList<String> labels = new ArrayList<String>();
    	Pattern pattern = Pattern.compile("group=(\\w*)");
    	Set<ChartQuery> chartQueries = chart.getChartQueries();
    	for (ChartQuery chartQuery : chartQueries) {
    		Query query = chartQuery.getQuery();
    		// check if queryString has a group by parameter
    		Matcher matcher = pattern.matcher(query.getQueryString());
    		if(!matcher.find()) {
    			throw new IllegalArgumentException();
    		}
    		// capture the group by parameter
    		String label = matcher.group().substring(6);
    		if (!labels.contains(label)) {
    			labels.add(label);
    		}
    		
    	}
    	return new JSONArray();
    }
    */
}
