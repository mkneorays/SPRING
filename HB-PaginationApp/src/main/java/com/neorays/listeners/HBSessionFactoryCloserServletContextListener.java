package com.neorays.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.neorays.util.HibernateUtil;



@WebListener
public class HBSessionFactoryCloserServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("HBSessionFactoryCloserServletContextListener::contextInitalized(-)");
		try{
		  Class.forName("com.neorays.util.HibernateUtil");
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("HBSessionFactoryCloserServletContextListener::contextDestroyed(-)");
		HibernateUtil.closeSessionFactory();
	}
	
}//class
