package ntu.edu.nhom13.controllers;

import ntu.edu.nhom13.entity.Article;
import ntu.edu.nhom13.entity.Book;
import ntu.edu.nhom13.entity.Project;
import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.services.ArticleService;
import ntu.edu.nhom13.services.BookService;
import ntu.edu.nhom13.services.EducationHistoryService;
import ntu.edu.nhom13.services.ProjectService;
import ntu.edu.nhom13.services.ScientistService;
import ntu.edu.nhom13.services.WorkHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ScientistController {

    @Autowired
    private ScientistService scientistService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private BookService bookService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private WorkHistoryService workHistoryService;
    @Autowired
    private EducationHistoryService educationHistoryService;
    @GetMapping("/scientists")
    public String listScientists(Model model) {
        List<Scientist> scientists = scientistService.getAllScientists();
        model.addAttribute("scientists", scientists);
        return "scientists";  
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
        model.addAttribute("organization", s.getOrganization());

        int projectCount = projectService.countByScientistId(id);
        int bookCount = bookService.countByScientistId(id);
        int articleCount = articleService.countByScientistId(id);

        model.addAttribute("projectCount", projectCount);
        model.addAttribute("bookCount", bookCount);
        model.addAttribute("articleCount", articleCount);

        return "details_scientist"; 
    }

    @GetMapping("scientists/{id}/projects")
    public String getProjectsByScientist(@PathVariable Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        List<Project> projects = projectService.findByScientistId(id);
        model.addAttribute("scientist", scientist);
        model.addAttribute("projects", projects);
        return "projects_list";
    }
    
    @GetMapping("scientists/{id}/books")
    public String getBooksByScientist(@PathVariable Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        List<Book> books = bookService.findByScientistId(id);
        model.addAttribute("scientist", scientist);
        model.addAttribute("books", books);
        return "books_list";
    }

    @GetMapping("scientists/{id}/articles")
    public String getArticlesByScientist(@PathVariable Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        List<Article> articles = articleService.findByScientistId(id);
        model.addAttribute("scientist", scientist);
        model.addAttribute("articles", articles);
        return "articles_list";
    }

}
