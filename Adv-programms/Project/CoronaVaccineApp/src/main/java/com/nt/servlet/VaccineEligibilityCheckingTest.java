 package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineEligibilityCheckingTest extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		String name=req.getParameter("Pname");
		String addrs=req.getParameter("pPaddrs");
		int age=Integer.parseInt(req.getParameter("Page"));
		
		if(age<18)
			pw.println("<h1 style='color:red:text-align:center'>MR/MS/MRS."+name+"U ARE NOT ELIGIBLE FOR VACCINATON</h1>");
		else
		    pw.println("<h1 style='color:grene:text-align:center'>MR/MS/MRS."+name+"U ARE ELIGIBLE FOR VACCINATION</h1>");
		pw.println("<a href='http://localhost:2222/CoronaVaccineApp/Corona_vaccine.html'><img src='images/image.jpg'></a>");
		
		pw.close();
		
	}

}
