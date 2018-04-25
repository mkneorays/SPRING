package com.neorays.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neorays.dto.ProductDTO;
import com.neorays.service.PaginationProductService;
import com.neorays.service.PaginationProductServiceFactory;

//@WebServlet("/controller")
public class PaginationControllerServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("servlet class");
		PrintWriter pw=null;
		int pageNo=0;
		PaginationProductService service=null;
		List<ProductDTO> listDTO=null;
		int pageCount=0;
		RequestDispatcher rd=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read pageNo
		pageNo=Integer.parseInt(req.getParameter("pageNo"));
		//get Service class
		service=PaginationProductServiceFactory.getInstance();
		System.out.println("1");
		//use service class
		if(service!=null)
		listDTO=service.getReportData(pageNo);
		//get PageCount
		pageCount=service.getPageCount();
		//keep ListDTO in request scope
		req.setAttribute("reportData",listDTO);
		req.setAttribute("pageCount", pageCount);
		//forward request to report.jsp
		rd=req.getRequestDispatcher("/report.jsp");
		rd.forward(req,res);
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
