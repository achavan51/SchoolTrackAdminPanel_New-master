package com.fidelit.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fidelit.model.SchoolAdmin;
import com.fidelit.service.AuthenticationService;
import com.fidelit.service.SchoolAdminService;

@Controller
public class DefaultController {

@Autowired
private AuthenticationService authenticationService;
	
@RequestMapping(value="default")
public String defaultUrl(ModelMap model,HttpServletRequest req,SecurityContextHolderAwareRequestWrapper request){
	
	HttpSession session = req.getSession();
	
	Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//	req.getAuthType();
	String url="";
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	if(userName != null){
		SchoolAdmin currentUser = authenticationService.authenticateUser(userName);
		Object accountType = session.getAttribute("currentAccountType");
	
	if(accountType == null)	{
		
		 model.addAttribute("message", "Please Login Again !");
		 return "login";
		 
	}else if(!accountType.toString().equals(currentUser.getAccountType())){
				 model.addAttribute("message", "Authentication Failed");
			  return "login";  
		}
		session.setAttribute("currentUser", currentUser);
	}else{
		 model.addAttribute("message", "Authentication Failed");
		 return "login";
	}
	
	
	
	
	if(authorities.toString().contains("ROLE_ADMIN")){
		 url = "admin_home";
		 
	}else if(authorities.toString().contains("ROLE_PARENT")){
		url = "parent_home";
	}else if(authorities.toString().contains("ROLE_STUDENT")){
		url = "student_home";
	}else{
		url = "schoolAdminHome";
	}
	return url;	
}
}
