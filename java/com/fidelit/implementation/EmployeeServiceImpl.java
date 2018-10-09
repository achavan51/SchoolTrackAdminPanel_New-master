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
import com.fidelit.model.empLeavesTaken;
import com.fidelit.service.EmployeeService;





@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addEmployee(Employee employee) {
		    Session session;
		try {	
			System.out.println("Hi inside addEmployee");
			System.out.println("empFname"+employee.getfirstName());
			System.out.println("country"+employee.getCountry());
			System.out.println("role"+employee.getUserRole().getRole());
			System.out.println("roleId"+employee.getUserRole().getId());
			System.out.println("in Service: " + "sId "+employee.getSupervisor().getsId()+"supervisorId"+employee.getSupervisor().getSuperVisorId()+"empId"+employee.getSupervisor().getEmployee().getId());
			session = sessionFactory.getCurrentSession();
			session.save(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void updateEmployee(Employee employee) {
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void deleteEmployee(int id) {
		Session session;
		Employee  employee=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 employee = (Employee)result;
			 session.delete(employee);
			//System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public ArrayList<Employee> getAllEmployee() {
	
		 ArrayList<Employee> employeeList = new ArrayList<Employee>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(Employee.class);
				employeeList = (ArrayList<Employee>) criteria.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		 
		 return employeeList;
		
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
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
 }
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Employee> allEmployeeList(){
		Session session;
		List<Employee> empList = null;
		try{
			session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from employee ").addEntity(Employee.class);
			 empList = query.list();
			//System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return empList;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Employee getEmployeeyId(int id){
		Session session;
		Employee  employee = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Employee.class);
			 criteria.add(Restrictions.eq("id", id));
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
	public List<Employee> getEmployeeFirstName() {
		Session session;
		List<Employee> empList = null;
		try{
			session = sessionFactory.getCurrentSession();
			//SQLQuery query = session.createSQLQuery("select empFirstName from employee").addEntity(Employee.class);
				
			String hql = "select *  from employee";
			Query query = session.createSQLQuery(hql).addEntity(Employee.class);
		
			 empList = query.list();
			System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return empList;
	}


}
