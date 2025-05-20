package ntu.edu.nhom13.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ntu.edu.nhom13.entity.Account;
import ntu.edu.nhom13.entity.Admin;
import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.services.AccountService;
import ntu.edu.nhom13.services.AdminService;
import ntu.edu.nhom13.services.ScientistService;
@Controller
public class UserController{
	@Autowired
	private AccountService accountService;
	@Autowired
	private ScientistService scientistService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ScientistController scientistController;
	@Autowired
	private AdminController adminController;
	
	@GetMapping("/loginTemplate")
	public String lo() {
		return "/users/login";
	}
	@GetMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model model,HttpSession session) {
		Account a=accountService.findByUsername(username);
		if(a==null) {
			return "users/login";
		}
		if(a.getPassword().equals(password)) {
			if(a.getRole().toString().equals("Admin")) {
				session.setAttribute("user", adminService.getAdminByAccountId(a.getAccountId()));
				return "redirect:/admins/profile";
			}else {
				session.setAttribute("user", scientistService.getScientistByAccountId(a.getAccountId()));
		        return "redirect:/scientists/profile";
			}
		}else {
			return "users/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session!=null) {
			session.removeAttribute("user");
		}
		return "users/login";
	}
}