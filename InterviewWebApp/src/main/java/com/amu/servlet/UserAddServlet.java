package com.amu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amu.beans.Users;
import com.amu.errors.DataBaseException;
import com.amu.service.UserPageService;
import com.amu.service.UserPageServiceImpl;
@WebServlet(urlPatterns={"/usersave"})
public class UserAddServlet extends HttpServlet{
	private UserPageService service;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
        if(session==null){
			req.getRequestDispatcher("login.jsp").forward(req, res);
        }//if
        else{
		//read form data
		String userId = req.getParameter("userId");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		if(userId==null || name==null || pass==null)
		{
			req.getRequestDispatcher("/WEB-INF/jsp/user_page.jsp").forward(req, res);

		}
		else{
		//validate and forward jsp page
		if(userId.length()<6){
			req.getRequestDispatcher("/WEB-INF/jsp/user_page.jsp").include(req, res);
			res.getWriter().println("<p style='color: white'>UserId must have atleast 6(six) characters!</p>");
		}//if
		else if(pass.length()<6){
			req.getRequestDispatcher("/WEB-INF/jsp/user_page.jsp").include(req, res);
			res.getWriter().println("<p style='color: white'>Password must have  atleast 6(six) characters!</p>");
		}//else if
		
		if(pass.length()>=6 && userId.length()>=6){
			//create user obj and set data
		Users user=new Users();
		user.setUserId(userId);user.setName(name);user.setPass(pass);
		//create obj  and use service class
		service=new UserPageServiceImpl(); 
		String result = null;
		try {
			//use service method
			result = service.addUsers(user);
		} catch (DataBaseException dbe) {
			//set data into request obj
			req.setAttribute("error", dbe.getMessage());
			//forward success jap page
			req.getRequestDispatcher("error.jsp").forward(req, res);
		} //catch
		//set data into request obj
		req.setAttribute("success", userId);
		//forward success jap page
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/success.jsp");
		rd.forward(req, res);
		}//if
		}//inner else
        }//outter else
	}//doGet method
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//call doGet method
		doGet(req,res);
	}//doPost method
}//class
