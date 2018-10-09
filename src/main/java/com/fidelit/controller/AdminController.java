package com.fidelit.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fidelit.model.Clients;
import com.fidelit.model.Employee;
import com.fidelit.model.EmployeeProject;
import com.fidelit.model.Extintor;
import com.fidelit.model.Holidays;
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.Project;
import com.fidelit.model.Route;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.SuperVisor;
import com.fidelit.model.UserRole;
import com.fidelit.service.ClientService;
import com.fidelit.service.EmployeeProjectService;
import com.fidelit.service.EmployeeService;
import com.fidelit.service.GtsService;
import com.fidelit.service.RouteService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;
import com.fidelit.service.HolidayService;
import com.fidelit.service.LeaveService;
import com.fidelit.service.ProjectService;

import flexjson.JSONSerializer;


@Controller
@RequestMapping({"/admin"})
public class AdminController {
   
  @Autowired	
  private EmployeeService employeeService;
  @Autowired
  private ClientService clientService;
  @Autowired
  private ProjectService projectService;
  @Autowired
  private LeaveService leaveService;
  @Autowired
  private HolidayService holidayService;
  @Autowired
  private EmployeeProjectService employeeProjectService;
  
  @Autowired
  private SchoolService schoolService;
  
  @Autowired
  private SchoolAdminService schoolAdminService;
  
  @Autowired
  private RouteService routeService;
  
  @Autowired
  private GtsService gtsService;
  
  @RequestMapping("/")
  private String hande404(){
	  
	return "page404";
	  
  }
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
  
@RequestMapping("/home")
public String adminHome(ModelMap model){
	model.addAttribute("homeActive", "homeActive");
	return "admin_home";
}
@RequestMapping(value = "/employeeManagement")
public String employeeManagement() {
	
	
	return "admin_employee_management";
}

@RequestMapping("/checkUserName")
public @ResponseBody String checkUserName(HttpServletRequest request){
    String userName = request.getParameter("userName"); 
    boolean flag = employeeService.checkUserName(userName);
    if(flag == true){
    	return "true";
    }
	return "false";		
}


@RequestMapping("/checkClientUsername")
public @ResponseBody String checkClientUsername(HttpServletRequest request){
    String userName = request.getParameter("ClientUsername"); 
    boolean flag = clientService.checkClientUsername(userName);
    if(flag == true){
    	return "true";
    }
	return "false";		
}

@ResponseBody
@RequestMapping(value="/addSchool" , method=RequestMethod.POST)
public String addSchool(@ModelAttribute("school") School school,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
	System.out.println("HII IN School");
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	
	String schoolName = null;
	String address = null;
	String details = null;
	String location = null;
	String city1 = null;
	
	if(request.getParameter("schoolName") != null){
		schoolName = request.getParameter("schoolName");
			System.out.println("schoolName:"+schoolName);
		}
	if(request.getParameter("address") != null){
		address = request.getParameter("address");
			System.out.println("address:"+schoolName);
		}
		if(request.getParameter("details") != null){
			details = request.getParameter("details");
				System.out.println("details:"+details);
			}	
			if(request.getParameter("location") != null){
				location = request.getParameter("location");
					System.out.println("location:"+location);
				}
				
				if(request.getParameter("city1") != null){
					city1 = request.getParameter("city1");
						System.out.println("city1:"+city1);
					}
	
	
	school.setAccountId(userName);
	schoolService.addSchool(school);
	List<School> schoolList= schoolService.allSchoolList(userName);
	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute(new School());
	model.addAttribute("schoolList", schoolList);
	model.addAttribute("schoolsActive", "schoolsActive");
	model.addAttribute(new School());	
	return "schoolList";	

}

@ResponseBody
@RequestMapping(value="/editSchool",method = RequestMethod.POST)
public String editSchool(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
	System.out.println("In edit school");
	String list = request.getParameter("list");
	String [] dataList = list.split(",");
	
	for (String string : dataList) {
		System.out.println("DataList:"+string);
	}
	School school = new School();
	
	Integer Id=Integer.parseInt(dataList[0]);
	school.setId(Id);
	school.setSchoolName(dataList[1]);
	school.setAddress(dataList[2]);
	school.setDetails(dataList[3]);
	school.setCity(dataList[4]);
	school.setLocation(dataList[5]);
	
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	
	school.setAccountId(userName);
	model.addAttribute(new SchoolAdmin());
	schoolService.updateSchool(school);
	
	List<School> schoolList= schoolService.allSchoolList(userName);
	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute("schoolsActive", "schoolsActive");
	model.addAttribute("schoolList", schoolList);
	
	return "schoolList";	
}



@ResponseBody
@RequestMapping(value="/checkUniqueUserName" , method=RequestMethod.POST)
public boolean checkUniqueUserName(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
	String userName = request.getParameter("userName");
	System.out.println("userName:::"+userName);
	boolean val = schoolAdminService.getUniqueUserName(userName);
	return val;
	
}

@ResponseBody
@RequestMapping(value="/addSchoolAdmin" , method=RequestMethod.POST)
public String addClient(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	String list = request.getParameter("accessList");
	String SchoolName=request.getParameter("schoolName");
	String [] dataList = list.split(",");
	String SchoolName1=dataList[6];
	School school=schoolService.getSchool(SchoolName1);
	SchoolAdmin schoolAdmin = new SchoolAdmin();
	schoolAdmin.setName(dataList[0]);
	schoolAdmin.setAddress(dataList[1]);
	schoolAdmin.setPassword(dataList[3]);
	schoolAdmin.setEmail(dataList[2]);
	schoolAdmin.setAge(Integer.parseInt(dataList[4]));
	schoolAdmin.setCity(dataList[5]);
	schoolAdmin.setAccountType(dataList[8]);
	schoolAdmin.setUsername(dataList[7]);
	schoolAdmin.setSchool(school);
	schoolAdmin.setEnabled(true);
	gtsService.addAccountInGts(schoolAdmin.getUsername(),schoolAdmin.getPassword(),schoolAdmin.getAccountType());
	if(dataList[8].equals("Student")){
		schoolAdmin.setRole("ROLE_STUDENT");
	}else if(dataList[8].equals("SchoolAdmin")){
		schoolAdmin.setRole("ROLE_SCHOOLADMIN");
	}else if(dataList[8].equalsIgnoreCase("Parent")){
		schoolAdmin.setRole("ROLE_PARENT");
	}else if(dataList[8].equalsIgnoreCase("Admin")){
		schoolAdmin.setRole("ROLE_ADMIN");
	}
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	schoolAdmin.setAccountId(userName);
	schoolAdminService.addSchoolAdmin(schoolAdmin);
	List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute("schoolAdminList", schoolAdminList);
	model.addAttribute("schoolAdminActive", "schoolAdminActive");
	return "schoolAdmin";
}

@ResponseBody
@RequestMapping(value="/editSchoolAdmin" , method=RequestMethod.POST)
public String editSchoolAdmin(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	System.out.println("in schooladmin edit");
	String list = request.getParameter("list");
	String SchoolName=request.getParameter("schoolName");
	String [] dataList = list.split(",");
	int cnt = 0;
	for (String string : dataList) {
		
		System.out.println("cnt:"+cnt+":"+string);
			cnt++;
	}
	
	SchoolAdmin schoolAdmin = new SchoolAdmin();
	schoolAdmin.setId(Integer.parseInt(dataList[0]));
	schoolAdmin.setName(dataList[1]);
	String SchoolName1=dataList[2];
	School school=schoolService.getSchool(SchoolName1);
	schoolAdmin.setAddress(dataList[3]);
	schoolAdmin.setEmail(dataList[4]);
	schoolAdmin.setAge(Integer.parseInt(dataList[5]));
	schoolAdmin.setCity(dataList[6]);
	schoolAdmin.setAccountType("SchoolAdmin");
	schoolAdmin.setPassword(dataList[7]);
	schoolAdmin.setUsername(dataList[8]);
	schoolAdmin.setSchool(school);
	schoolAdmin.setEnabled(true);
	gtsService.editAccountInGts(schoolAdmin.getUsername(),schoolAdmin.getPassword(),schoolAdmin.getAccountType());
	
		schoolAdmin.setRole("ROLE_SCHOOLADMIN");
	
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	schoolAdmin.setAccountId(userName);
	schoolAdminService.updateSchoolAdmin(schoolAdmin);
	List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute("schoolAdminList", schoolAdminList);
	model.addAttribute("schoolAdminActive", "schoolAdminActive");
	return "schoolAdmin";
}


@RequestMapping(value="/schoolList")
public String allSchoolList(@ModelAttribute("school") School school,HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
	
	
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	List<School> schoolList= schoolService.allSchoolList(userName);
	for (School school2 : schoolList) {
		System.out.println("School    "+school2.getSchoolName());
	}
	System.out.println("School"+school.getAddress());
	
	System.out.println("School"+school.getSchoolName());
	String action="action";
	if(request.getParameter("action")!=null){
		action=request.getParameter("action");
	}
	
	System.out.println("Action: "+action);
	if(action!=null){
		if(action.equals("add")){
		
		
		
		school.setAccountId(userName);
		schoolService.addSchool(school);
		schoolList= schoolService.allSchoolList(userName);
		model.addAttribute(new School());
		model.addAttribute("success","success");
		model.addAttribute("schoolList", schoolList);
	
		}
	}
	if(action.equals("edit")){
		
		int id=Integer.parseInt(request.getParameter("schoolID"));
		school.setId(id);
		school.setAccountId(userName);
		schoolService.updateSchool(school);

	    schoolList= schoolService.allSchoolList(userName);
	    model.addAttribute(new School());
	    model.addAttribute("edit","edit");
		model.addAttribute("schoolList", schoolList);
	}
	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	
	model.addAttribute("schoolList", schoolList);
	model.addAttribute(new School());
	model.addAttribute("schoolsActive", "schoolsActive");
	
	return "schoolList";
}





@RequestMapping(value="/reports")
public String allClientList(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	

	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute("reportActive", "reportActive");
	return "reports";
}




@RequestMapping(value="/schoolAdmin")
public String allSchoolAdminList(@ModelAttribute("schoolAdmin") SchoolAdmin schoolAdmin,HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
	   String action="action";
	   if(request.getParameter("action")!=null){
		    action=request.getParameter("action");
	   }
	   if(action.equals("add")){
		
		 schoolAdmin.setRole("ROLE_SCHOOLADMIN");
	
		schoolAdmin.setEnabled(true);
		gtsService.addAccountInGts(schoolAdmin.getUsername(),schoolAdmin.getPassword(),schoolAdmin.getAccountType());
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		schoolAdmin.setAccountId(userName);
		schoolAdmin.setAccountType("SchoolAdmin");
		schoolAdminService.addSchoolAdmin(schoolAdmin);
		model.addAttribute("success","success");
		model.addAttribute(new SchoolAdmin());
	}
	   
	   if(action.equals("edit")){
			//	School school =schoolAdmin.getSchool();
				schoolAdmin.setAccountType("SchoolAdmin");
				model.addAttribute(new SchoolAdmin());
				schoolAdmin.setRole("ROLE_SCHOOLADMIN");
				schoolAdmin.setEnabled(true);
				String userName = SecurityContextHolder.getContext().getAuthentication().getName();
				schoolAdmin.setAccountId(userName);
			//	schoolAdmin.setSchool(school);
				schoolAdminService.updateSchoolAdmin(schoolAdmin);
				model.addAttribute("edit","edit");
				
			}
			
	  
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
	model.addAttribute("schoolAdminList", schoolAdminList);
	List<School> schoolList=schoolService.allSchoolList(userName);
	List<Route> routeList=routeService.allRouteList(userName);

	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute(new SchoolAdmin());
	model.addAttribute("schoolList", schoolList);
	model.addAttribute("schoolAdminActive", "schoolAdminActive");
	model.addAttribute("routeList", routeList);
	return "schoolAdmin";
}

@RequestMapping(value="/projectList")
public String allProjectList(ModelMap model){
	List<Project> projectList= projectService.allProjectList();
	model.addAttribute("projectList", projectList);
	return "projectList";
}


@RequestMapping(value="/routes")
public String allLeaveList(ModelMap model){
	List<LeavesApplied> leaveList= leaveService.allLeaveList();
	model.addAttribute("leaveList", leaveList);
		return "leaveList";
}


@RequestMapping(value="/settings")
public String allHolidayList(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	

	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute("settingActive", "settingActive");
	return "settings";
}

@RequestMapping(value = "/checkDriverInRoute")
public String checkDriverInRoute(@RequestParam("deleteData") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
	System.out.println("IN Driver Route");
	boolean status = false;
	String result = null;
	str = str.substring(0, str.length()-1);
	String[] str1 = str.split(",");
	for (int i = 0; i < str1.length; i++) {
		int id = Integer.parseInt(str1[i]);
		 //status = routeService.getDriverName(id);
		if(status == true){
			break;
		}
	}
	if(status == true){
		result = "false";
	}else{
		result = "true";
	}
	return result;
}

@RequestMapping(value = "/deleteSchoolList")
public String deleteEmployeeList(@RequestParam("list") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
	str = str.substring(0, str.length()-1);
	String[] str1 = str.split(",");
	
	for (int i = 0; i < str1.length; i++) {
		
		int id = Integer.parseInt(str1[i]);
		
			
			schoolService.deleteSchool(id);
	
		
		model.addAttribute(new School());
		
	}
	
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	List<School> schoolList= schoolService.allSchoolList(userName);
	

	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
	model.addAttribute("schoolsActive", "schoolsActive");
	model.addAttribute("schoolList", schoolList);
	return "schoolList";
}


@ResponseBody
@RequestMapping(value = "/checkDependancyOfStudentInSchool",method = RequestMethod.POST)
public String checkDependancyOfStudentInSchool(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	String status = null;
	
	String dataList = request.getParameter("list");
	dataList = dataList.substring(0, dataList.length()-1);
	String[] str1 = dataList.split(",");
	System.out.println("dataList:"+dataList);
	List<SchoolAdmin> schoolAdminListForStudent = null;
	List<SchoolAdmin> schoolAdminListForSchoolAdmin = null;
	//List<Extintor> extintorList = null;
	for (int i = 0; i < str1.length; i++) {
		schoolAdminListForStudent=schoolAdminService.checkStudentInSchool(str1[i]);
		schoolAdminListForSchoolAdmin=schoolAdminService.checkSchoolAdminInSchool(str1[i]);
	//	extintorList=extinctorService.allExtintorListForBus(str1[i]);
		System.out.println("schoolAdminListForStudent:"+schoolAdminListForStudent.toString());
		System.out.println("schoolAdminListForSchoolAdmin:"+schoolAdminListForSchoolAdmin.toString());
	//	System.out.println("RouteList1:"+routeList.isEmpty());
	if(schoolAdminListForStudent.isEmpty() && schoolAdminListForSchoolAdmin.isEmpty()){
		status = "false";
	}else{
		status = "true";
		break;
	}
	
	}
	return status;
}


@RequestMapping(value = "/deleteSchoolAdminList")
public String deleteClientList(@RequestParam("list") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
	str = str.substring(0, str.length()-1);
	String[] str1 = str.split(",");
	for (String string : str1) {
		System.out.println("IN delete:"+string);
	}
	for (int i = 0; i < str1.length; i++) {
		int id = Integer.parseInt(str1[i]);
		String accountID = schoolAdminService.getNameFromId(id);
		System.out.println("accountID:"+accountID);
		
		gtsService.deleteAccountInGts(accountID);
		model.addAttribute(new SchoolAdmin());
		schoolAdminService.deleteSchoolAdmin(id);
	}
	
	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
    List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
	

	HttpSession session = request.getSession();
	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
	String username = currentUser.getUsername();
	model.addAttribute("userName", username);
    
    model.addAttribute("schoolAdminList", schoolAdminList);
	return "schoolAdmin";
}




}


