package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.service.SchoolAdminService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("SchoolAdminService")
public class SchoolAdminServiceImpl implements SchoolAdminService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override

	public void addSchoolAdmin(SchoolAdmin schoolAdmin) {
		// TODO Auto-generated method stub
	
		 Session session;
			try {	
				
				session = sessionFactory.getCurrentSession();
				session.save(schoolAdmin);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateSchool(SchoolAdmin schoolAdmin) {
		// TODO Auto-generated method stub
		
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(schoolAdmin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public ArrayList<SchoolAdmin> getAllSchoolAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<SchoolAdmin> allSchoolAdminList() {
		
		List<SchoolAdmin> schoolAdminList = new ArrayList<SchoolAdmin>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(SchoolAdmin.class);
				schoolAdminList = criteria.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		return schoolAdminList;
	}

	@Override
	public SchoolAdmin getSchoolAdminId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteSchoolAdmin(int id) {
		// TODO Auto-generated method stub
		
		Session session;
		SchoolAdmin  schoolAdmin=null;
		try{
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(SchoolAdmin.class);
				criteria.add(Restrictions.eq("id", id));
				Object result=criteria.uniqueResult();
				schoolAdmin = (SchoolAdmin)result;
				session.delete(schoolAdmin);
			//System.out.println(empList);
		}
		catch(Exception e){
				e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<SchoolAdmin> getAllStudentList() {
		List<SchoolAdmin> schoolAdminList = new ArrayList<SchoolAdmin>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql = "from SchoolAdmin where accountType = :accountType";
				Query query = session.createQuery(hql);
				query.setParameter("accountType", "Student");
				schoolAdminList = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		return schoolAdminList;
	}

}
