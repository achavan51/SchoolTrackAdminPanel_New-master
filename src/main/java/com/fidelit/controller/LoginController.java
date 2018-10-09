package com.fidelit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  
public class LoginController {  
  
 @RequestMapping("login")  
 public String  getLoginForm(  
   @RequestParam(required = false) String authfailed, String logout,  
   String denied,ModelMap model,HttpServletRequest req) {
	
  if(authfailed != null){
	 model.addAttribute("message", "Username/Password Wrong");
  }else if(denied != null){
	  model.addAttribute("message", "Access denied");
  }
	
	 
  return "login";  
 }  
  
 @RequestMapping("user")  
 public String geUserPage() {  
  return "user";  
 }  
  
 @RequestMapping("admin")  
 public String geAdminPage() {  
  return "admin";  
 }  
  
 @RequestMapping("403page")  
 public String ge403denied() {  
  return "redirect:login?denied";  
 }  
  
}  