package com.amu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amu.beans.Users;
import com.amu.service.UserPageService;
import com.amu.service.UserPageServiceImpl;
@WebServlet("/search")
public class SearchUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
        if(session==null){
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }//if
        else{
		List<Users> list=null;
		//read form parameters
		String srch = request.getParameter("s");
		//create service class obj and use service
		UserPageService	service=new UserPageServiceImpl(); 
		list=service.search(srch);
		//set date in request obj
		request.setAttribute("list_users", list);
		//forward command to jsp page
		request.getRequestDispatcher("WEB-INF/jsp/select.jsp").forward(request, response);
        }//else
        }//doGet() method

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// call doGet method
		doGet(request, response);
	}//doPost() method
}//class
