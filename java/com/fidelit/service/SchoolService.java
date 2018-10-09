package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import com.fidelit.model.Employee;
import com.fidelit.model.School;

public interface SchoolService {

	void addSchool(School school);
	void updateSchool(School school);
	//void deleteEmployee(Employee employee);
	ArrayList<School> getAllSchool();
//	boolean checkUserName(String userName);
	List<School> allSchoolList();
	School getSchoolId(int id);
	School getSchool(String schoolName);
	void deleteSchool(int id);
	School getSchoolByName(String schoolName);
//	List<Employee> getEmployeeFirstName();
}
