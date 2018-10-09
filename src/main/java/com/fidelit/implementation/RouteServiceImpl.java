package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Bus;
import com.fidelit.model.Clients;
import com.fidelit.model.Route;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
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
		System.out.println("In AddRoute");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public List<Route> getRouteList(String accountId) {
		List<Route> routeList = new ArrayList<Route>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql ="from Route where accountId =:accountId"; 
				Query query = session.createQuery(hql);
				query.setParameter("accountId", accountId);
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

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public int getLastRouteId() {
		Session session;
		Route  route = null;
		int id = 0;
		try{
			session = sessionFactory.getCurrentSession();
			Route result = (Route) session.createQuery("from Route ORDER BY routeNo DESC")
                    .setMaxResults(1)
                    .uniqueResult();
			/*Criteria criteria = session.createCriteria(Route.class);
			 criteria.add(Restrictions.eq("routeNo", id));
			 Object result=criteria.uniqueResult();
			 route = (Route)result;*/
			id = result.getRouteNo();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteBusInRoute(int busId) {
		 Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE route set regNumber = null "  + 
	             "WHERE regNumber = "+busId;
		try{
		Query query = session.createSQLQuery(hql);
		System.out.println("update :"+query.executeUpdate());
		}catch(Exception e){
			e.printStackTrace();
		}
       

	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteDriverInRoute(int driverId) {
		 Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE route set driverName = null "  + 
	             "WHERE driverName = "+driverId;
		try{
		Query query = session.createSQLQuery(hql);
		System.out.println("update :"+query.executeUpdate());
		}catch(Exception e){
			e.printStackTrace();
		}
       

	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public List<Route> allRouteList(String userName) {
		
		Session session;
		List<Route> routeList = null;
		try{
			session = sessionFactory.getCurrentSession();
			System.out.println("IN Service:"+userName);
			SQLQuery query = session.createSQLQuery(
					"select * from route r where r.regNumber ='"+userName+"'");		
			routeList = query.list();
			System.out.println("In RouteService:"+routeList.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return routeList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public List<Route> allRouteListDriver(String driverName) {
		
		Session session;
		List<Route> routeList = null;
		try{
			session = sessionFactory.getCurrentSession();
			System.out.println("IN Service:"+driverName);
			SQLQuery query = session.createSQLQuery(
					"select * from route r where r.driverName ='"+driverName+"'");		
			routeList = query.list();
			System.out.println("In RouteService:"+routeList.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return routeList;
	}


}
