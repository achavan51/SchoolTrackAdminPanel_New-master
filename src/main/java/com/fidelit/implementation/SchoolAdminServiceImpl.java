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

import com.fidelit.model.Extintor;
import com.fidelit.model.Route;
import com.fidelit.model.RouteToStudent;
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
	public void updateSchoolAdmin(SchoolAdmin schoolAdmin) {
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
	public List<SchoolAdmin> allSchoolAdminList(String userName) {
		
		List<SchoolAdmin> schoolAdminList = new ArrayList<SchoolAdmin>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql = "from  SchoolAdmin where accountId =:accountId";
				Query query = session.createQuery(hql);
				query.setString("accountId", userName);
				schoolAdminList = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		return schoolAdminList;
	}

	@Override
	public SchoolAdmin getSchoolAdminId(int id) {

        SchoolAdmin student = null;
        Session session=sessionFactory.getCurrentSession();
        String sql="select * from schoolAdmin where id ="+id;
        SQLQuery query=session.createSQLQuery(sql).addEntity(SchoolAdmin.class);
        Object result = query.uniqueResult();
        student = (SchoolAdmin)result;
        return student;
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
	public List<SchoolAdmin> getAllStudentListForParent(String userName) {
        List<SchoolAdmin> schoolAdminList = new ArrayList<SchoolAdmin>();
         Session session;
            try {
                session = sessionFactory.getCurrentSession();
                String hql = "from SchoolAdmin where accountType = :accountType and accountId =:accountId and isUsed =:isUsed";
                Query query = session.createQuery(hql);
                query.setParameter("accountType", "Student");
                query.setParameter("accountId", userName);
                query.setBoolean("isUsed", false);
                schoolAdminList = query.list();
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        return schoolAdminList;
    }
 
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
	
	public List<SchoolAdmin> getAllStudentList(String userName) {
		List<SchoolAdmin> schoolAdminList = new ArrayList<SchoolAdmin>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql = "from SchoolAdmin where accountType = :accountType and accountId =:accountId";
				Query query = session.createQuery(hql);
				query.setParameter("accountType", "Student");
				query.setParameter("accountId", userName);
				schoolAdminList = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return schoolAdminList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean getUniqueUserName(String username) {
		
		List<SchoolAdmin> schoolAdminList = new ArrayList<SchoolAdmin>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql = "from SchoolAdmin where username =:username";
				Query query = session.createQuery(hql);
				
				
				query.setString("username", username);
				schoolAdminList = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			System.out.println("schoolAdminList.toString():"+schoolAdminList.toString());
		if(schoolAdminList.isEmpty()){
			return false;
		}else{
		return true;
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public String getNameFromId(int id) {
		List<SchoolAdmin> schoolAdminList = new ArrayList<SchoolAdmin>();
		 Session session;
		 String name = null;
			try {
				session = sessionFactory.getCurrentSession();
				String hql = "from SchoolAdmin where id =:id";
				Query query = session.createQuery(hql);
				
				query.setInteger("id", id);
				schoolAdminList = query.list();
				for (SchoolAdmin schoolAdmin : schoolAdminList) {
					name = schoolAdmin.getName();
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
		return name;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
    public List<SchoolAdmin> checkStudentInSchool(String schoolId) {
		String accountType  = "Student";
		Session session;
		List<SchoolAdmin> schoolAdminList = null;
		try{
			session = sessionFactory.getCurrentSession();
			System.out.println("IN Service:"+schoolId);
			SQLQuery query = session.createSQLQuery(
					"select * from schoolAdmin s where s.schoolId ='"+schoolId+"' and s.accountType = '"+accountType+"'");		
			schoolAdminList = query.list();
			System.out.println("In schoolAdminServiceForStudent:"+schoolAdminList.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return schoolAdminList;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
    public List<SchoolAdmin> checkSchoolAdminInSchool(String schoolId) {
		String accountType  = "SchoolAdmin";
		Session session;
		List<SchoolAdmin> schoolAdminList = null;
		try{
			session = sessionFactory.getCurrentSession();
			System.out.println("IN Service:"+schoolId);
			SQLQuery query = session.createSQLQuery(
					"select * from schoolAdmin s where s.schoolId ='"+schoolId+"' and s.accountType = '"+accountType+"'");		
			schoolAdminList = query.list();
			System.out.println("In SchoolAdminServiceForSchoolAdmin:"+schoolAdminList.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return schoolAdminList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public int getLastSchoolAdminId() {
		
		Session session;
		String sql="SELECT * FROM schoolAdmin ORDER BY id DESC LIMIT 1";
		session = sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery(sql).addEntity(SchoolAdmin.class);
		SchoolAdmin schoolAdmin = (SchoolAdmin) query.uniqueResult();
		// TODO Auto-generated method stub
		return schoolAdmin.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addRouteToStudent(Route route, int studentid) {
		System.out.println("Route Id: "+route.getRouteNo());
		Session session=sessionFactory.getCurrentSession();
		String sql="insert into routeToStudent (routeId,studentId) values ("+route.getRouteNo()+","+studentid+")";
		SQLQuery query=session.createSQLQuery(sql);
		query.executeUpdate();
		
	}
	
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	    @Override
	    public void addParentToStudent(SchoolAdmin schoolAdmin, int studentid) {
	        System.out.println("Route Id: "+schoolAdmin.getId());
	        Session session=sessionFactory.getCurrentSession();
	        String sql="insert into parentToStudent (parentId,studentId) values ("+studentid+","+schoolAdmin.getId()+")";
	        SQLQuery query=session.createSQLQuery(sql);
	        query.executeUpdate();
	        
	    }
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<RouteToStudent> getAllRouteToStudent() {
		List<RouteToStudent> routeTostudent = new ArrayList<RouteToStudent>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String sql = "select * from routeToStudent";
				Query query = session.createSQLQuery(sql).addEntity(RouteToStudent.class);	
				routeTostudent = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		return routeTostudent;
	}
	

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public SchoolAdmin getParentId(int id) {
        Session session;
        SchoolAdmin  schoolAdmin = null;
        try{
            session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(SchoolAdmin.class);
             criteria.add(Restrictions.eq("id", id));
             Object result=criteria.uniqueResult();
             schoolAdmin = (SchoolAdmin)result;
        }
        catch(Exception e){
 
            e.printStackTrace();
        }
 
        return schoolAdmin;
    }

    
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public List<SchoolAdmin> getAllParentToStudent(int studentId) {
        List<SchoolAdmin> schoolAdminList= null;
        Session session=sessionFactory.getCurrentSession();
        String sql="select parentId from parentToStudent where studentId ="+studentId;
        SQLQuery query=session.createSQLQuery(sql);
        schoolAdminList=query.list();
        String parentId=query.toString();
        System.out.println("parentId"+parentId);
        return null;
    }
 
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public List<Integer> getStduentFromParentToStudent(Integer parentId) {
        List<Integer> studentList = null;
        Session session=sessionFactory.getCurrentSession();
        String sql="select studentId from parentToStudent where parentId ="+parentId;
        SQLQuery query=session.createSQLQuery(sql);
        studentList=query.list();
        return studentList;
    }
    
}
