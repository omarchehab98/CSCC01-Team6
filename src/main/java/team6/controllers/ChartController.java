package team6.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import team6.models.Chart;
import team6.models.Query;
import team6.repositories.ChartRepository;
import team6.throwables.ChartNotFoundException;

@Controller
public class ChartController {
	@Autowired
	private ChartRepository chartRepository;

	@GetMapping("/reports/charts")
	public String readAllView(Model model) {
		Iterable<Chart> charts = chartRepository.findAll(); 
        model.addAttribute("charts", charts);
		return "/reports/charts/read-list";
	}

	@GetMapping("/charts/{id}")
	public String readIdView(Model model, @PathVariable String id) {
		try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            model.addAttribute("organization", chart.get());
            return "/reports/charts/read-single";

        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
	}

	@GetMapping("/reports/charts/create")
	public String createView() {
		return "/reports/charts/create";
	}

	@PostMapping("/reports/charts")
	public String create() {
		return "redirect:/reports/charts";
	}

	@GetMapping("/reports/charts/{id}/update")
	public String updateIdView(Model model, @PathVariable String id) {
		try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            model.addAttribute("organization", chart.get());
            return "/reports/charts/update";

        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
	}

	@PostMapping("/reports/charts/{id}")
	public String update(Model model, @PathVariable String id, @ModelAttribute Chart chart) {
		return "redirect:/reports/charts/{id}";
	}
}
