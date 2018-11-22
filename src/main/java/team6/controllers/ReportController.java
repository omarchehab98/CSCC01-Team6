package team6.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String createReport(Model model){
        //todo after the tinyMCE gets implemented
        return "/";
    }

    @PostMapping("/reports/update")
    public String createReport(){
        //todo after the tinyMCE gets implemented
        return "/";
    }
    
    @GetMapping("/reports")
    public String readAllReports(Model model) {
    	model.addAttribute("reports", reportRepository.findAll());
		return "reports/read-list";
    }
    
    @GetMapping("/reports/{id}")
    public String readSingleReport(Model model, @PathVariable String id) {
    	try {
    		Long repId = Long.parseLong(id);
    		Optional<Report> rep = reportRepository.findById(repId);
    		model.addAttribute("report", rep);
    		return "report/read-single";
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
}