	package ntu.edu.nhom13.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@PostMapping("/login")
//	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model model,HttpSession session) {
//		Account a=accountService.findByUsername(username);
//		if(a==null) {
//			return "users/login";
//		}
//		System.out.println(a.getUsername());
//		if(a.getPassword().equals(password)) {
//			if(a.getRole().toString().equals("Admin")) {
//				session.setAttribute("user", adminService.getAdminByAccountId(a.getAccountId()));
//				return "redirect:/admins/profile";
//			}else {
//				session.setAttribute("user", scientistService.getScientistByAccountId(a.getAccountId()));
//		        return "redirect:/scientists/profile";
//			}
//		}else {
//			return "users/login";
//		}
//	}
//	
	@GetMapping("user/logout")
	public String logout(HttpSession session) {
		if(session!=null) {
			session.removeAttribute("user");
		}
		return "users/login";
	}

	@GetMapping("user/forgot-password")
	public String showForgotPasswordForm() {
		return "users/forgot-password";
	}

	@GetMapping("user/reset-password")
	public String resetPassword(
			@RequestParam("username") String username,
			@RequestParam("newPassword") String newPassword,
			Model model
	) {
		Account account = accountService.findByUsername(username);

		if (account != null) {
			account.setPassword(newPassword); // Nếu dùng mã hoá thì xử lý ở đây
			accountService.saveAccount(account);
			model.addAttribute("message", "Đặt lại mật khẩu thành công. Vui lòng đăng nhập lại.");
		} else {
			model.addAttribute("error", "Không tìm thấy tài khoản với username đã nhập.");
		}

		return "users/forgot-password";
	}


	private boolean isValidPassword(String password) {
		return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
	}
	@GetMapping("user/change-password")
	public String showChangePasswordForm() {
		return "users/change-password"; // Trả về trang HTML chứa form
	}


	@PostMapping("user/change-password")
	public String changePassword(
			@RequestParam("username") String username,
			@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword,
			Model model
	) {
		Account account = accountService.findByUsername(username);

		if (account == null) {
			model.addAttribute("error", "❌ Tên đăng nhập không tồn tại.");
			return "users/change-password";
		}

		if (!account.getPassword().equals(currentPassword)) {
			model.addAttribute("error", "❌ Mật khẩu hiện tại không chính xác.");
			return "users/change-password";
		}

		if (!isValidPassword(newPassword)) {
			model.addAttribute("error", "❌ Mật khẩu mới phải có ít nhất 8 ký tự, gồm chữ hoa, chữ thường và số.");
			return "users/change-password";
		}

		account.setPassword(newPassword);
		accountService.saveAccount(account);

		model.addAttribute("message", "✅ Đổi mật khẩu thành công.");
		return "users/change-password";
	}


}