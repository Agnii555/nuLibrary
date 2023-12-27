package com.oodProject.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oodProject.library.pojo.Library;
import com.oodProject.library.pojo.Person;

@Controller 
public class HomeController {
	
	
	@GetMapping("")
	public String viewHomepage()

	{
		
		return "index";	
		
	}
	
	
	@GetMapping("/AdminLogin") 
	public String createPerson(Model model) {
		
	
		
		return "admin_login";
		
	}
	
	@GetMapping("/LibrarianLogin")
	public String libraianLogin(Model model) {
		
		return "librarian_login";
	}
	
	
	@GetMapping("/MemberLogin")
	public String memberLogin(Model model) {
		
	        return "member_login";
	}

}
