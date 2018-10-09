package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import com.fidelit.model.SchoolAdmin;

public interface SchoolAdminService {
	
	void addSchoolAdmin(SchoolAdmin schoolAdmin);
	void updateSchool(SchoolAdmin schoolAdmin);
	//void deleteEmployee(Employee employee);
	ArrayList<SchoolAdmin> getAllSchoolAdmin();
//	boolean checkUserName(String userName);
	List<SchoolAdmin> allSchoolAdminList();
	SchoolAdmin getSchoolAdminId(int id);
	void deleteSchoolAdmin(int id);
//	List<Employee> getEmployeeFirstName();
	List<SchoolAdmin> getAllStudentList();

}
