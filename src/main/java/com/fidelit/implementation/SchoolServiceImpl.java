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

import com.fidelit.model.Employee;
import com.fidelit.model.Extintor;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	SchoolAdminService schoolAdminService;
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override

	public void addSchool(School school) {
		  Session session;
			try {	
				System.out.println("Hi inside addEmployee");
				System.out.println("empFname"+school.getSchoolName());
				System.out.println("country"+school.getAddress());
				System.out.println("role"+school.getDetails());
				/*System.out.println("roleId"+employee.getUserRole().getId());
				System.out.println("in Service: " + "sId "+employee.getSupervisor().getsId()+"supervisorId"+employee.getSupervisor().getSuperVisorId()+"empId"+employee.getSupervisor().getEmployee().getId());
				*/
				session = sessionFactory.getCurrentSession();
				session.save(school);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateSchool(School school) {
		// TODO Auto-generated method stub
		
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(school);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public ArrayList<School> getAllSchool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<School> allSchoolList(String userName) {
		
		
		List<School> schoolList = new ArrayList<School>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(School.class);
				criteria.add(Restrictions.eq("accountId", userName));
				schoolList = criteria.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		 
		 return schoolList;

		// TODO Auto-generated method stub
	}
	@Override
	public School getSchoolId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteSchool(int id) {
		// TODO Auto-generated method stub
		System.out.println("Delete School"+id);
		Session session;
		School  school=null;
		try{
			    session = sessionFactory.getCurrentSession();
			    Criteria criteria = session.createCriteria(School.class);
			    criteria.add(Restrictions.eq("id", id));
			    Object result=criteria.uniqueResult();
			    school = (School)result;
			
				String hql = "UPDATE schoolAdmin set schoolId = null "  + 
			             "WHERE schoolId = "+id;
				try{
				Query query = session.createSQLQuery(hql);
				System.out.println("update :"+query.executeUpdate());
				}catch(Exception e){
					e.printStackTrace();
				}
			 session.delete(school);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public School getSchool(String schoolName) {
		// TODO Auto-generated method stub
		
		Session session;
		School  school=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(School.class);
			 criteria.add(Restrictions.eq("schoolName", schoolName));
			 Object result=criteria.uniqueResult();
			 school = (School)result;
			// session.getbyName(school);
		//	 return school; 
			//System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return school;	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public School getSchoolByName(String schoolName) {
		
		Session session;
		School  school=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(School.class);
			 criteria.add(Restrictions.eq("schoolName", schoolName));
			 Object result=criteria.uniqueResult();
			 school = (School)result;
			// session.getbyName(school);
		//	 return school; 
			//System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return school;	
	}

}
