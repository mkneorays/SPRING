package com.amu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amu.beans.Users;
import com.amu.dao.UserPageDaoImpl;
import com.amu.service.UserPageService;
import com.amu.service.UserPageServiceImpl;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);
        if(session==null){
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }//if
        else{
		// read user id
		String userId = request.getParameter("user_id");
		// create userService and call method
		UserPageService service = new UserPageServiceImpl();
		Users userById = service.fetchUserById(userId);
		// set users in request obj
		request.setAttribute("userData", userById);
		// forward to jsp page
		request.getRequestDispatcher("WEB-INF/jsp/edit.jsp").forward(request, response);
        }//else
        }// doGet() method

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// call doGet() method
		doGet(request, response);
	}// doPost method
}// class
