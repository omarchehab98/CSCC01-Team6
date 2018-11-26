package team6.controllers;

import java.util.Optional;

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

import team6.models.Chart;
import team6.models.Report;
import team6.repositories.ChartRepository;
import team6.repositories.ReportRepository;
import team6.throwables.ReportNotFoundException;

@Controller
public class ReportController{

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ChartRepository chartRepository;

    @PostMapping("/reports")
    public String createReport(@ModelAttribute Report report){
    	reportRepository.save(report);
        return "redirect:/reports";
    }

    @PostMapping("/reports/{id}")
    public String saveUpdateReport(Model model, @ModelAttribute Report report){	
    	reportRepository.save(report);
    	model.addAttribute("report", report);

        return "redirect:/reports/{id}";
    }
    
    @GetMapping("/reports")
    public String readAllReports(Model model) {
    	Iterable<Report> reports = reportRepository.findAll();
    	model.addAttribute("reports", reports);
		return "reports/read-list";
    }
    
    @GetMapping("/reports/{id}")
    public String readSingleReport(Model model, @PathVariable String id) {
    	try {
    		Long repId = Long.parseLong(id);
    		Optional<Report> rep = reportRepository.findById(repId);
    		model.addAttribute("report", rep.get());
    		return "reports/read-single";
    	} catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ReportNotFoundException();
        }
    }
    
    
    @GetMapping("/reports/create")
    public String createSingleReport(Model model) {
        model.addAttribute("report", new Report());
        populateChartsAttribute(model);
    	return "reports/create";
    }

    @GetMapping("/reports/{id}/update")
    public String updateReport(Model model, @PathVariable String id) {
        try {
            Long repId = Long.parseLong(id);
            Optional<Report> rep = reportRepository.findById(repId);
            model.addAttribute("report", rep.get());
            populateChartsAttribute(model);
            return "reports/update";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ReportNotFoundException();
        }
    }
    
    @DeleteMapping("/reports/{id}")
    public String deleteById(@PathVariable String id) {
        try {
            reportRepository.deleteById(Long.parseLong(id));
            return "redirect:/reports";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ReportNotFoundException();
        }
    }

    private void populateChartsAttribute(Model model) {
        JSONArray charts = new JSONArray();
        for (Chart chart : chartRepository.findAll()) {
            JSONObject chartObj = new JSONObject();
            chartObj.put("id", chart.getId());
            chartObj.put("name", chart.getName());
            charts.put(chartObj);
        }
        model.addAttribute("chartsJSON", charts.toString());
    }
}