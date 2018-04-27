package com.neorays.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neorays.command.Customer;
import com.neorays.command.ResponseData;
import com.neorays.util.JavatoJsonUtil;

@RestController
public class RegdController {

	@RequestMapping(value ="first.htm",method=RequestMethod.GET)
	public String employeeForm() {
		//System.out.println("home method");
		//return "employeeForm";
		return "ajax";
	}// employeeForm method	
	
	@RequestMapping(value = "/second.htm",  method=RequestMethod.POST)
	@ResponseBody
	public String postCustomer(@ModelAttribute Customer customer) {
		
		
		System.out.println("process method "+customer);
	 List<Customer> cust = new ArrayList<Customer>();
		cust.add(customer);
		
		// Create Response Object
		ResponseData response = new ResponseData("Done", customer);
		
         String jsonData=JavatoJsonUtil.convertJavaToJson(response);
         System.out.println("response data "+jsonData);
		return jsonData;
	}//method

}// class