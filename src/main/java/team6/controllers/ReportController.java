package team6.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import team6.repositories.ReportRepository;
import team6.throwables.OrganizationNotFoundException;
import team6.throwables.ReportNotFoundException;
import team6.models.Organization;
import team6.models.Report;

@Controller
public class ReportController{

    @Autowired
    private ReportRepository reportRepository;

    @PostMapping("/reports")
    public String createReport(@ModelAttribute Report report){
    	reportRepository.save(report);
        return "redirect:/reports";
    }

    @PostMapping("/reports/${report.id}")
    public String saveUpdateReport(Model model, @ModelAttribute Report report){
    		Report re = reportRepository.findById(report.getId()).get();
    		re.setBody(report.getBody());
    		re.setName(report.getName());
    		model.addAttribute("report", re);

        return "redirect:/reports";
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
    	return "reports/create";
    }

    @GetMapping("/reports/{id}/update")
    public String updateReport(Model model, @PathVariable String id) {
        try {
            Long repId = Long.parseLong(id);
            Optional<Report> rep = reportRepository.findById(repId);
            model.addAttribute("report", rep.get());
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
}