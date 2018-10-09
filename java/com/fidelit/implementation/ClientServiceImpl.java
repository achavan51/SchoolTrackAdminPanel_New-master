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

import com.fidelit.model.Clients;

import com.fidelit.service.ClientService;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addClient(Clients client) {
		    Session session;
		try {	
			session = sessionFactory.getCurrentSession();
			session.save(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void updateClient(Clients client) {
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void deleteClient(int id) {
		Session session;
		Clients  client=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Clients.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 client = (Clients)result;
			 session.delete(client);
			//System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/*
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
		 return employeeList;
		// TODO Auto-generated method stub
		
	}*/

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public boolean checkClientUsername(String userName) {
		      Session session;
		      boolean flag = false;
		try{
		      session = sessionFactory.getCurrentSession();
		      SQLQuery query = session.createSQLQuery("select clientUsername from clients ");
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
	public List<Clients> allClientList(){
		Session session;
		List<Clients> clientList = null;
		try{
			session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from clients ").addEntity(Clients.class);
			 clientList = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return clientList;
	}

	

	

	@Override
	public ArrayList<Clients> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkClientId(int clientId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		@Override
		public Clients getClientId(int id) {
			Session session;
			Clients  client = null;
			try{
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(Clients.class);
				 criteria.add(Restrictions.eq("id", id));
				 Object result=criteria.uniqueResult();
				 client = (Clients)result;
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return client;
		}
	

	
	
	/**/
//	public String allEmployeeList() {
//	    Session session;
//	try {
//		
//		session = sessionFactory.getCurrentSession();
//		String hql = "FROM Employee";
//		Query query = session.createQuery(hql);
//		List results = query.list();
//		System.out.println("------LIST-------");
//		System.out.println(results);
//		//Employee emp = ((Employee) session).retrieve();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//		return "admin_all_employee_list";
//}
	
//	public ModelAndView allEmployeeList(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        ModelAndView mv = new ModelAndView("employeeList");
//        String out = "employeeList";
//        Session session;
//        try {
//             session = sessionFactory.getCurrentSession();
//            //session.beginTransaction();
//            List result = session.createQuery("from Employee").list();
//            mv.addObject("employee_list", result);
//            //session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        mv.addObject("message", out);
//        return mv;
//    }
}
