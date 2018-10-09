package com.fidelit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/parent"})
public class ParentController {
	
	@RequestMapping("/home")
	public String adminHome(){
		
		return "parent_home";
	}

}
