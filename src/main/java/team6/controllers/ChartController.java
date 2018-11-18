package team6.controllers;

import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import team6.models.Chart;
import team6.models.ChartQuery;
import team6.models.Query;
import team6.repositories.ChartRepository;
import team6.throwables.ChartNotFoundException;
import team6.throwables.NoGroupParameterException;

@Controller
public class ChartController {
	@Autowired
	private ChartRepository chartRepository;

	@GetMapping("/charts")
	public String readAllView(Model model) {
		Iterable<Chart> charts = chartRepository.findAll(); 
        model.addAttribute("chart", charts);
		return "/charts/read-list";
	}

	@GetMapping("/charts/{id}")
	public String readIdView(Model model, @PathVariable String id) {
		try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            model.addAttribute("chart", chart.get());
            return "/charts/read-single";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
	}

	@GetMapping("/charts/create")
	public String createView(Model model, @ModelAttribute Query query) {
		Chart chart = new Chart();
		ChartQuery chartQuery = new ChartQuery();
		chartQuery.setChart(chart);
		chartQuery.setQuery(query);
		
		Set<ChartQuery> chartQueriesChart = chart.getChartQueries();
		chartQueriesChart.add(chartQuery);
		chart.setChartQueries(chartQueriesChart);

		Set<ChartQuery> chartQueriesQuery = query.getChartQueries();
		chartQueriesQuery.add(chartQuery);
		chart.setChartQueries(chartQueriesQuery);

		model.addAttribute("chartQuerie", chartQuery);
		model.addAttribute("chart", chart);
		return "/charts/create";
	}

	@PostMapping("/charts")
	public String create(@ModelAttribute Chart chart) {
		chartRepository.save(chart);
		return "redirect:/reports/charts";
	}

	@GetMapping("/charts/{id}/update")
	public String updateIdView(Model model, @PathVariable String id) {
		try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            model.addAttribute("chart", chart.get());
            return "/charts/update";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
	}

	@PostMapping("/charts/{id}")
	public String update(Model model, @PathVariable String id, @ModelAttribute Chart chart) {
		chartRepository.save(chart);
        model.addAttribute("chart", chart);
		return "redirect:/charts/{id}";
	}

	@GetMapping("/charts/{id}")
	public JSONArray chartLabelsAndDatasets(Model model, @PathVariable String id) {
		Pattern pattern = Pattern.compile("group=");
		Long chartId = Long.parseLong(id);
        Optional<Chart> chart = chartRepository.findById(chartId);
        for (ChartQuery chartQuery : chart.get().getChartQueries()) {
        	Query query = chartQuery.getQuery();
        	Matcher matcher = pattern.matcher(query.getQueryString());
        	if (!matcher.find()) {
        		throw new NoGroupParameterException(query);
        	}
        }
		return new JSONArray();
	}
}
