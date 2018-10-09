package com.fidelit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fidelit.model.Clients;
import com.fidelit.model.Employee;
import com.fidelit.model.EmployeeProject;
import com.fidelit.model.Holidays;
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.Project;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.SuperVisor;
import com.fidelit.model.UserRole;
import com.fidelit.service.ClientService;
import com.fidelit.service.EmployeeProjectService;
import com.fidelit.service.EmployeeService;
import com.fidelit.service.GtsService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;
import com.fidelit.service.HolidayService;
import com.fidelit.service.LeaveService;
import com.fidelit.service.ProjectService;

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
  private GtsService gtsService;
@RequestMapping("/home")
public String adminHome(){
	
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
public String addSchool(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
	System.out.println("HII IN School");
	
	String list = request.getParameter("accessList");
	
	String [] dataList = list.split(",");
	School school = new School();
	school.setSchoolName(dataList[0]); 
	school.setAddress(dataList[1]);
	school.setDetails(dataList[2]);
	school.setLocation(dataList[3]);
	school.setCity(dataList[4]);

	
	schoolService.addSchool(school);
	List<School> schoolList= schoolService.allSchoolList();
	
	model.addAttribute("schoolList", schoolList);
	return "schoolList";	

}


@ResponseBody
@RequestMapping(value="/addEmployee" , method=RequestMethod.POST)
public String addEmployee(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
	System.out.println("HII IN EMPLOYEE");
	
	String list = request.getParameter("accessList");
	System.out.println("in Employee:"+list);
	
	String [] dataList = list.split(",");
	for (int i = 0; i < dataList.length; i++) {
		System.out.println("i"+i+"="+dataList[i]);
	}
	Employee employee = new Employee();
	employee.setUserName(dataList[1]); 
	String id = dataList[0];
	int empId=Integer.parseInt(id);
	employee.setId(empId);
	String password =  dataList[2];
	employee.setPassword(password);
	String inputFirstName =  dataList[3];
	employee.setfirstName(inputFirstName);
	String inputLastName =  dataList[4];
	employee.setLastName(inputLastName);
	String inputBirthDate =  dataList[5];
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date birthDate = formatter.parse(inputBirthDate);
	employee.setBirthDate(birthDate);
	employee.setemail(dataList[8]);
	employee.setAddress(dataList[9]);
	employee.setCity(dataList[10]);
	employee.setState(dataList[11]);
	String inputZip =  dataList[12];
	int zip=Integer.parseInt(inputZip);
	employee.setZip(zip);
	employee.setCountry(dataList[13]);
	String inputPhone =  dataList[14];
	int phone=Integer.parseInt(inputPhone);
	employee.setPhone(phone);
	employee.setDesignation(dataList[15]);
	employee.setMaritalStatus(dataList[7]);
	employee.setSex(dataList[6]);
	UserRole userRole = new UserRole();
	//int rId=Integer.parseInt(dataList[17]);
	//userRole.setId(rId);
	userRole.setRole(dataList[16]);
	employee.setUserRole(userRole);
	userRole.setEmployee(employee);
	SuperVisor supervisor = new SuperVisor();
	System.out.println("[17] "+dataList[17]);
	int superVisorId = Integer.parseInt(dataList[17]);
	//int sId = Integer.parseInt(dataList[19]);
	supervisor.setEmployee(employee);
	//supervisor.setsId(sId);
	supervisor.setSuperVisorId(superVisorId);
	employee.setSupervisor(supervisor);
	
	
	//employeeService.updateEmployee(employee);
	if(employee.getId() != null){
		System.out.println(employee.getfirstName());
		employeeService.addEmployee(employee);
	}
	

	List<Employee> employeeList= employeeService.allEmployeeList();
	model.addAttribute("employeeList", employeeList);
	return "employeeList";	
	
	/*Employee employee = new Employee();
	UserRole userrole = new UserRole();
	String id = request.getParameter("id");
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	String passwordConfirm = request.getParameter("passwordConfirm");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String birthDate = request.getParameter("birthDate");
	String sex = request.getParameter("sex");
	String maritalStatus = request.getParameter("maritalStatus");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String city = request.getParameter("city");
	String state = request.getParameter("state");
	String zip = request.getParameter("zip");
	String country = request.getParameter("country");
	String phone = request.getParameter("phone");
	String designation = request.getParameter("designation");
	String userRole = request.getParameter("userRole");
	
;
	
	if(id != null && userName != null && password != null && passwordConfirm != null && firstName != null && lastName != null && birthDate != null && sex != null &&
			maritalStatus != null && email != null && address != null && city != null && state != null && state != null && zip != null && country != null && phone != null && designation != null && userRole != null){
	
	int employeeId=Integer.parseInt(id);
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date bDate = formatter.parse(birthDate);
	int empZip=Integer.parseInt(zip);
	int empPhone=Integer.parseInt(phone);
	
	employee.setId(employeeId);
	employee.setUserName(userName);
	employee.setPassword(password);
	employee.setPasswordConfirm(passwordConfirm);
	employee.setfirstName(firstName);
	employee.setLastName(lastName);
	employee.setBirthDate(bDate);
	employee.setSex(sex);
	employee.setMaritalStatus(maritalStatus);
	employee.setemail(email);
	employee.setAddress(address);
	employee.setCity(city);
	employee.setState(state);
	employee.setZip(empZip);
	employee.setCountry(country);
	employee.setPhone(empPhone);
	employee.setDesignation(designation);
	//userrole.setId();
	userrole.setRole(userRole);
	employee.setUserRole(userrole);
	userrole.setEmployee(employee);

	}
*/	
	
	//return "admin_employee_registration";
}


/*@ResponseBody
@RequestMapping(value="/addClient" , method=RequestMethod.POST)
public String addClient(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
	String list = request.getParameter("accessList");
	
	String [] dataList = list.split(",");
	for (int i = 0; i < dataList.length; i++) {
		System.out.println("i"+i+"="+dataList[i]);
	}

	Clients client = new Clients();
	
	String id = dataList[0];
	System.out.println("id:"+id);
	int clientId = Integer.parseInt(id);
	System.out.println("cliwntId "+clientId);
	client.setClientId(clientId);
	
	client.setClientName(dataList[3]);
	client.setClientEmail(dataList[4]);
	String clientMobile = dataList[5];
	int mobile = Integer.parseInt(clientMobile);
	client.setClientMobile(mobile);
	client.setClientAddress(dataList[6]);
	client.setClientCountry(dataList[7]);
	client.setClientTimeZone(dataList[8]);
	client.setSkypeId(dataList[9]);
	client.setClientUsername(dataList[1]);
	client.setClientPassword(dataList[2]);
	
	
	
	if(client.getClientUsername() !=null) {
		  //client.getUserRole().setEmployee(employee);
		  clientService.addClient(client);
	}
	 
	List<Clients> clientList= clientService.allClientList();
	model.addAttribute("clientList", clientList);
	return "clientList";
	
}
*/

@ResponseBody
@RequestMapping(value="/addSchoolAdmin" , method=RequestMethod.POST)
public String addClient(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
	String list = request.getParameter("accessList");
	String SchoolName=request.getParameter("schoolName");
	
	String [] dataList = list.split(",");
	for (int i = 0; i < dataList.length; i++) {
		System.out.println("i"+i+"="+dataList[i]);
	}
	String SchoolName1=dataList[6];
	School school=schoolService.getSchool(SchoolName1);
	SchoolAdmin schoolAdmin = new SchoolAdmin();
	
//	String id = dataList[0];
//	System.out.println("id:"+id);
	/*int clientId = Integer.parseInt(id);
	System.out.println("cliwntId "+clientId);
	client.setClientId(clientId);*/
//	System.out.println("school"+school);
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
	gtsService.addAccountInGts(schoolAdmin.getUsername());
	if(dataList[8].equals("Student")){
		schoolAdmin.setRole("ROLE_STUDENT");
	}else if(dataList[8].equals("SchoolAdmin")){
		schoolAdmin.setRole("ROLE_SCHOOLADMIN");
	}else if(dataList[8].equalsIgnoreCase("Parent")){
		schoolAdmin.setRole("ROLE_PARENT");
	}else if(dataList[8].equalsIgnoreCase("Admin")){
		schoolAdmin.setRole("ROLE_ADMIN");
	}
	/*if(client.getClientUsername() !=null) {
		  //client.getUserRole().setEmployee(employee);
		  clientService.addClient(client);
	}*/
	 
	schoolAdminService.addSchoolAdmin(schoolAdmin);
	List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList();
	model.addAttribute("schoolAdminList", schoolAdminList);
	return "schoolAdmin";
	
}

@RequestMapping(value="/addProject")
public String addProject( HttpServletRequest request,HttpServletResponse response) throws ParseException{
	
	Project project = new Project();
	Clients client = new Clients();
	String id = request.getParameter("projectId");
	String name = request.getParameter("projectName");
	String description = request.getParameter("projectDescription");
	String technology = request.getParameter("projectTechnology");
	String sDate = request.getParameter("projectStartDate");
	String eDate = request.getParameter("projectEndDate");
	String status = request.getParameter("projectStatus");
	String cId = request.getParameter("clientId");

	
	if(id != null && name != null && description != null && technology != null && sDate != null && status != null && cId != null)
	{
		int projectId=Integer.parseInt(id);
		int clientId = Integer.parseInt(cId);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date projectStartDate = formatter.parse(sDate);
		java.util.Date projectEndDate;
		if(eDate != null){
			SimpleDateFormat formatterr = new SimpleDateFormat("yyyy-MM-dd");
			projectEndDate = formatterr.parse(eDate);
			project.setProjectEndDate(projectEndDate);
		}
		else{
			project.setProjectEndDate(null);
		}
		project.setProjectId(projectId);
		project.setProjectName(name);
		project.setProjectDescription(description);
		project.setProjectTechnology(technology);
		project.setProjectStartDate(projectStartDate);
		project.setProjectStatus(status);
		client.setClientId(clientId);
		project.setClient(client);
		client.setProject(project);
		
	}
	
	
	if(project.getProjectId() !=null) {
		  
		  projectService.addProject(project);
	}
	 
	return "admin_project_registration";
}

@RequestMapping(value="/addHoliday")
public String addHoliday(@ModelAttribute("holidayForm") Holidays holiday, HttpServletRequest request,HttpServletResponse response){
	
	if(holiday.getHolidayDate() != null){
		  holidayService.addHoliday(holiday);
	}
		
	
	return "admin_holiday_creation";
}

@RequestMapping(value="/addEmployeeProject")
public String addEmployeeProject(HttpServletRequest request,HttpServletResponse response){
	
		EmployeeProject ep = new EmployeeProject();
		Employee employee = new Employee();
		Project project = new Project();
		
		String empId = request.getParameter("employeeId");
		String projectId = request.getParameter("projectIDD");
	
		System.out.println("employeeId"+empId);
		System.out.println("projectId"+projectId);
		if(empId != null && projectId != null){
			int eId=Integer.parseInt(empId);
			int pId=Integer.parseInt(projectId);
			employee.setId(eId);
			project.setProjectId(pId);
			ep.setEmployee(employee);
			ep.setProject(project);
			employeeProjectService.addEmployeeProject(ep);
		}
		  
	
		  //return null;
		  return "admin_empProject_registration";
}


@ResponseBody
@RequestMapping(value="/empSelect", method=RequestMethod.POST)

public String empSelect(HttpServletRequest request,HttpServletResponse response) throws Exception{

	List<Employee> employeeList=employeeService.getEmployeeFirstName();
	
	String name = null;
	for (Employee employee : employeeList) {
		if(name == null){
			name = employee.getId()+","+employee.getfirstName()+";";
		}
		else{
			name = name + employee.getId()+","+employee.getfirstName()+";";
		}
		
		//System.out.println(employee.getfirstName());
	}
	name = name.substring(0, name.length()-1);
	System.out.println("name:"+name);
	return name;
			
	
}


@ResponseBody
@RequestMapping(value="/projectSelect", method=RequestMethod.POST)

public String projectSelect(HttpServletRequest request,HttpServletResponse response) throws Exception{

	List<Project> projectList=projectService.getProjectName();
	
	String name = null;
	for (Project project : projectList) {
		if(name == null){
			name = project.getProjectId()+","+project.getProjectName()+";";
		}
		else{
			name = name + project.getProjectId()+","+project.getProjectName()+";";
		}
		
		//System.out.println(project.getProjectName());
	}
	name = name.substring(0, name.length()-1);
	System.out.println("name:"+name);
	return name;
			
	
}




@RequestMapping(value="updateEmployeeList")
public String updateEmployeeList(ModelMap model){
	
	ArrayList<Employee> employeeList = employeeService.getAllEmployee();
	model.addAttribute("employeeList", employeeList);
	
	return "admin_employee_update_list";
}

@RequestMapping(value="/schoolList")
public String allSchoolList(ModelMap model){
	List<School> schoolList= schoolService.allSchoolList();
	for (School school2 : schoolList) {
		System.out.println("School    "+school2.getSchoolName());
	}
	model.addAttribute("schoolList", schoolList);
	return "schoolList";
}



@RequestMapping(value="/reports")
public String allClientList(ModelMap model){
	List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList();
	model.addAttribute("schoolAdminList", schoolAdminList);
	List<School> schoolList=schoolService.allSchoolList();
	model.addAttribute("schoolList", schoolList);
	return "clientList";
}

@RequestMapping(value="/schoolAdmin")
public String allSchoolAdminList(ModelMap model){
	List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList();
	model.addAttribute("schoolAdminList", schoolAdminList);
	List<School> schoolList=schoolService.allSchoolList();
	model.addAttribute("schoolList", schoolList);
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
public String allHolidayList(ModelMap model){
	List<Holidays> holidayList= holidayService.allHolidayList();
	model.addAttribute("holidayList", holidayList);
	return "holidayList";
}

@RequestMapping(value="/empProjectList")
public String allEmployeeProjectList(ModelMap model){
	List<EmployeeProject> empProjectList= employeeProjectService.allEmployeeProjectList();
	model.addAttribute("empProjectList", empProjectList);
	return "empProjectList";
}


@RequestMapping(value = "/editEmployee")
public String getEmployeeById(@ModelAttribute("employeeUpdateForm") Employee employee,@RequestParam("id") Integer id, ModelMap model) {
	
    employee= employeeService.getEmployeeyId(id);
	model.addAttribute("employee", employee);
	return "admin_edit_employee";
}


@RequestMapping(value = "/editClient")
public String getClientById(@ModelAttribute("clientUpdateForm") Clients client,@RequestParam("id") Integer id, ModelMap model) {
	

    client= clientService.getClientId(id);
	model.addAttribute("client", client);
	return "admin_edit_client";
}

@RequestMapping(value = "/editProject")
public String getProjectById(@ModelAttribute("projectUpdateForm") Project project,@RequestParam("id") Integer id, ModelMap model) {
	
	project= projectService.getProjectId(id);
	model.addAttribute("project", project);
	return "admin_edit_project";
}

@RequestMapping(value = "/editHoliday")
public String getHolidayById(@ModelAttribute("holidayUpdateForm") Holidays holiday,@RequestParam("id") Integer id, ModelMap model) {
	
	holiday= holidayService.getHolidayId(id);
	model.addAttribute("holiday", holiday);
	return "admin_edit_holiday";
}


@RequestMapping(value = "/editEmpProject")
public String getEmployeeProjectById(@ModelAttribute("empProjectUpdateForm") EmployeeProject ep,@RequestParam("id") Integer id, ModelMap model) {
	

    ep= employeeProjectService.getEmployeeProjectId(id);
	model.addAttribute("employeeProject", ep);
	return "admin_edit_empProject";
}



@ResponseBody
@RequestMapping(value="/updateEmployee" , method=RequestMethod.POST)
public String updateEmployee(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{

	
	String list = request.getParameter("accessList");
	System.out.println("in Admin:"+list);
	
	String [] dataList = list.split(",");
	for (int i = 0; i < dataList.length; i++) {
		System.out.println("i"+i+"="+dataList[i]);
	}
	Employee employee = new Employee();
	employee.setUserName(dataList[1]); 
	String id = dataList[0];
	int empId=Integer.parseInt(id);
	employee.setId(empId);
	String password =  dataList[2];
	employee.setPassword(password);
	String inputFirstName =  dataList[3];
	employee.setfirstName(inputFirstName);
	String inputLastName =  dataList[4];
	employee.setLastName(inputLastName);
	String inputBirthDate =  dataList[5];
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date birthDate = formatter.parse(inputBirthDate);
	employee.setBirthDate(birthDate);
	employee.setemail(dataList[8]);
	employee.setAddress(dataList[9]);
	employee.setCity(dataList[10]);
	employee.setState(dataList[11]);
	String inputZip =  dataList[12];
	int zip=Integer.parseInt(inputZip);
	employee.setZip(zip);
	employee.setCountry(dataList[13]);
	String inputPhone =  dataList[14];
	int phone=Integer.parseInt(inputPhone);
	employee.setPhone(phone);
	employee.setDesignation(dataList[15]);
	employee.setMaritalStatus(dataList[7]);
	employee.setSex(dataList[6]);
	UserRole userRole = new UserRole();
	int rId=Integer.parseInt(dataList[17]);
	System.out.println("RID "+rId);
	userRole.setId(rId);
	userRole.setRole(dataList[16]);
	System.out.println("role "+dataList[16]);
	employee.setUserRole(userRole);
	userRole.setEmployee(employee);
	SuperVisor supervisor = new SuperVisor();
	int superVisorId = Integer.parseInt(dataList[18]);
	int sId = Integer.parseInt(dataList[19]);
	System.out.println("sId "+ sId);
	System.out.println("supervisor "+superVisorId);
	supervisor.setsId(sId);
	supervisor.setSuperVisorId(superVisorId);
	employee.setSupervisor(supervisor);
	supervisor.setEmployee(employee);
	
	employeeService.updateEmployee(employee);
	

	List<Employee> employeeList= employeeService.allEmployeeList();
	model.addAttribute("employeeList", employeeList);
	return "employeeList";
}

@ResponseBody
@RequestMapping(value="/updateClient" , method=RequestMethod.POST)
public String updateClient(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
	String list = request.getParameter("accessList");
	System.out.println("in Admin:"+list);
	
	String [] dataList = list.split(",");
	for (int i = 0; i < dataList.length; i++) {
		System.out.println("i"+i+"="+dataList[i]);
	}

	Clients client = new Clients();
	
	String id = dataList[0];
	System.out.println("id:"+id);
	int clientId = Integer.parseInt(id);
	System.out.println("cliwntId "+clientId);
	client.setClientId(clientId);
	
	client.setClientName(dataList[3]);
	client.setClientEmail(dataList[4]);
	String clientMobile = dataList[5];
	int mobile = Integer.parseInt(clientMobile);
	client.setClientMobile(mobile);
	client.setClientAddress(dataList[6]);
	client.setClientCountry(dataList[7]);
	client.setClientTimeZone(dataList[8]);
	client.setSkypeId(dataList[9]);
	client.setClientUsername(dataList[1]);
	client.setClientPassword(dataList[2]);
	
	clientService.updateClient(client);
	
	List<Clients> clientList= clientService.allClientList();
	model.addAttribute("clientList", clientList);
	return "clientList";
}

@RequestMapping(value="/updateProject" , method=RequestMethod.POST)
public String updateProject(HttpServletRequest request,HttpServletResponse response) throws ParseException{
	Project project = new Project();
	
	String id = request.getParameter("projectId");
	int projectId = Integer.parseInt(id);
	project.setProjectId(projectId); 
	
	project.setProjectName(request.getParameter("projectName"));
	project.setProjectDescription(request.getParameter("projectDescription"));
	project.setProjectTechnology(request.getParameter("projectTechnology"));
	String startDate = request.getParameter("projectStartDate");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date projectStartDate = formatter.parse(startDate);		
	project.setProjectStartDate(projectStartDate);

	String endDate = request.getParameter("projectEndDate");
	SimpleDateFormat fformatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date projectEndDate = fformatter.parse(endDate);		
	project.setProjectEndDate(projectEndDate);

	
	project.setProjectStatus(request.getParameter("projectStatus"));
	String cId = request.getParameter("clientId");
	int clientId = Integer.parseInt(cId);
	Clients client = new Clients();
	client.setClientId(clientId); 
	project.setClient(client);
	
	
	projectService.updateProject(project);
	
	return "projectList";
}



@RequestMapping(value="/updateHoliday" , method=RequestMethod.POST)
public String updateHoliday(HttpServletRequest request,HttpServletResponse response) throws ParseException{
	Holidays holiday = new Holidays();
	
	String id = request.getParameter("holidayId");
	int holidayId = Integer.parseInt(id);
	holiday.setHolidayId(holidayId);
	holiday.setHolidayTitle(request.getParameter("holidayTitle"));
	String holidayDate = request.getParameter("holidayDate");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = formatter.parse(holidayDate);		
	holiday.setHolidayDate(date);
	holiday.setHolidayDescription(request.getParameter("holidayDescription"));
	
	holidayService.updateHoliday(holiday);
	
	
	return "holidayList";
}

@RequestMapping(value="/updateEmployeeProject" , method=RequestMethod.POST)
public String updateEmployeeProject(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
	
	EmployeeProject ep = new EmployeeProject();
	Employee employee = new Employee();
	Project project = new Project();
	
	String empId = request.getParameter("employeeId");
	String projectId = request.getParameter("projectIDD");
	String id = request.getParameter("id");
	System.out.println("employeeId"+empId);
	System.out.println("projectId"+projectId);
	if(empId != null && projectId != null){
		int eId=Integer.parseInt(empId);
		int pId=Integer.parseInt(projectId);
		int empProjectId=Integer.parseInt(id);
		ep.setEmpProjectId(empProjectId);
		employee.setId(eId);
		project.setProjectId(pId);
		ep.setEmployee(employee);
		ep.setProject(project);
		employeeProjectService.updateEmployeeProject(ep);
	}
	  

	List<EmployeeProject> empProjectList= employeeProjectService.allEmployeeProjectList();
	model.addAttribute("empProjectList", empProjectList);
	return "empProjectList";
}


@RequestMapping(value = "/deleteSchoolList")
public String deleteEmployeeList(@RequestParam("list") String str,ModelMap model){
	str = str.substring(0, str.length()-1);
	String[] str1 = str.split(",");
	
	for (int i = 0; i < str1.length; i++) {
		
		int id = Integer.parseInt(str1[i]);
		schoolService.deleteSchool(id);
	}
	
	List<School> schoolList= schoolService.allSchoolList();
	
	model.addAttribute("schoolList", schoolList);
	return "schoolList";
}

@RequestMapping(value = "/deleteSchoolAdminList")
public String deleteClientList(@RequestParam("list") String str,ModelMap model){
	str = str.substring(0, str.length()-1);
	String[] str1 = str.split(",");
	
	for (int i = 0; i < str1.length; i++) {
		int id = Integer.parseInt(str1[i]);
		schoolAdminService.deleteSchoolAdmin(id);
	}
	

    List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList();
	model.addAttribute("schoolAdminList", schoolAdminList);
	return "schoolAdmin";
}


@RequestMapping(value = "/deleteProject")
public String deleteProject(@ModelAttribute("projectUpdateForm") Project project,@RequestParam("id") Integer id, ModelMap model) {
	
    projectService.deleteProject(id);
    List<Project> projectList= projectService.allProjectList();
	model.addAttribute("projectList", projectList);
	return "projectList";
}

@RequestMapping(value = "/deleteHoliday")
public String deleteHoliday(@ModelAttribute("holidayUpdateForm") Holidays holiday,@RequestParam("id") Integer id, ModelMap model) {
	
    holidayService.deleteHoliday(id);
	
    List<Holidays> holidayList= holidayService.allHolidayList();
	model.addAttribute("holidayList", holidayList);
	return "holidayList";
}


@RequestMapping(value = "/deleteEmpProject")
public String deleteEmpProject(@ModelAttribute("EmployeeProjectUpdateForm") EmployeeProject ep,@RequestParam("id") Integer id, ModelMap model) {
	
    employeeProjectService.deleteEmployeeProject(id);
	
    List<EmployeeProject> empProjectList= employeeProjectService.allEmployeeProjectList();
	model.addAttribute("empProjectList", empProjectList);
	return "empProjectList";
}

@RequestMapping(value = "/leaveApproved")
public String leaveApproved(@ModelAttribute("projectUpdateForm") Project project,@RequestParam("id") Integer id,@RequestParam("wDays") Integer wDays,@RequestParam("empId") Integer empId, ModelMap model) {
	
    leaveService.leaveApproved(empId,wDays);
	leaveService.leaveAccept(id);
	List<LeavesApplied> leaveList= leaveService.allLeaveList();
	model.addAttribute("leaveList", leaveList);
		return "leaveList";
}

@RequestMapping(value = "/leaveReject")
public String leaveReject(@ModelAttribute("projectUpdateForm") Project project,@RequestParam("id") Integer id, ModelMap model) {
	
	leaveService.leaveReject(id);
	List<LeavesApplied> leaveList= leaveService.allLeaveList();
	model.addAttribute("leaveList", leaveList);
		return "leaveList";
}


}


