package com.neorays.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/depturl")
public class GetDeptDetailsServlet extends HttpServlet {
	private static final String  GET_DEPTDETAILS_BY_NO="SELECT NAME,LOC FROM DEPT1 WHERE NO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   Connection con=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   int dno=0;
		//general settings
	   pw=res.getWriter();
	   res.setContentType("text/xml");
	   //read form data
	   dno=Integer.parseInt(req.getParameter("deptno"));
	   // System.out.println(dno);
	   try{
	   //register jdbc driver
	    Class.forName("org.postgresql.Driver");
	    //estblish the connection   jdbc:postgresql://localhost:5432/neorays
	    con=DriverManager.getConnection("jdbc:postgresql:neorays", "postgres","POSTGRASQL");
	    //create PreparedStatement object    
	    ps=con.prepareStatement(GET_DEPTDETAILS_BY_NO);
	    //set query param value
	    ps.setInt(1,dno);
	    //execute query
	    rs=ps.executeQuery();
	    //process the ResultSet
	    pw.println("<dept>");
	     if(rs.next()){
	    	 pw.println("<dname>"+rs.getString(1)+"</dname>");
	    	 pw.println("<dloc>"+rs.getString(2)+"</dloc>");
	     }//if
	     pw.println("</dept>");
	   }//try
	   catch(SQLException se){
		   se.printStackTrace();
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
		//close stream
	     pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)
	
}//class
