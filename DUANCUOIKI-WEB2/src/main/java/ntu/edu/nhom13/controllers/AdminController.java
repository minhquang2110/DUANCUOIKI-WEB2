package ntu.edu.nhom13.controllers;

import java.io.IOException;
import java.util.List;

import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.entity.User;
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
import ntu.edu.nhom13.services.DegreeService;
import ntu.edu.nhom13.services.LanguageLevelService;
import ntu.edu.nhom13.services.OrganizationService;
import ntu.edu.nhom13.services.RankService;
import ntu.edu.nhom13.services.ResearchFieldService;
import ntu.edu.nhom13.services.ScientistService;
import ntu.edu.nhom13.services.TitleService;
@Controller
public class AdminController {
	
	@Autowired
    private ScientistService scientistService;
	
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
        ScientistDTO dto = ScientMapper.fromEntity(scientist);
        model.addAttribute("scientist", dto);
        return "admin/editScientist";
    }

    @PostMapping("/admin/edit/save")
    public String editScientist(@Valid ScientistDTO scientistDTO, BindingResult bindingResult, Model model) throws IOException {
        scientistService.saveScientist(scientistDTO);
        return "redirect:/admin/scientistList";
    }


}
