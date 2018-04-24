package com.neorays.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();
	
	static{
		 Configuration cfg=null;	
		  StandardServiceRegistryBuilder builder=null;
		  StandardServiceRegistry registry=null;
		   //Bootstraping of Hibenrate
		  cfg=new Configuration();
		  //load both XML file(cfg file)
		  cfg.configure("/com/neorays/cnfgs/hibernate-cfg.xml");
		  //create ServieRegistryBuilder
		  builder=new StandardServiceRegistryBuilder();
		  //create SErviceRegistry
		  registry=builder.applySettings(cfg.getProperties()).build();
		  //build HB SessionFactory
		  factory=cfg.buildSessionFactory(registry);
		  //factory=cfg.buildSessionFactory();
	}
	
	public static Session getSession(){
		Session ses=null;
		if(threadLocal.get()==null){
			ses=factory.openSession();
			threadLocal.set(ses);
			return ses;
		}
		else{
			ses=threadLocal.get();
			return ses;
		}
	}//getSession()
	
	public static void closeSession(){
		Session ses=null;
		if(threadLocal.get()!=null){
			ses=threadLocal.get();
			ses.close();
			threadLocal.remove();
		}
	}//closeSession
	
	public static  void closeSessionFactory(){
		 if(factory!=null){
			 factory.close();
			 System.out.println("SessionFactory obj is closed");
		 }
		 
	}//closeSessionFactory
	

}//class
