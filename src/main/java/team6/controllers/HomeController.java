package team6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team6.repositories.ChartRepository;
import team6.repositories.ClientProfileTemplateRepository;
import team6.repositories.NARsTemplateRepository;
import team6.repositories.OrganizationRepository;
import team6.repositories.QueryRepository;
import team6.repositories.ReportRepository;

@Controller
public class HomeController {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private ClientProfileTemplateRepository clientProfileRepository;
    @Autowired
    private NARsTemplateRepository narsRepository;
    @Autowired
    private QueryRepository queryRepository;
    @Autowired
    private ChartRepository chartRepository;
    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/")
    public String homeView(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        model.addAttribute("clientProfiles", clientProfileRepository.findAll());
        model.addAttribute("nars", narsRepository.findAll());
        model.addAttribute("queries", queryRepository.findAll());
        model.addAttribute("charts", chartRepository.findAll());
        model.addAttribute("reports", reportRepository.findAll());
        return "index";
    }
}
