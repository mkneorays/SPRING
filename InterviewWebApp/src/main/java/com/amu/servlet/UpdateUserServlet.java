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
@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
        if(session==null){
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }//if
        else{
    	//read form data
    	String id=request.getParameter("id");
    		String name= request.getParameter("name");
    		String psw= request.getParameter("pass");
        //validate data
    		if(id.length()>=6 && psw.length()>=6){
    			//use service method
    		UserPageService	service=new UserPageServiceImpl();
    		  String  result=service.updateUser(id, name, psw);
    		  //set data in request obj 
    		request.setAttribute("update", result);
    		//forward command to jsp page
    		request.getRequestDispatcher("WEB-INF/jsp/update.jsp").forward(request, response);
    		}//if
        }//else
    }//doGet method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//call doGet  method
		doGet(request, response);
	}//doPost method
}//class
