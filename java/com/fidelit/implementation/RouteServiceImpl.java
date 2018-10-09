package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Clients;
import com.fidelit.model.Route;
import com.fidelit.model.School;
import com.fidelit.service.RouteService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("routeService")
public class RouteServiceImpl implements RouteService{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public void addRoute(Route route) {
		Session session = sessionFactory.getCurrentSession();
		session.save(route);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public List<Route> getRouteList() {
		List<Route> routeList = new ArrayList<Route>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql ="from Route"; 
				Query query = session.createQuery(hql);
				routeList = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return routeList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Route getRouteId(int id) {
		Session session;
		Route  route = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Route.class);
			 criteria.add(Restrictions.eq("routeNo", id));
			 Object result=criteria.uniqueResult();
			 route = (Route)result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return route;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateRoute(Route route) {
		
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(route);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteRoute(int id) {
		
		Session session;
		Route  route=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Route.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 route = (Route)result;
			 session.delete(route);
			//System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		
		// TODO Auto-generated method stub
		
	}

	
	

}
