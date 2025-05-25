package ntu.edu.nhom13.controllers;

import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class StatisticController {

    @Autowired private ScientistService scientistService;
    @Autowired private OrganizationService organizationService;
    @Autowired private ResearchFieldService researchFieldService;
    @Autowired private BookService bookService;
    @Autowired private ArticleService articleService;
    @Autowired private ProjectService projectService;

    @GetMapping("/statistics")
    public String showStatistics(Model model) {
        List<Scientist> scientists = scientistService.findAll();

        // Tổng quan
        model.addAttribute("totalScientists", scientists.size());
        model.addAttribute("totalOrganizations", organizationService.getAllOrganizations().size());
        model.addAttribute("totalResearchFields", researchFieldService.getAllResearchFields().size());

        // Học thuật
        model.addAttribute("totalBooks", bookService.getAllBooks().size());
        model.addAttribute("totalArticles", articleService.getAllArticles().size());
        model.addAttribute("totalProjects", projectService.getAllProjects().size());

        // Giới tính (gender chart)
        Map<String, Long> genderDistribution = scientists.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getGender() != null ? s.getGender() : "Khác",
                        Collectors.counting()
                ));
        model.addAttribute("genderDistribution", genderDistribution);

        // Ngạch khoa học (rank chart)
        Map<Object, Long> rankDistribution = scientists.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getRank() != null ? s.getRank() : "Không rõ",
                        Collectors.counting()
                ));
        model.addAttribute("rankDistribution", rankDistribution);

        return "statistic";
    }
}
