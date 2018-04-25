package com.neorays.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addurl")
public class AjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=null;
		int val1=0,val2=0;
		int sum=0;
		//general settings
		pw=response.getWriter();
		response.setContentType("text/html");
		//read form data
		val1=Integer.parseInt(request.getParameter("t1"));
		val2=Integer.parseInt(request.getParameter("t2"));
		//perform additon
		sum=val1+val2;
		//send output
		pw.println(sum);
		//close stream
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
