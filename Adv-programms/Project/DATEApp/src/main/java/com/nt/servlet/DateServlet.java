package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class DateServlet extends GenericServlet  
{
	public void service (ServletRequest req,ServletResponse res)throws ServletException,IOException{
		
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	Date d=new Date();
		pw.println("<h1> Date and time is ::"+d+"</h1>");
		pw.close();

	}
}
