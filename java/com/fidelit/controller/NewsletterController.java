package com.fidelit.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fidelit.model.Bus;
import com.fidelit.model.Extintor;
import com.fidelit.model.Newsletter;
import com.fidelit.model.Route;
import com.fidelit.service.NewsletterService;

@Controller
@RequestMapping({"/newsletter"})
public class NewsletterController {
	
	@Autowired
	NewsletterService newsletterService;
	
	@RequestMapping(value="newsletterList")
	public String newsletterList(ModelMap model){
		List<Newsletter> newsletterList = newsletterService.getNewsletterList();
		model.addAttribute("newsletterList",newsletterList);
		model.addAttribute(new Newsletter());
		return "newsletterList";
	}
	
	@RequestMapping(value="addNewsletter",method = RequestMethod.POST)
	public String addExtintor(@ModelAttribute("newsletter") Newsletter newsletter,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		newsletter.setDate(dateFormat.parse(dateFormat.format(date)));
		newsletterService.addNewsletter(newsletter);
		List<Newsletter> newsletterList =newsletterService.getNewsletterList();
		model.addAttribute("newsletterList",newsletterList);
		return "newsletterList";
	}
	
	@RequestMapping(value = "/deleteNewsletterList")
	public String deleteNewsletterList(@RequestParam("list") String str,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			
			
			newsletterService.deleteNewsletter(id);
			
		}
		

	    List<Newsletter> newsletterList= newsletterService.getNewsletterList();
		model.addAttribute("newsletterList", newsletterList);
		model.addAttribute(new Newsletter());
		return "newsletterList";
	}
	

}
