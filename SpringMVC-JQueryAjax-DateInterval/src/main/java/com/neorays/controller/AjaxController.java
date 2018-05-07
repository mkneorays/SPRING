package com.neorays.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping(value={"/first.htm"},method=RequestMethod.GET)
	public String homePage(){
		System.out.println("homePage");
		return "home";
	}//method
	
	@RequestMapping(value={"/second.htm"})
	  @ResponseBody
	public String processPage(){
		System.out.println("processPage");
		Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        //System.out.println("Controller.." + new Date().toString());
		return result;
	}//method
}//class
