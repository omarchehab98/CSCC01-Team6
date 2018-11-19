package team6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import team6.repositories.ReportRepository;
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
}