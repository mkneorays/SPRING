package com.amu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
        if(session==null){
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }//if
        else{
		//forward login jsp page
        	session.invalidate();
		request.setAttribute("message", "logged out successfully");
			request.getRequestDispatcher("login.jsp").forward(request, response);
        }//else
        }//doGet method
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//call doGet method
		doGet(request, response);
	}//doPost method
}//class
