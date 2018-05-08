package com.amu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String pass = req.getParameter("pass");
		if (userId != null || pass != null) {
			if (userId.length() < 6) {
				// check valid user data
				req.setAttribute("user_error",
						"userid  must contain atleast 6 characters");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			} else if (pass.length() < 6) {
				// check valid user data
				req.setAttribute("psw_error",
						"Password  must contain atleast 6 character");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			} else {
				//get Session obj
				HttpSession session=req.getSession();
				session.setAttribute("user_id", userId);
				session.setAttribute("psw", pass);

				// forward user_jsp page
				req.getRequestDispatcher("WEB-INF/jsp/user_page.jsp").forward(
						req, res);
			}// inner else
		}// if
		else {
			// forward login jsp page
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}// outer else
       
	}// doGet(-,-) method

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// call doGet method
		doGet(req, res);
	}// doPost(-,-) method

}// class

