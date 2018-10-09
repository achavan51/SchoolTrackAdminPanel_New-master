package com.fidelit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.fidelit.model.BusDriver;
import com.fidelit.model.Employee;
import com.fidelit.model.Holidays;
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.Route;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.SuperVisor;
import com.fidelit.model.empLeavesTaken;
import com.fidelit.service.EmployeeService;
import com.fidelit.service.GtsService;
import com.fidelit.service.HolidayService;
import com.fidelit.service.LeaveService;
import com.fidelit.service.RouteService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;
import com.fidelit.service.UserService;


@Controller
@RequestMapping({"/user"})
public class UserController {
	
	@Autowired	
	  private UserService userService;
	
	@Autowired	
	  private HolidayService holidayService;
	
	@Autowired	
	  private LeaveService leaveService;
	
	@Autowired	
	  private SchoolService schoolService;
	
	@Autowired
		private SchoolAdminService schoolAdminService;
	
	@Autowired
	private GtsService gtsService;
	
	@Autowired
	RouteService routeService;
	
	@RequestMapping(value="/home" )
	public String userHome(){
		return "user_home";
	}
	
	@RequestMapping(value="/parentList")
	public String allParentList(ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList=schoolService.allSchoolList(userName);
		model.addAttribute("schoolList", schoolList);
		return "parentList";
	}
	
	@RequestMapping(value="/studentList")
	public String allStudentList(ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList=schoolService.allSchoolList(userName);
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
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	    List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
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
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	    List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		return "studentList";
	}
	
	@RequestMapping(value="/leaveApply" )
	public String addLeave(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
		LeavesApplied leavesApplied = new LeavesApplied();
		String start = request.getParameter("leaveStart");
		String end= request.getParameter("leaveEnd");
		String reason = request.getParameter("leaveReason");
		
		if(start != null && end != null){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date leaveStart = formatter.parse(start);
		System.out.println(leaveStart);
		leavesApplied.setLeaveStart(leaveStart);		
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date leaveEnd = format.parse(end);
		//leaveEnd = new Date();
		leavesApplied.setLeaveEnd(leaveEnd);
		}

		if(leavesApplied.getLeaveStart()!=null && leavesApplied.getLeaveEnd()!=null )
		{
		
			
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		     String name = auth.getName(); //get logged in username
		   Employee employee = userService.getEmployeeByUsername(name);
		   System.out.println("supervisor ID="+employee.getSupervisor().getSuperVisorId());
		   SuperVisor supervisor=employee.getSupervisor();
		  
		leavesApplied.setEmployee(employee);
		leavesApplied.setSupervisor(supervisor);
		leavesApplied.setLeaveStatus("pending");	
		String days=request.getParameter("workingDays");
		int workingDays=Integer.parseInt(days);
		leavesApplied.setWorkingDays(workingDays);
		leavesApplied.setLeaveReason(reason);
	
			userService.addLeave(leavesApplied);
			Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
		     String namee = auth1.getName(); //get logged in username
			 Employee employeee = userService.getEmployeeByUsername(namee);
			 int id = employeee.getId();
			java.util.List<LeavesApplied> leaveList= userService.allLeaveHistoryList(id);
			model.addAttribute("leavesApplied", leaveList);
			
			
			return "leaveHistory";
		}
		
		return "leave_apply";
	}

	
	@RequestMapping(value="/leaveBalance" )
	public String allLeaveBalanceList(ModelMap model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName(); //get logged in username
		 Employee employee = userService.getEmployeeByUsername(name);
		 int id = employee.getId();
		java.util.List<empLeavesTaken> leaveList= userService.allLeaveBalanceList(id);
		model.addAttribute("empLeavesTaken", leaveList);
		
		return "leaveBalance";
	}
	
	
	@RequestMapping(value="/leaveHistory" )
	public String allLeaveHistoryList(ModelMap model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName(); //get logged in username
		 Employee employee = userService.getEmployeeByUsername(name);
		 int id = employee.getId();
		java.util.List<LeavesApplied> leaveList= userService.allLeaveHistoryList(id);
		model.addAttribute("leavesApplied", leaveList);
		
		
		return "leaveHistory";
	}

	@RequestMapping(value="/userHolidayList")
	public String allHolidayList(ModelMap model){
		List<Holidays> holidayList= holidayService.allHolidayList();
		model.addAttribute("holidayList", holidayList);
		return "userHolidayList";
	}
	
	@RequestMapping(value="/userProjectList")
	public String userProjectList(ModelMap model){
		
		return "userProjectList";
	}
	
	@RequestMapping(value="/leaveWithdraw")
	public String leaveWithdraw(@RequestParam("id") Integer id,@RequestParam("status") String status,ModelMap model)
	{
		
		leaveService.leaveWithdraw(id,status);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName(); //get logged in username
		 Employee employee = userService.getEmployeeByUsername(name);
		 int idd = employee.getId();
		java.util.List<LeavesApplied> leaveList= userService.allLeaveHistoryList(idd);
		model.addAttribute("leavesApplied", leaveList);
		
		
		return "leaveHistory";
		
	}
	
	@ResponseBody
	 @RequestMapping(value="/testMethod", method=RequestMethod.POST)
	
	public String testMethod(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String list = request.getParameter("accessList");
		System.out.println(list);
			System.out.println(new Date());
		Date dNow = new Date( );
	      SimpleDateFormat ft = 
	    		  new SimpleDateFormat ("EEE MMM dd HH:mm:ss zzz yyyy");
	      System.out.println("Current Date: " + ft.format(dNow));
	      
		String [] dateList = list.split(",");
		 //Date [] dates = new Date[dateList.length];
		 int cnt=0;
		for(int i=0;i<dateList.length;i++){
			//System.out.println("Before Parse"+dateList[i].toString());
			//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			//dates[i] = formatter.parse(dateList[i]);
			boolean flag = false;
			//System.out.println("After Parse"+dates[i].toString());
			 flag = userService.checkDate(dateList[i]);
			if(!flag){
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
		return String.valueOf(cnt);
	}
	
	@ResponseBody
	@RequestMapping(value="/dateSelect", method=RequestMethod.POST)

	public String empSelect(HttpServletRequest request,HttpServletResponse response) throws Exception{

		List<Holidays> holidayList=holidayService.getHolidayDate();
		
		String name = null;
		for (Holidays holiday : holidayList) {
			if(name == null){
				//name = employee.getId()+","+employee.getfirstName()+";";
				name = holiday.getHolidayDate()+",";
			}
			else{
				//name = name + employee.getId()+","+employee.getfirstName()+";";
				name = name + holiday.getHolidayDate() + ",";
			}
			
			//System.out.println(employee.getfirstName());
		}
		name = name.substring(0, name.length()-1);
		System.out.println("name:"+name);
		return name;
				
		
	}
	
	@ResponseBody
	@RequestMapping(value="/editStudent",method = RequestMethod.POST)
	public String editStudent(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String list = request.getParameter("list");
		String [] dataList = list.split(",");
		SchoolAdmin schoolAdmin = new SchoolAdmin();
		School school =schoolService.getSchool(dataList[2]);
		Integer studentId=Integer.parseInt(dataList[0]);
		Integer age=Integer.parseInt(dataList[5]);
		
		schoolAdmin.setId(studentId);
		schoolAdmin.setName(dataList[1]);
		schoolAdmin.setSchool(school);
		schoolAdmin.setAddress(dataList[3]);
		schoolAdmin.setEmail(dataList[4]);
		schoolAdmin.setAge(age);
		schoolAdmin.setCity(dataList[6]);
		schoolAdmin.setPassword(dataList[7]);
		schoolAdmin.setUsername(dataList[8]);
		schoolAdmin.setAccountType(dataList[9]);
		Route route = routeService.getRouteId(Integer.parseInt(dataList[10]));
		schoolAdmin.setRoute((List<Route>) route);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		schoolAdmin.setAccountId(userName);
		model.addAttribute(new SchoolAdmin());
		schoolAdminService.updateSchoolAdmin(schoolAdmin);
		gtsService.editAccountInGts(dataList[1], dataList[7], dataList[9]);
		
		return "Ok";
	}


	@ResponseBody
	@RequestMapping(value="/editParent",method = RequestMethod.POST)
	public String editParent(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String list = request.getParameter("list");
		String [] dataList = list.split(",");
		for (String string : dataList) {
			System.out.println("datalist:"+string);
		}
		SchoolAdmin schoolAdmin = new SchoolAdmin();
		School school =schoolService.getSchool(dataList[2]);
		Integer parentId=Integer.parseInt(dataList[0]);
		Integer age=Integer.parseInt(dataList[5]);
		schoolAdmin.setId(parentId);
		schoolAdmin.setName(dataList[1]);
		schoolAdmin.setSchool(school);
		schoolAdmin.setAddress(dataList[3]);
		schoolAdmin.setEmail(dataList[4]);
		schoolAdmin.setAge(age);
		schoolAdmin.setCity(dataList[6]);
		schoolAdmin.setPassword(dataList[7]);
		schoolAdmin.setUsername(dataList[8]);
		schoolAdmin.setAccountType(dataList[9]);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		schoolAdmin.setAccountId(userName);
		model.addAttribute(new SchoolAdmin());
		schoolAdminService.updateSchoolAdmin(schoolAdmin);
		gtsService.editAccountInGts(dataList[1], dataList[7], dataList[9]);
		return "Ok";
	}

	
}
