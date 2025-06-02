package ntu.edu.nhom13.controllers;

import ntu.edu.nhom13.dto.ScientistDTO;
import ntu.edu.nhom13.entity.*;
import ntu.edu.nhom13.repositories.DegreeRepository;
import ntu.edu.nhom13.repositories.ResearchFieldRepository;
import ntu.edu.nhom13.repositories.TitleRepository;
import ntu.edu.nhom13.services.ArticleAuthorService;
import ntu.edu.nhom13.services.ArticleService;
import ntu.edu.nhom13.services.BookService;
import ntu.edu.nhom13.services.EducationHistoryService;
import ntu.edu.nhom13.services.ProjectParticipantService;
import ntu.edu.nhom13.services.ProjectService;
import ntu.edu.nhom13.services.ScientistService;
import ntu.edu.nhom13.services.WorkHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class ScientistController {

    @Autowired private ScientistService scientistService;
    @Autowired private WorkHistoryService workHistoryService;
    @Autowired private EducationHistoryService educationHistoryService;
    @Autowired private ArticleAuthorService articleAuthorService;
    @Autowired private ProjectParticipantService projectParticipantService;
    @Autowired private ProjectService projectService;
    @Autowired private BookService bookService;
    @Autowired private ArticleService articleService;


    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private ResearchFieldRepository researchFieldRepository;
    

    @GetMapping("/scientists/list")
    public String listScientists(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer degreeId,
            @RequestParam(required = false) Integer titleId,
            @RequestParam(required = false) Integer researchFieldId,
            Model model
    ) {
        Set<Integer> researchFieldIds = new HashSet<>();
        if (researchFieldId != null) {
            researchFieldIds.add(researchFieldId);
            List<ResearchField> children = researchFieldRepository.findByParentFieldId(researchFieldId);
            for (ResearchField rf : children) {
                researchFieldIds.add(rf.getId());
            }
        }

        List<Scientist> scientists = scientistService.filterScientists(keyword, degreeId, titleId, researchFieldId);

        model.addAttribute("scientists", scientists);
        model.addAttribute("keyword", keyword);
        model.addAttribute("degreeId", degreeId);
        model.addAttribute("titleId", titleId);
        model.addAttribute("researchFieldId", researchFieldId);

        model.addAttribute("degrees", degreeRepository.findAll());
        model.addAttribute("titles", titleRepository.findAll());
        model.addAttribute("researchfields", researchFieldRepository.findAll());

        return "scientistsList";
    }

    @GetMapping("/scientists/profile")
    public String profileScientist(Model model,Authentication authentication) {
    	User account =  (User) authentication.getPrincipal();
    	model.addAttribute("scientist",account.getScientist());
    	return "scientist/details_scientist";
    
    }

    @GetMapping("scientists/details/{id}")
    public String showScientistDetails(@PathVariable Integer id, Model model) {
        Optional<Scientist> scientistOpt = scientistService.getScientistById(id);
        if (scientistOpt.isEmpty()) {
            return "redirect:/scientists?error=notfound";
        }
        Scientist s = scientistOpt.get();
        model.addAttribute("scientist", s);
        model.addAttribute("workHistories", workHistoryService.findByScientistId(id));
        model.addAttribute("educationHistories", educationHistoryService.findByScientistId(id));
        model.addAttribute("pro", projectParticipantService.findByScientistId(id).size());
        model.addAttribute("bo", bookService.findByScientistId(id).size());
        model.addAttribute("art", articleAuthorService.getArticlesByAuthorId(id).size());

        model.addAttribute("organization", s.getOrganization());

        int projectCount = projectService.countByScientistId(id);
        int bookCount = bookService.countByScientistId(id);
        int articleCount = articleService.countByScientistId(id);

        model.addAttribute("projectCount", projectCount);
        model.addAttribute("bookCount", bookCount);
        model.addAttribute("articleCount", articleCount);

        return "scientist/details_scientist"; 
    }

    @GetMapping("scientists/{id}/projects")
    public String getProjectsByScientist(@PathVariable Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        List<Project> projects = projectService.findByScientistId(id);
        model.addAttribute("scientist", scientist);
        model.addAttribute("projects", projects);
//        model.addAttribute("projects", projectService.findByScientistId(id));
        model.addAttribute("scientistId", id);
        return "scientist/projects_list"; // view liệt kê project của scientist
    }
    
    @GetMapping("scientists/{id}/books")
    public String getBooksByScientist(@PathVariable Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        List<Book> books = bookService.findByScientistId(id);
        model.addAttribute("scientist", scientist);
        model.addAttribute("books", books);
        return "scientist/books_list";
    }

    @GetMapping("scientists/{id}/articles")
    public String getArticlesByScientist(@PathVariable Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        List<Article> articles = articleService.findByScientistId(id);
        model.addAttribute("scientist", scientist);
        model.addAttribute("articles", articles);
        return "scientist/articles_list";
    }



    @GetMapping("/scientists/scientistList")
    public String showScientists(Model model) {
        model.addAttribute("scientists", scientistService.findAll());
        return "admin/scientistList";
    }
}