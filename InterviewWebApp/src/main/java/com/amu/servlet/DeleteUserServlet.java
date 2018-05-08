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
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
        if(session==null){
			req.getRequestDispatcher("login.jsp").forward(req, res);
        }//if
        else{
		List<Users> list=null;
		//read user id
		String id=req.getParameter("user_id");
		//create obj  and use service class
		UserPageService	service=new UserPageServiceImpl(); 
		//use service method for delete user
		String result=service.deleteUser(id);
		//use service method for reterving users
		list=service.retrieve();
		//set users data in request obj
		req.setAttribute("list_users", list);
		//forward to jsp page
		req.getRequestDispatcher("WEB-INF/jsp/select.jsp").forward(req, res);
        }//else
        }//doGet() method
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//call doGet() method
		doGet(req,res);
	}//doPost() method
}//class
