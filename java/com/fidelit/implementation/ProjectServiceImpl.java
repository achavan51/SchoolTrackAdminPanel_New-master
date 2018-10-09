package com.fidelit.implementation;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.fidelit.model.Employee;
import com.fidelit.model.Project;
import com.fidelit.service.ProjectService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addProject(Project project) {
		    Session session;
		try {	
			session = sessionFactory.getCurrentSession();
			session.save(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void updateProject(Project project) {
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void deleteProject(int id) {
		Session session;
		Project  project=null;
		try{
			session = sessionFactory.getCurrentSession();
			
			String hql = "delete from Project where projectId= :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public ArrayList<Project> getAllProject() {
	
		 ArrayList<Project> ProjectList = new ArrayList<Project>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(Project.class);
				ProjectList = (ArrayList<Project>) criteria.list();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
		 return ProjectList;
		// TODO Auto-generated method stub
		
	}

	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public boolean checkUserName(String userName) {
		      Session session;
		      boolean flag = false;
		try{
		      session = sessionFactory.getCurrentSession();
		      SQLQuery query = session.createSQLQuery("select empUsername from employee ");
              List<Object> userNameList = query.list();
              if(userNameList.contains(userName)){
            	  flag = true;
              }
        
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
 }*/
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Project> allProjectList(){
		Session session;
		List<Project> projectList = null;
		try{
			session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from project ").addEntity(Project.class);
			 projectList = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return projectList;
	}



@Override
public boolean checkProjectName(String projectName) {
	// TODO Auto-generated method stub
	return false;
}


	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Project getProjectId(int id){
		Session session;
		Project  project = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Project.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 project = (Project)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return project;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Project> getProjectName() {
		Session session;
		List<Project> projectList = null;
		try{
			session = sessionFactory.getCurrentSession();
			//SQLQuery query = session.createSQLQuery("select empFirstName from employee").addEntity(Employee.class);
			
			
			String hql = "select *  from project";
			Query query = session.createSQLQuery(hql).addEntity(Project.class);
			
			
			projectList = query.list();
			System.out.println(projectList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return projectList;
	}

}
