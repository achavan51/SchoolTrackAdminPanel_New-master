package com.fidelit.implementation;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Account;
import com.fidelit.model.Clients;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.service.AuthenticationService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("clientService")
public class AuthenticationImpl implements AuthenticationService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public SchoolAdmin authenticateUser(String username, String password,String accountId) {

		Session session;
		SchoolAdmin account = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(SchoolAdmin.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));
			criteria.add(Restrictions.eq("accountType", accountId));
			Object result=criteria.uniqueResult();
			account = (SchoolAdmin)result;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return account;
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public SchoolAdmin authenticateUser(String username) {

		Session session;
		SchoolAdmin account = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(SchoolAdmin.class);
			criteria.add(Restrictions.eq("username", username));
			
			Object result=criteria.uniqueResult();
			account = (SchoolAdmin)result;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return account;
	}
	
	
	 
}
