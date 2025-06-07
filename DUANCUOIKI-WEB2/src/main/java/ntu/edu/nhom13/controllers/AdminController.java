package ntu.edu.nhom13.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.entity.User;
import ntu.edu.nhom13.entity.WorkHistory;
import ntu.edu.nhom13.mapper.ScientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ntu.edu.nhom13.dto.ScientistDTO;
import ntu.edu.nhom13.entity.Admin;
import ntu.edu.nhom13.entity.EducationHistory;
import ntu.edu.nhom13.services.DegreeService;
import ntu.edu.nhom13.services.EducationHistoryService;
import ntu.edu.nhom13.services.LanguageLevelService;
import ntu.edu.nhom13.services.OrganizationService;
import ntu.edu.nhom13.services.RankService;
import ntu.edu.nhom13.services.ResearchFieldService;
import ntu.edu.nhom13.services.ScientistService;
import ntu.edu.nhom13.services.TitleService;
import ntu.edu.nhom13.services.WorkHistoryService;
@Controller
public class AdminController {
	
	@Autowired
    private ScientistService scientistService;
	
	@Autowired
	private WorkHistoryService workHistoryService;

	@Autowired
	private EducationHistoryService educationHistoryService;

	@Autowired
    private DegreeService degreeService;
	
	@Autowired
    private RankService rankService;
	
	@Autowired
    private TitleService titleService;
	
	@Autowired
    private ResearchFieldService researchFieldService;
	
	@Autowired
    private OrganizationService organizationService;
	
	@Autowired
    private LanguageLevelService languageLevelService;
	
	@GetMapping("/admin/profile")
    public String profileAdmin(Model model,Authentication authentication) {
    	User account =  (User) authentication.getPrincipal();
    	model.addAttribute("admin",account.getAdmin());
    	return "/admin/details_admin";
    }
	
	@GetMapping("/admin/createScientist")
	public String showCreateForm(Model model) {
	    model.addAttribute("scientist", new ScientistDTO());
	    return "admin/createScientist";
	}

    // Xử lý lưu nhà khoa học mới
    @PostMapping("/admin/createScientist/save")
    public String saveScientist(@Valid ScientistDTO scientistDTO, BindingResult bindingResult, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            // Nếu có lỗi validate, trả lại form để sửa
            model.addAttribute("scientist", scientistDTO);
            return "admin/createScientist";
        }

        scientistService.saveScientist(scientistDTO);

        // Lưu thành công, redirect về danh sách nhà khoa học
        return "redirect:/admin/scientistList";
    }

    @GetMapping("/admin/scientistList")
    public String listScientists(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Scientist> scientists;

        // Nếu có từ khóa tìm kiếm
        if (keyword != null && !keyword.trim().isEmpty()) {
            // Gọi service để tìm kiếm
            scientists = scientistService.searchScientists(keyword);
            // Trả lại keyword cho view để hiển thị lại trên ô tìm kiếm
            model.addAttribute("keyword", keyword);
        } else {
            // Nếu không có từ khóa, lấy tất cả
            scientists = scientistService.getAllScientists();
        }

        model.addAttribute("scientists", scientists);
        return "admin/scientistList";
    }
    @PostMapping("/admin/delete/scientist/{id}")
    public String deleteScientist(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        if (!scientistService.existsById(id)) {
            redirectAttributes.addFlashAttribute("error", "Scientist không tồn tại!");
        } else {
            scientistService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Xóa Scientist thành công!");
        }
        return "redirect:/admin/scientistList"; 
    }

    //Edit thong tin nha khoa Hoc
    @GetMapping("/admin/edit/scientist/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Scientist scientist = scientistService.findById(id);
        if (scientist == null) {
            return "redirect:/admin/scientistList?error=notfound";
        }

        ScientistDTO dto = ScientMapper.fromEntity(scientist);
        model.addAttribute("scientist", dto);

        // Lấy danh sách education và work history
        List<WorkHistory> workHistories = workHistoryService.findByScientistId(id);
        List<EducationHistory> educationHistories = educationHistoryService.findByScientistId(id);

        model.addAttribute("workHistories", workHistories);
        model.addAttribute("educationHistories", educationHistories);
        System.out.println("Work count: " + workHistories.size());
        System.out.println("Edu count: " + educationHistories.size());

        return "admin/editScientist"; // View sẽ xử lý phần hiển thị bảng + nút sửa/thêm
    }

    @PostMapping("/admin/edit/save")
    public String editScientist(@Valid ScientistDTO scientistDTO, BindingResult bindingResult, Model model) throws IOException {
        scientistService.saveScientist(scientistDTO);
        return "redirect:/admin/scientistList";
    }

    @GetMapping("/admin/edit/education/new")
    public String adminCreateEducation(@RequestParam Integer scientistId, Model model) {
        EducationHistory edu = new EducationHistory();
        model.addAttribute("educationHistory", edu);
        model.addAttribute("scientistId", scientistId); // truyền sang view
        return "admin/edit_education";
    }

    @GetMapping("/admin/edit/education/{id}")
    public String adminEditEducation(@PathVariable("id") Integer id, Model model) {
        Optional<EducationHistory> eduOpt = educationHistoryService.findById(id);
        if (!eduOpt.isPresent()) {
            return "redirect:/admin/scientistList?error=notfound";
        }
        model.addAttribute("educationHistory", eduOpt.get());
        model.addAttribute("scientistId", eduOpt.get().getScientist().getId()); // truyền sang view
        return "admin/edit_education";
    }

    @PostMapping("/admin/edit/education/save")
    public String adminSaveEducation(@ModelAttribute EducationHistory educationHistory, @RequestParam Integer scientistId) {
        Scientist scientist = scientistService.findById(scientistId);
        educationHistory.setScientist(scientist);
        educationHistoryService.saveEducationHistory(educationHistory);
        return "redirect:/admin/edit/scientist/" + scientistId;
    }
    
    @GetMapping("/admin/edit/work/new")
    public String adminCreateWork(@RequestParam Integer scientistId, Model model) {
        WorkHistory workHistory = new WorkHistory();
        model.addAttribute("workHistory", workHistory);
        model.addAttribute("scientistId", scientistId);
        return "admin/edit_work";
    }

    @GetMapping("/admin/edit/work/{id}")
    public String adminEditWork(@PathVariable("id") Integer id, Model model) {
        Optional<WorkHistory> workOpt = workHistoryService.findById(id);
        if (!workOpt.isPresent()) {
            return "redirect:/admin/scientistList?error=notfound";
        }
        model.addAttribute("workHistory", workOpt.get());
        model.addAttribute("scientistId", workOpt.get().getScientist().getId());
        return "admin/edit_work";
    }

    @PostMapping("/admin/edit/work/save")
    public String adminSaveWork(@ModelAttribute WorkHistory workHistory, @RequestParam Integer scientistId) {
        Scientist scientist = scientistService.findById(scientistId);
        workHistory.setScientist(scientist);
        workHistoryService.saveWorkHistory(workHistory);
        return "redirect:/admin/edit/scientist/" + scientistId;
    }

//
    @PostMapping("/admin/delete/education/{id}")
    public String deleteEducation(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        EducationHistory edu = educationHistoryService.getEducationHistoryById(id).orElse(null);
        if (edu == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy bản ghi học vấn!");
            return "redirect:/admin/scientistList";
        }
        Integer scientistId = edu.getScientist().getId();
        educationHistoryService.deleteEducationHistory(id);
        redirectAttributes.addFlashAttribute("success", "Xóa học vấn thành công!");
        return "redirect:/admin/edit/scientist/" + scientistId;
    }

    @PostMapping("/admin/delete/work/{id}")
    public String deleteWork(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        WorkHistory work = workHistoryService.getWorkHistoryById(id).orElse(null);
        if (work == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy bản ghi công tác!");
            return "redirect:/admin/scientistList";
        }
        Integer scientistId = work.getScientist().getId();
        workHistoryService.deleteWorkHistory(id);
        redirectAttributes.addFlashAttribute("success", "Xóa công tác thành công!");
        return "redirect:/admin/edit/scientist/" + scientistId;
    }

}
