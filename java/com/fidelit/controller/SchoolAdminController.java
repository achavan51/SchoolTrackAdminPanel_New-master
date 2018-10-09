package com.fidelit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;













import com.fidelit.model.Employee;
import com.fidelit.model.Holidays;
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.SuperVisor;
import com.fidelit.model.empLeavesTaken;
import com.fidelit.service.EmployeeService;
import com.fidelit.service.HolidayService;
import com.fidelit.service.LeaveService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;
import com.fidelit.service.UserService;

import flexjson.JSONSerializer;


@Controller
@RequestMapping({"/schoolAdmin"})
public class SchoolAdminController {
	
	@Autowired	
	  private SchoolService schoolService;
	
	@Autowired
		private SchoolAdminService schoolAdminService;
	
	
	
	  @ResponseBody
	  @RequestMapping("/profile")
	  public void profile(HttpServletRequest request,HttpServletResponse response){
	  	
	   HttpSession session = request.getSession();	  
	   SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	   
	   response.setContentType("application/json; charset=UTF-8");
	   Map<String,Object> map = new HashMap<String,Object>();
	   map.put("accountId", currentUser.getAccountId());
	   map.put("accountType", currentUser.getAccountType());
	   map.put("name", currentUser.getName());
	   map.put("address", currentUser.getAddress());
	   map.put("email", currentUser.getEmail());
	   map.put("city", currentUser.getCity());
	   map.put("school", currentUser.getSchool());
	   map.put("userName", currentUser.getUsername());
	   map.put("age", currentUser.getAge());
	   
		try {
			response.getWriter().print(new JSONSerializer().exclude("class","*.class", "authorities").deepSerialize(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

	
	
	
	@RequestMapping(value="/home" )
	public String userHome(){
		return "schoolAdminHome";
	}
	
	@RequestMapping(value="/parentList")
	public String allParentList(ModelMap model){
		List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList();
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList=schoolService.allSchoolList();
		model.addAttribute("schoolList", schoolList);
		return "parentList";
	}
	
	@RequestMapping(value="/studentList")
	public String allStudentList(ModelMap model){
		List<SchoolAdmin> schoolAdminList= schoolAdminService.getAllStudentList();
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList=schoolService.allSchoolList();
		model.addAttribute("schoolList", schoolList);
		return "studentList";
	}
	
	@RequestMapping(value = "/deleteParentList")
	public String deleteParentList(@RequestParam("list") String str,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			schoolAdminService.deleteSchoolAdmin(id);
		}
		

	    List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList();
		model.addAttribute("schoolAdminList", schoolAdminList);
		return "parentList";
	}

	@RequestMapping(value = "/deleteStudentList")
	public String deleteStudentList(@RequestParam("list") String str,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			schoolAdminService.deleteSchoolAdmin(id);
		}

	    List<SchoolAdmin> schoolAdminList= schoolAdminService.getAllStudentList();
		model.addAttribute("schoolAdminList", schoolAdminList);
		return "studentList";
	}
	
	
}
