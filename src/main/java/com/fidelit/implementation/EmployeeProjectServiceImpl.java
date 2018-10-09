package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.EmployeeProject;
import com.fidelit.model.Project;
import com.fidelit.service.EmployeeProjectService;



@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("employeeProjectService")
public class EmployeeProjectServiceImpl implements EmployeeProjectService{


	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addEmployeeProject(EmployeeProject employeeProject) {
		Session session;
		try {	
			session = sessionFactory.getCurrentSession();
			session.save(employeeProject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateEmployeeProject(EmployeeProject ep) {
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(ep);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<EmployeeProject> getAllEmployeeProject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<EmployeeProject> allEmployeeProjectList() {
		Session session;
		List<EmployeeProject> holidayList = null;
		try{
			session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from employeeProject ").addEntity(EmployeeProject.class);
			holidayList = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return holidayList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public EmployeeProject getEmployeeProjectId(int id) {
		Session session;
		EmployeeProject  ep = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(EmployeeProject.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 ep = (EmployeeProject)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ep;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteEmployeeProject(int id) {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
			
			String hql = "delete from employeeProject where empProjectId= :id";
			Query query = session.createSQLQuery(hql);
			query.setParameter("id", id);
			query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	

}
