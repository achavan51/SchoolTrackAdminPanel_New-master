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
import com.fidelit.model.Holidays;
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.Project;
import com.fidelit.service.HolidayService;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("holidayService")
public class HolidayServiceImpl implements HolidayService{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addHoliday(Holidays holiday) {
		Session session;
		try {	
			session = sessionFactory.getCurrentSession();
			session.save(holiday);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateHoliday(Holidays holiday) {
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(holiday);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Holidays> getAllHoliday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Holidays> allHolidayList() {
		Session session;
		List<Holidays> holidayList = null;
		try{
			session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from holidays ").addEntity(Holidays.class);
			holidayList = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return holidayList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteHoliday(int id) {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
			
			String hql = "delete from holidays where holidayId= :id";
			Query query = session.createSQLQuery(hql);
			query.setParameter("id", id);
			query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Holidays getHolidayId(Integer id) {
		Session session;
		Holidays  holiday = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Holidays.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 holiday = (Holidays)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return holiday;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Holidays> getHolidayDate() {
		Session session;
		List<Holidays> holidayList = null;
		try{
			session = sessionFactory.getCurrentSession();
			//SQLQuery query = session.createSQLQuery("select empFirstName from employee").addEntity(Employee.class);
				
			String hql = "select *  from holidays";
			Query query = session.createSQLQuery(hql).addEntity(Holidays.class);
		
			holidayList = query.list();
			System.out.println(holidayList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return holidayList;
	}

}
