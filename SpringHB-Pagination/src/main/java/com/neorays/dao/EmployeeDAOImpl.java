package com.neorays.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neorays.domain.EmpInsertBO;
import com.neorays.domain.LoginBO;
import com.neorays.util.HibernateUtil;

@Repository("mithu")
@Transactional(readOnly=false)
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String NATIVE_SQL_LOGIN_QUERY="SELECT * FROM LOGIN_EMP WHERE NAME=:user";
	private static final String HQL_GET_EMP_DETAILS="FROM EmpInsertBO";
	private static final String HQL_DELETE_EMP_DETAILS="DELETE FROM  EmpInsertBO WHERE eid=?";
	//private static final String HQL_UPDATE_EMPLOYEE = "UPDATE SpStudentHLO SET sadd=? WHERE sno=?";
	@Resource
	HibernateTemplate ht;
	@Resource
	SessionFactory factory;

	
	public int loginInsert(LoginBO bo) throws Exception {
		
		//use hibernateTemplate
		int count=(Integer) ht.save(bo);
        return count;
	}// loginInsert

	
	public int authentaction(LoginBO bo) throws Exception {
		
		final String username=bo.getName();
		final String pwd=bo.getPsw();
		int count=0;
		
		count=ht.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session ses) throws HibernateException {
				SQLQuery query=null;
				Query query1=null;
				 LoginBO bo=null;
				List<LoginBO> list1=null;
				query=ses.createSQLQuery(NATIVE_SQL_LOGIN_QUERY);
				query.setString("user", username);
				//map with Entity class
				 query.addEntity(LoginBO.class);
				 //execute the query
				 list1=query.list();
		 
				 if(list1.isEmpty()==true){
				
				 return 0;
				 }//outer if
				 else{
					 bo=list1.get(0);
					 if(username.equals(bo.getName()) && pwd.equals(bo.getPsw()))
			    	 return 1;
					 else
						 return 0;
				 }//outer else
			   
			}//doInHibernate(-)
		});
		
		return count;
	}//authentataction method

	//@Transactional(readOnly=false)
	public int insertEmp(EmpInsertBO bo) {
		//ht.setCheckWriteOperations(false);
		/* ANY ONE U HV TO USE EITHER @Transactional annotaion or this method
		 *  bcoz of above statement org.springframework.dao.InvalidDataAccessApiUsageException:
			Write operations are not allowed in read-only mode (FlushMode.MANUAL):
				Turn your Session into FlushMode.COMMIT/AUTO or remove 'readOnly' marker from transaction definition.
		*/
          //use HibernateTemplate
		int count=(Integer) ht.save(bo);
		
		return count;
	}//insertEmp method


	public List<EmpInsertBO> selectEmp() {
	
		List<EmpInsertBO> list=null;
		//use HibernateTemplate
		list=(List<EmpInsertBO>) ht.find(HQL_GET_EMP_DETAILS);
		
		return list;
	}//selectEmp method


	public int deleteEmp(int eid) {
	      //use hibernate template
		ht.setCheckWriteOperations(false);
		int count=ht.bulkUpdate(HQL_DELETE_EMP_DETAILS, eid);
		return count;
	}//deleteEmp method

	//@Transactional  //this is requried otherwise org.hibernate.HibernateException:
	    //Could not obtain transaction-synchronized Session for current thread at 
	public List<LoginBO> loginCred() {
		Session ses=factory.getCurrentSession();
		System.out.println("method start");
		Criteria cr=null;
		List<LoginBO> list=null;
		//get criteria obj
		cr=ses.createCriteria(LoginBO.class);
		list=cr.list();
		System.out.println("method end"+list);
		return list;
	}//loginCred

	//private static Session sess=null;
	//@Transactional 
	public long rowCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null;
		List<?>  list=null;
		long count=0l;
		//get Session
	    // if(ses!=null)
		ses=factory.getCurrentSession();
		//create Criteria
		criteria=ses.createCriteria(EmpInsertBO.class);
		//create Projection
		p1=Projections.rowCount();
		//add Projection obj Criteria
		criteria.setProjection(p1);
		//execute QBC
		list=criteria.list();
		//Process List
		count=(Long)list.get(0);
		System.out.println("dao count"+count);
		return count;
	}

	//@Transactional 
	public List<EmpInsertBO> getProducts(int startPos, int pageSize) {
		Session ses=null;
		
		Criteria criteria=null;
		List<EmpInsertBO> listBO=null;
		System.out.println(4);
		//get Session
		
		ses=factory.getCurrentSession();
		//create Criteria
		criteria=ses.createCriteria(EmpInsertBO.class);
		//perform pagination
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(pageSize);
		//execute QBC
		listBO=criteria.list();
		System.out.println("dao"+listBO);
		return listBO;
	}
	
	/*@Override
	public int update(int sno, String newAddrs) {
		int count = 0;
		ht.setCheckWriteOperations(false);
		count = ht.bulkUpdate(HQL_UPDATE_STUDENT, newAddrs, sno);
		return count;
	}*/
	

}// class

