package com.fidelit.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.LeavesApplied;
import com.fidelit.model.Project;
import com.fidelit.service.LeaveService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("LeaveService")
public class LeaveServiceImpl implements LeaveService{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<LeavesApplied> allLeaveList() {
		Session session;
		List<LeavesApplied> leaveList = null;
		try{
			session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from leavesApplied where leaveStatus = 'pending'").addEntity(LeavesApplied.class);
			leaveList = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return leaveList;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void leaveApproved(Integer eId, Integer wDays){
		Session session;
		//LeavesApplied  leavesApplied=null;
		try{
			session = sessionFactory.getCurrentSession();
			String hql = "UPDATE empLeavesTaken SET leaveCount= leaveCount + :wDays,leaveBalance= leaveBalance - :wDays where empId= :eId";
			//String hql = "delete from Project where projectId= :id";
			Query query = session.createQuery(hql);
			query.setParameter("wDays", wDays);
			query.setParameter("eId", eId);
			query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void leaveAccept(Integer id) {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
			String status = "Granted";
			//String hql = "delete from leavesApplied where leavesAppliedId= :id";
			String hql = "UPDATE leavesApplied SET leaveStatus= :status  where leavesAppliedId= :id";
			Query query = session.createSQLQuery(hql);
			query.setParameter("status", status);
			query.setParameter("id", id);
			query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void leaveReject(Integer id) {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
			String status = "Rejected";
			//String hql = "delete from leavesApplied where leavesAppliedId= :id";
			String hql = "UPDATE leavesApplied SET leaveStatus= :status  where leavesAppliedId= :id";
			Query query = session.createSQLQuery(hql);
			query.setParameter("status", status);
			query.setParameter("id", id);
			query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void leaveWithdraw(Integer id, String status) {
		// TODO Auto-generated method stub
		//delete from project where projectId = "1";
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
			//String status = "Rejected";
			String hql = "delete from leavesApplied where leavesAppliedId= :id";
			//String hql = "UPDATE leavesApplied SET leaveStatus= :status  where leavesAppliedId= :id";
			Query query = session.createSQLQuery(hql);
			//query.setParameter("status", status);
			query.setParameter("id", id);
			query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
