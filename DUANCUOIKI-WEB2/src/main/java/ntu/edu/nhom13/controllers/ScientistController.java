package ntu.edu.nhom13.controllers;

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
    
    // 1. Hiển thị chi tiết scientist + các bảng liên quan (work, edu, org)
    @GetMapping("scientists/details/{id}")
    public String showScientistDetails(@PathVariable Integer id, Model model) {
        Optional<Scientist> scientistOpt = scientistService.getScientistById(id);
        if (scientistOpt.isEmpty()) {
            return "redirect:/scientists?error=notfound";
        }
        Scientist s = scientistOpt.get();
        model.addAttribute("scientist", s);

        // Load WorkHistory & EducationHistory cho bảng
        model.addAttribute("workHistories", workHistoryService.findByScientistId(id));
        model.addAttribute("educationHistories", educationHistoryService.findByScientistId(id));

        // Organization của scientist có thể lấy trực tiếp từ entity
        model.addAttribute("organization", s.getOrganization());

        return "details_scientist"; // view hiển thị tất cả thông tin
    }

    // 2. Danh sách Projects của scientist
    @GetMapping("scientists/{id}/projects")
    public String getProjectsByScientist(@PathVariable Integer id, Model model) {
        model.addAttribute("projects", projectService.findByScientistId(id));
        model.addAttribute("scientistId", id);
        return "projects_list"; // view liệt kê project của scientist
    }

    // 3. Danh sách Books của scientist
    @GetMapping("scientists/{id}/books")
    public String getBooksByScientist(@PathVariable Integer id, Model model) {
        model.addAttribute("books", bookService.findByScientistId(id));
        model.addAttribute("scientistId", id);
        return "books_list"; // view liệt kê book của scientist
    }

    // 4. Danh sách Articles của scientist
    @GetMapping("scientists/{id}/articles")
    public String getArticlesByScientist(@PathVariable Integer id, Model model) {
        model.addAttribute("articles", articleService.findByScientistId(id));
        model.addAttribute("scientistId", id);
        return "articles_list"; // view liệt kê article của scientist
    }
}
