package com.fidelit.implementation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.empLeavesTaken;
import com.fidelit.service.UserService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("userService")

public class UserServiceImpl implements UserService{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addLeave(LeavesApplied leavesApplied){
	 Session session;
			try {	
				session = sessionFactory.getCurrentSession();
				session.save(leavesApplied);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Employee getEmployeeByUsername(String username){
		Session session;
		Employee  employee = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			 criteria.add(Restrictions.eq("userName", username));
			 Object result=criteria.uniqueResult();
			 employee = (Employee)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employee;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean checkDate(String date) {
	      Session session;
	      System.out.println("In service:"+date);
	      
	      boolean flag = false;
	      try{
	    	  session = sessionFactory.getCurrentSession();
	    	  SQLQuery query = session.createSQLQuery("select holidayDate from holidays ");
	    	  List<java.sql.Date> dateList = query.list();
	    	  System.out.println("Date"+dateList.toString());
	    	  
	    	  String[] date_to_string = new String[dateList.size()];
	    	  for (Object  object : dateList) {
	    		  int i=0;
				      
				    SimpleDateFormat dateformatJava = new SimpleDateFormat("yyyy-MM-dd");
				    date_to_string[i]  = dateformatJava.format(object);
				
			}
	    	  
	    	  if(Arrays.asList(date_to_string).contains(date)){
	    		 
	    		  	flag = true;  
	    	  }
	    	  
  
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
	      return flag;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<empLeavesTaken> allLeaveBalanceList(int id) {
		Session session;
		List<empLeavesTaken>  employee = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			String hql = "select *  from empLeavesTaken where empId= :id";
			Query query = session.createSQLQuery(hql).addEntity(empLeavesTaken.class);
			query.setParameter("id", id);
			//query.executeUpdate();
			/*Criteria criteria = session.createCriteria(empLeavesTaken.class);
			 criteria.add(Restrictions.eq("employee.id", id));
			 Object result=criteria.uniqueResult();
			*/ 
			 employee =  query.list();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employee;	
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<LeavesApplied> allLeaveHistoryList(int id) {
		Session session;
		List<LeavesApplied>  employee = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			String hql = "select *  from leavesApplied where empId= :id";
			Query query = session.createSQLQuery(hql).addEntity(LeavesApplied.class);
			query.setParameter("id", id);
			
			 employee =  query.list();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employee;	
		
	}


}
