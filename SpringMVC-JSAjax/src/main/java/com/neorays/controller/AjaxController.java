package com.neorays.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping(value = { "/first.htm" }, method = RequestMethod.GET)
	public String homePage() {

		return "home";
	}// homePage method

	@RequestMapping(value = { "/second.htm" }, method = RequestMethod.GET)
	@ResponseBody
	public String processPage(HttpServletRequest req) {
		String namesDictionary[] = { "raja", "rani", "jani", "phani", "anil",
				"anitha", "sony", "ghani", "gajani", "dhoni", "charan",
				"chitti", "somi", "pomi", "rajani", "baba", "ram", "raheem",
				"om", "raderam", "nachoram", "sadguru", "modi", "rahul",
				"pappu", "sindhu", "saina", "sania", "sonia", "mahesh",
				"tarak", "kattapa", "bahubhali", "bharhimi", "ali", "sunil",
				"subbu" };
		// read req param value
		String hint = req.getParameter("q").trim();
		System.out.println(hint);
		String suggestion = "";
		// send names suggestions
		for (String name : namesDictionary) {
			if (name.toUpperCase().startsWith(hint.toUpperCase())) {
				suggestion = suggestion + name + ",";
			}
		}// for
		System.out.println(suggestion);
        
		if (suggestion.length() == 0 || suggestion.equalsIgnoreCase(""))
			suggestion="<b> No Suggestions</b>";
		

		return suggestion;
	}// processPage method
}// class
