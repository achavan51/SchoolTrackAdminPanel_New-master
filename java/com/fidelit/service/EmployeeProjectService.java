package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import com.fidelit.model.EmployeeProject;

public interface EmployeeProjectService {
	void addEmployeeProject(EmployeeProject client);
	void updateEmployeeProject(EmployeeProject client);
	//void deleteEmployee(Employee employee);
	ArrayList<EmployeeProject> getAllEmployeeProject();
	//boolean checkClientId(int clientId);
	List<EmployeeProject> allEmployeeProjectList();
	EmployeeProject getEmployeeProjectId(int id);
	void deleteEmployeeProject(int id);
	//boolean checkClientUsername(String userName);
	//void deleteEmpProject(Integer id);

}
