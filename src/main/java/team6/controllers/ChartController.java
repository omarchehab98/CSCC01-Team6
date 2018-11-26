package team6.controllers;

import java.util.HashSet;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import team6.repositories.ChartQueryRepository;
import team6.repositories.ChartRepository;
import team6.repositories.QueryRepository;
import team6.throwables.ChartNotFoundException;
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
        return "charts/read-list";
    }

	@GetMapping("/charts/{id}/embed")
    public String readByIdView(@PathVariable String id, Model model) {
        try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            addChartAttributes(model, chart.get());
            return "charts/chart";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
    }

	private void addChartAttributes(Model model, Chart chart) {
		// got to parse these. Set arbitrary for now
		String name = chart.getName();
		String type = chart.getType();
		String[] labels = {"Yep","Yep","Yep"};
		int[][] data = {{1,2,3},{4,5,6}};
		String[] sourceLabels = {"x", "y"};
		
		model.addAttribute("name", name);
		model.addAttribute("type", type);
		model.addAttribute("labels", labels);
		model.addAttribute("data", data);
		model.addAttribute("sourceLabels", sourceLabels);
	} 

    @GetMapping("/charts/create")
    public String createView(Model model) {

		// Convert queries to JSON
    	Iterable<Query> queries = queryRepository.findAll();
    	JSONArray queriesJSON = new JSONArray();
    	for (Query query : queries) {
    		if (containsGroupByParameter(query)) {
				JSONObject queryJSON = new JSONObject();
				queryJSON.put("id", query.getId());
				queryJSON.put("name", query.getName());
				queriesJSON.put(queryJSON);
    		}
    	}
		model.addAttribute("queriesJSON", queriesJSON.toString());

		model.addAttribute("chart", new Chart());

        return "charts/create";
    }

    @PostMapping("/charts")
    public String create(@ModelAttribute Chart chart, @RequestParam String queries, Model model) {
    	chartRepository.save(chart);
    	populateChartQueries(model, chart, queries);
    	return "redirect:/charts";
    }

    @GetMapping("/charts/{id}/update")
   	public String updateView(Model model, @PathVariable String id) {

		// Convert queries to JSON
    	Iterable<Query> queries = queryRepository.findAll();
    	JSONArray queriesJSON = new JSONArray();
    	for (Query query : queries) {
    		if (containsGroupByParameter(query)) {
				JSONObject queryJSON = new JSONObject();
				queryJSON.put("id", query.getId());
				queryJSON.put("name", query.getName());
				queriesJSON.put(queryJSON);
    		}
    	}
		model.addAttribute("queriesJSON", queriesJSON.toString());
		
		try {
            Long chartId = Long.parseLong(id);
            Chart chart = chartRepository.findById(chartId).get();
            model.addAttribute("chart", chart);

			JSONArray chartQueriesJSON = new JSONArray();
			for (ChartQuery chartQuery : chart.getChartQueries()) {
				Query query = chartQuery.getQuery();
				if (containsGroupByParameter(query)) {
					JSONObject queryJSON = new JSONObject();
					queryJSON.put("id", query.getId());
					queryJSON.put("name", query.getName());
					chartQueriesJSON.put(queryJSON);
				}
			}
			
			model.addAttribute("chartQueriesJSON", chartQueriesJSON.toString());
            return "charts/update";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
    }

    private boolean containsGroupByParameter(Query query) {
    	if (query.getQueryString() == null) {
    		return false;
    	}
    	Pattern pattern = Pattern.compile("group=(\\w*)");
    	Matcher matcher = pattern.matcher(query.getQueryString());
    	return matcher.find();
    }

    @PostMapping("/charts/{id}/embed")
    public String updateById(Model model, @ModelAttribute Chart chart, @PathVariable String id, @RequestParam String queries) {
        chartRepository.save(chart);
        model.addAttribute("chart", chart);
        updateChartQueries(model, chart, queries);
        return "redirect:/charts/{id}/embed";
    }

    private void updateChartQueries(Model model, Chart chart, String queries) {
    	Set<ChartQuery> newChartQueries = new HashSet<ChartQuery>();
    	Set<ChartQuery> chartQueries = chart.getChartQueries();
    	chartQueries.clear();
    	chart.setChartQueries(chartQueries);
    	
    	deleteChartQueriesForChart(model, chart);
    	
    	for (String id : queries.split(",")) {
    		ChartQuery chartQuery = new ChartQuery();
    		
    		Long queryId = Long.parseLong(id);
            Optional<Query> optionalQuery = queryRepository.findById(queryId);
            Query query = optionalQuery.get();
    		
    		chartQuery.setChart(chart);
    		chartQuery.setQuery(query);

    		newChartQueries.add(chartQuery);

    		Set<ChartQuery> chartQueryQuery = query.getChartQueries();
    		chartQueryQuery.add(chartQuery);
    		query.setChartQueries(chartQueryQuery);

    		chartQueryRepository.save(chartQuery);
    	}
    	
    	chart.setChartQueries(newChartQueries);
    }

    private void populateChartQueries(Model model, Chart chart, String queries) {
    	Set<ChartQuery> chartQueriesChart = new HashSet<ChartQuery>();

    	for (String id : queries.split(",")) {
    		ChartQuery chartQuery = new ChartQuery();
    		
    		Long queryId = Long.parseLong(id);
            Optional<Query> optionalQuery = queryRepository.findById(queryId);
            Query query = optionalQuery.get();
    		
    		chartQuery.setChart(chart);
    		chartQuery.setQuery(query);

    		chartQueriesChart.add(chartQuery);

    		Set<ChartQuery> chartQueryQuery = query.getChartQueries();
    		
    		chartQueryQuery.add(chartQuery);
    		query.setChartQueries(chartQueryQuery);

    		// model.addAttribute("chartQuery", chartQuery);
    		chartQueryRepository.save(chartQuery);
    	}

    	chart.setChartQueries(chartQueriesChart);
    }

    private void deleteChartQueriesForChart(Model model, Chart chart) {
    	List<ChartQuery> chartQueries = chartQueryRepository.findAll();
    	for (ChartQuery chartQuery : chartQueries) {
    		if (chartQuery.getChart().getId() == chart.getId()) {
    			chartQuery.getChart().getChartQueries().remove(chartQuery);
    			chartQuery.getQuery().getChartQueries().remove(chartQuery);
    			chartQueryRepository.deleteById(chartQuery.getId());
    			System.out.println("Yep");
    		}
    	}
    }

    /*
     * To manage test populations.
     */
    @DeleteMapping("/charts/{id}/")
    public String deleteById(@PathVariable String id) {
        try {
            chartRepository.deleteById(Long.parseLong(id));
            return "redirect:/charts";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
    }
}
