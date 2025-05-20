package ntu.edu.nhom13.controllers;

import ntu.edu.nhom13.entity.*;
import ntu.edu.nhom13.repositories.DegreeRepository;
import ntu.edu.nhom13.repositories.ResearchFieldRepository;
import ntu.edu.nhom13.repositories.TitleRepository;
import ntu.edu.nhom13.services.*;
import ntu.edu.nhom13.services.ArticleAuthorService;
import ntu.edu.nhom13.services.ArticleService;
import ntu.edu.nhom13.services.BookService;
import ntu.edu.nhom13.services.EducationHistoryService;
import ntu.edu.nhom13.services.ProjectParticipantService;
import ntu.edu.nhom13.services.ProjectService;
import ntu.edu.nhom13.services.ScientistService;
import ntu.edu.nhom13.services.WorkHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class ScientistController {

    @Autowired
    private ScientistService scientistService;
    @Autowired private AccountService accountService;
    @Autowired private DegreeService degreeService;
    @Autowired private RankService rankService;
    @Autowired private TitleService titleService;
    @Autowired private ResearchFieldService researchFieldService;
    @Autowired private OrganizationService organizationService;
    @Autowired private LanguageLevelService languageLevelService;
    @Autowired private WorkHistoryService workHistoryService;
    @Autowired private EducationHistoryService educationHistoryService;
    @Autowired private BookAuthorService bookAuthorService;
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
    
    @GetMapping("/scientists")
    public String listScientists(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer degreeId,
            @RequestParam(required = false) Integer titleId,
            @RequestParam(required = false) Integer researchFieldId,
            Model model
    ) {
        // Xử lý filter lĩnh vực cha -> con 
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

        return "scientists"; 
    }

    @GetMapping("/scientists/profile")
    public String profileScientist(Model model,HttpSession session) {
    	Scientist account = (Scientist) session.getAttribute("user");
    	model.addAttribute("scientist",account);
    	return "details_scientist";
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

        return "details_scientist"; 
    }

    @GetMapping("scientists/{id}/projects")
    public String getProjectsByScientist(@PathVariable Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        List<Project> projects = projectService.findByScientistId(id);
        model.addAttribute("scientist", scientist);
        model.addAttribute("projects", projects);
//        model.addAttribute("projects", projectService.findByScientistId(id));
        model.addAttribute("scientistId", id);
        return "projects_list"; // view liệt kê project của scientist
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

    ////////////


    @GetMapping("/scientist/scientistList")
    public String showScientists(Model model) {
        model.addAttribute("scientists", scientistService.findAll());
        return "scientist/scientistList";
    }

    @GetMapping("/createScientist")
    public String showCreateForm(Model model) {
        model.addAttribute("scientist", new Scientist());
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("degrees", degreeService.findAll());
        model.addAttribute("ranks", rankService.findAll());
        model.addAttribute("titles", titleService.findAll());
        model.addAttribute("fields", researchFieldService.findAll());
        model.addAttribute("organizations", organizationService.findAll());
        model.addAttribute("languageLevels", languageLevelService.findAll());
        return "scientist/createScientist";
    }

    @PostMapping("/create/save")
    public String createScientist(@ModelAttribute Scientist scientist, RedirectAttributes redirectAttributes) {


        if (scientistService.existsById(scientist.getId())) {
            redirectAttributes.addFlashAttribute("error", "ID đã tồn tại!");
            return "redirect:scientist/createScientist";
        }
        scientistService.save(scientist);
        redirectAttributes.addFlashAttribute("success", "Tạo mới Scientist thành công!");
        return "redirect:/scientist/scientistList";
    }

    @GetMapping("/delete/scientist/{id}")
    public String deleteScientist(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        if (!scientistService.existsById(id)) {
            redirectAttributes.addFlashAttribute("error", "Scientist không tồn tại!");
        } else {
            scientistService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Xóa Scientist thành công!");
        }
        return "redirect:/scientist/scientistList";
    }



}
