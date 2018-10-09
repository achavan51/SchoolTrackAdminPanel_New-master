package com.fidelit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/student"})
public class StudentController {
	
	@RequestMapping("/home")
	public String adminHome(){
		
		return "student_home";
	}

}
