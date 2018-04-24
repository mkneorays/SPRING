package com.neorays.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neorays.service.EmpService;


@Controller("wishcontroller")
public class EmpController {

	private static final Logger logger = Logger.getLogger(EmpController.class);
	@Autowired
	private  EmpService ws;
	@RequestMapping("home.htm")
	public String showMs(Map<String, Object> map) {
		System.out.println("home page");
		return "welcome";
	}// showMsg(-) method
	
	@RequestMapping("result.htm")
	public String showMsg(Map<String, Object> map) {
		
		logger.debug("    Welcome in controller!");
	
		String msg = null;
		// use service class
		msg = ws.wishMsg();
		// add message in map object
		map.put("wishMsg", msg);
	//	logger.debug("       final result is "+msg);
		return "result";
	}// showMsg(-) method
}// class