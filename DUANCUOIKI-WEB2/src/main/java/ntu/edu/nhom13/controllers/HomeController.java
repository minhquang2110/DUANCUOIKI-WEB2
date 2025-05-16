package ntu.edu.nhom13.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ntu.edu.nhom13.entity.HomeEntity;
import ntu.edu.nhom13.entity.ScientistEntity;
import ntu.edu.nhom13.services.HomeService;

@Controller
public class HomeController{
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/scientist")
	String read(Model model) {
		 ScientistEntity list = homeService.sci().getFirst();
		 model.addAttribute("content", list);
		    return "index";
	}
	
	
}