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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import team6.repositories.ChartQueryRepository;
import team6.repositories.ChartRepository;
import team6.repositories.QueryRepository;
import team6.throwables.ChartNotFoundException;
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
        return "reports/charts/read-list";
    }

	@GetMapping("/charts/{id}")
    public String readByIdView(@PathVariable String id, Model model) {
        try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            model.addAttribute("chart", chart.get());
            return "reports/charts/read-single.html";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
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

		model.addAttribute("chart", new Chart());

        return "reports/create-chart";
    }

    @PostMapping("reports/charts")
    public String create(Model model, @ModelAttribute Chart chart, @ModelAttribute Query[] queries) {
    	makeChartQueries(model, chart, queries);
    	chartRepository.save(chart);
    	return "redirect:reports/charts";
    }

    private void makeChartQueries(Model model, Chart chart, Query[] queries) {
    	for (Query query : queries) {
    		ChartQuery chartQuery = new ChartQuery();
    		chartQuery.setChart(chart);
    		chartQuery.setQuery(query);

    		Set<ChartQuery> chartQueryChart = chart.getChartQueries();
    		chartQueryChart.add(chartQuery);
    		chart.setChartQueries(chartQueryChart);

    		Set<ChartQuery> chartQueryQuery = query.getChartQueries();
    		chartQueryQuery.add(chartQuery);
    		query.setChartQueries(chartQueryQuery);

    		model.addAttribute("chartQuery", chartQuery);
    		chartQueryRepository.save(chartQuery);
    	}
    }

    @GetMapping("reports/charts/{id}/update")
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

    @PostMapping("reports/charts/{id}")
    public String updateById(Model model, @ModelAttribute Chart chart, @PathVariable String id) {
        chartRepository.save(chart);
        model.addAttribute("chart", chart);
        return "redirect:reports/charts/{id}";
    }

    @GetMapping("reports/charts/{id}")
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
}
