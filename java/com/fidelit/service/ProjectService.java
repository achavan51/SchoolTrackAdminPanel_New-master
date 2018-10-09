package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;


import com.fidelit.model.Project;

public interface ProjectService {

	void addProject(Project project);
	void updateProject(Project project);
	//void deleteEmployee(Employee employee);
	ArrayList<Project> getAllProject();
	boolean checkProjectName(String projectName);
	List<Project> allProjectList();
	Project getProjectId(int id);
	void deleteProject(int id);
	List<Project> getProjectName();
}
