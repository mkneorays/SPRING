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
@WebServlet("/select")
public class SelectUsersServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
        if(session==null){
			req.getRequestDispatcher("login.jsp").forward(req, res);
        }//if
        else{
		List<Users> list;
		//create obj  and use service class
		UserPageService	service=new UserPageServiceImpl(); 
		//use service obj
		list=service.retrieve();
		req.setAttribute("list_users", list);
		//forward to jsp page
		req.getRequestDispatcher("WEB-INF/jsp/select.jsp").forward(req, res);
        }//else
        }//doGet() method
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//call doGet method
		doGet(req,res);
	}//doPost() method
}//class
