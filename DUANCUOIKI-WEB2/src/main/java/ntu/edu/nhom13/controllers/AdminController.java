package ntu.edu.nhom13.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import ntu.edu.nhom13.dto.ScientistDTO;
import ntu.edu.nhom13.entity.Admin;
import ntu.edu.nhom13.services.ScientistService;
@Controller
public class AdminController {
	
	@Autowired
    private ScientistService scientistService;
	
		@GetMapping("/admin/profile")
	    public String profileAdmin(Model model,HttpSession session) {
	    	Admin account = (Admin) session.getAttribute("user");
	    	if(account==null) {
	    		return "redirect:/login";
	    	}
	    	model.addAttribute("admin",account);
	    	return "/admin/details_admin";
	    }
	 
	 	@GetMapping("/admin/createScientist")
	    public String showCreateForm(Model model) {
	    	 model.addAttribute("scientist", new ScientistDTO());
	        return "admin/createScientist";
	    }

	    @PostMapping("/admin/createScientist/save")
	    public String createScientist( @ModelAttribute ScientistDTO scientist,Model model) throws IOException {
	    	scientistService.saveScientist(scientist,model);
	        return "redirect:/scientist/scientistList";
	    }


	    @GetMapping("/admin/delete/scientist/{id}")
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
