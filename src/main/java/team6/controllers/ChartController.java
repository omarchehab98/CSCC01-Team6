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

	@GetMapping("/charts")
	public String readAllView(Model model) {
		Iterable<Chart> charts = chartRepository.findAll(); 
        model.addAttribute("charts", charts);
		return "charts/read-list";
	}

	@GetMapping("/charts/{id}")
	public String readIdView(Model model, @PathVariable String id) {
		try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            model.addAttribute("organization", chart.get());
            return "charts/read-single";

        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
	}

	@GetMapping("/charts/create")
	public String createView() {
		return "/charts/create";
	}

	@PostMapping("/charts")
	public String create() {
		return "redirect:/charts";
	}

	@GetMapping("/charts/{id}/update")
	public String updateIdView(Model model, @PathVariable String id) {
		try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            model.addAttribute("organization", chart.get());
            return "/charts/update";

        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
	}

	@PostMapping("/charts/{id}")
	public String update(Model model, @PathVariable String id, @ModelAttribute Chart chart) {
		return "redirect:/charts/{id}";
	}
}
