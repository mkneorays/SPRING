package com.neorays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.neorays.domain.Product;
import com.neorays.util.HibernateUtil;


public class PaginationProductDAOImpl implements PaginationProductDAO {

	public long rowCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null;
		List<?>  list=null;
		long count=0l;
		//get Session
		System.out.println(2);
	     if(ses!=null)
		ses=HibernateUtil.getSession();
	     System.out.println(3);
		//create Criteria
		criteria=ses.createCriteria(Product.class);
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

	public List<Product> getProducts(int startPos, int pageSize) {
		Session ses=null;
		Criteria criteria=null;
		List<Product> list=null;
		System.out.println(4);
		//get Session
		
		ses=HibernateUtil.getSession();
		System.out.println(5+"   "+ses);
		//create Criteria
		criteria=ses.createCriteria(Product.class);
		//perform pagination
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(pageSize);
		//execute QBC
		list=criteria.list();
		System.out.println("dao"+list);
		return list;
	}//getProducts(-,-)
}//class
