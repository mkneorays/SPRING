package com.neorays.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neorays.command.EmpInsertCommand;
import com.neorays.command.LoginCommand;
import com.neorays.command.RegisternCommand;
import com.neorays.dto.EmpInsertDTO;
import com.neorays.dto.LoginDTO;
import com.neorays.dto.RegisterDTO;
import com.neorays.service.EmployeeService;

@RestController
public class EmpController {
	private static boolean flag=false;
	static HttpSession session=null;
	@Autowired
	private EmployeeService service;

	@RequestMapping(value="/home.htm",method=RequestMethod.GET)
	public String loginPage(){
		
		//return logicalViewName
		return "login";
	}//loginPage
	@RequestMapping(value="/logout.htm",method=RequestMethod.GET)
	public String logout(){
		//remove session attribute data
		session.removeAttribute("user");
		session.removeAttribute("psw");
		//this is for second tym login
		flag=false;
		
		//return logicalViewName
		return "login";
	}//logout method

	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	public String register(Map<String,Object> map,@ModelAttribute RegisternCommand cmd) throws Exception{
		RegisterDTO dto=null;
		//create dto object
		dto=new RegisterDTO();
		//convert cmd obj to dto obj
		BeanUtils.copyProperties(cmd, dto);
		//use service class
		String result=service.registerEmp(dto);
		//set response in map
		map.put("data", result);
		return "login";
	}//process method
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String login(Map<String,Object> map,@ModelAttribute LoginCommand cmd,HttpServletRequest req) throws Exception{
		String result=null;
		//get Session obj
		session=req.getSession();
			if(flag==false){
		 LoginDTO dto=null;
		//create dto object
		dto=new  LoginDTO();
		//convert cmd obj to dto obj
		BeanUtils.copyProperties(cmd, dto);
		//use service class
		 result=service.loginEmp(dto);
		}//if
		//set response in map
		if(result=="fail"){
		map.put("authorise", "NOT REGISTERED PLEASE GO TO CREATE AN ACCOUNT");
		return "login";
		}
		else{
			 //set user and psw in session
			session.setAttribute("user", cmd.getUser());
			session.setAttribute("psw", cmd.getPsw());
			flag=true;
		    return "home";
		}
	}//login method
	
	@RequestMapping(value="/insert.htm",method=RequestMethod.GET)
	public String insertEmp(Map<String,Object> map,@ModelAttribute EmpInsertCommand cmd){
		EmpInsertDTO dto=null;
		//create dto object
		dto=new com.neorays.dto.EmpInsertDTO();
		//convert cmd obj to dto obj
		BeanUtils.copyProperties(cmd, dto);
		//use service class
		String result=service.insertEmp(dto);
		//set response in map
		map.put("insert", result);
		  return "home";
	}//login method
	
	@RequestMapping(value="/select.htm",method=RequestMethod.GET)
	public String selectEmp(Map<String,Object> map,HttpServletRequest req){
		System.out.println("controller class");
		int pageNo=0;
		List<EmpInsertDTO> listDTO=null;
		int pageCount=0;
		
		//read pageNo
		pageNo=Integer.parseInt(req.getParameter("pageNo"));
	
		//use service class
		if(service!=null)
		listDTO=service.getReportData(pageNo);
		//get PageCount
		pageCount=service.getPageCount();
		
		//keep ListDTO in request scope
		map.put("pageCount", pageCount);
		map.put("reportData", listDTO);
		
		//return logicalViewName
		return "select";
	}//selectEmp method
	
	@RequestMapping(value="/delete.htm")
	public String deleteEmp(Map<String,Object> map,HttpServletRequest req){
		String result=null;
		List<EmpInsertDTO> listCmd=null;
		int eid=Integer.parseInt(req.getParameter("eid"));
		//use service method
		result=service.deleteEmp(eid);
		
		//set response in map
		 map.put("delete",result);
		//return logicalViewName
		return "delete";
	}//deleteEmp method
	
	@RequestMapping(value="/update.htm")
	public String updateEmp(Map<String,Object> map,HttpServletRequest req){
	     map.put("eeid", req.getParameter("id"));
		//return logicalViewName
		return "update";
	}//deleteEmp method
	
	@RequestMapping(value="/cred.htm")
	public String loginCred(Map<String,Object> map){
		List<RegisterDTO> list=null;
		//use Service class
		list=service.loginCred();
		//set response in map
		map.put("loginList",list);
		
		//return logicalViewName
		return "loginList";
	}//loginPage
	
}//class
