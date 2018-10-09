package com.fidelit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fidelit.model.Account;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.service.AuthenticationService;

@Controller
@RequestMapping("/loginAuth")
public class AuthenticationController {

	@Autowired
    AuthenticationService authenticationService;
    
	@RequestMapping("/authenticate")
	public String authenticate(@RequestParam("account") String accountId,@RequestParam("username") String username,@RequestParam("password") String password,ModelMap model){
		
		SchoolAdmin account = authenticationService.authenticateUser(username, password,accountId);
		
		if(account!=null){
			if(account.getAccountType().equals("Admin")){
				return "admin_home";
		    
			}else if(account.getAccountType().equals("SchoolAdmin")){
				return "user_home";
			
			}else if(account.getAccountType().equals("Parent")){
				return "admin_home";

			}else if(account.getAccountType().equals("Student")){
			
				return "admin_home";
			}else{
					model.addAttribute("message", "Login Failed !");
					return "login";	
				}
		}
		else{
				model.addAttribute("message", "Login Failed !");
				return "login";	
		}
			
		
		
		
	}
}
