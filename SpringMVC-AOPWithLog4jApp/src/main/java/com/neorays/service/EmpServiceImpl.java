package com.neorays.service;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("ser")
public class EmpServiceImpl implements EmpService {
	private static final Logger logger = Logger.getLogger(EmpServiceImpl.class);
	
	
	public String wishMsg() {
		System.out.println("service method");
	logger.debug("SERVICE CLASS METHODAS EXECUTES");
	   //decleare rference variable
		int hour=0;
		Calendar cal=null;
	 //create calendar class obj
	 cal=Calendar.getInstance();
	 //get current hour of the day
	 hour=cal.get(Calendar.HOUR_OF_DAY);
	 //write business logic
		if(hour<12)
			return "GOOD MORNING";
		else if(hour<14)
	    	return "GOOD AFTERNOON";
		else if(hour<20)
			return "GOOD EVENING";
		else
			return "GOOD NIGHT";
	}//method

}//class