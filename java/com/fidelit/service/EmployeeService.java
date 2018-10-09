package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.fidelit.model.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	//void deleteEmployee(Employee employee);
	ArrayList<Employee> getAllEmployee();
	boolean checkUserName(String userName);
	List<Employee> allEmployeeList();
	Employee getEmployeeyId(int id);
	void deleteEmployee(int id);
	List<Employee> getEmployeeFirstName();
}
