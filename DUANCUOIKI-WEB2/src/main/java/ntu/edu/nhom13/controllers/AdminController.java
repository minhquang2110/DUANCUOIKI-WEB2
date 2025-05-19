package ntu.edu.nhom13.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import ntu.edu.nhom13.entity.Admin;
@Controller
public class AdminController {
	 @GetMapping("/admins/profile")
	    public String profileAdmin(Model model,HttpSession session) {
	    	Admin account = (Admin) session.getAttribute("user");
	    	if(account==null) {
	    		return "redirect:/login";
	    	}
	    	model.addAttribute("admin",account);
	    	return "/admin/details_admin";
	    }
}
