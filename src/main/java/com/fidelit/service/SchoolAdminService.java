package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import com.fidelit.model.Route;
import com.fidelit.model.RouteToStudent;
import com.fidelit.model.SchoolAdmin;

public interface SchoolAdminService {
	
	void addSchoolAdmin(SchoolAdmin schoolAdmin);
	void updateSchoolAdmin(SchoolAdmin schoolAdmin);
	//void deleteEmployee(Employee employee);
	ArrayList<SchoolAdmin> getAllSchoolAdmin();
//	boolean checkUserName(String userName);
	List<SchoolAdmin> allSchoolAdminList(String userName);
	SchoolAdmin getSchoolAdminId(int id);
	void deleteSchoolAdmin(int id);
//	List<Employee> getEmployeeFirstName();
	List<SchoolAdmin> getAllStudentList(String userName);
	boolean getUniqueUserName(String userName);
	String getNameFromId(int id);
	List<SchoolAdmin> checkStudentInSchool(String schoolId);
	List<SchoolAdmin> checkSchoolAdminInSchool(String schoolId);
	int getLastSchoolAdminId();
	void addRouteToStudent(Route route,int student);
	List<RouteToStudent> getAllRouteToStudent();
	void addParentToStudent(SchoolAdmin schoolAdmin, int studentid);
    SchoolAdmin getParentId(int id);
    List<SchoolAdmin> getAllParentToStudent(int studentId);
    List<SchoolAdmin> getAllStudentListForParent(String userName);
    List<Integer> getStduentFromParentToStudent(Integer parentId);
}
