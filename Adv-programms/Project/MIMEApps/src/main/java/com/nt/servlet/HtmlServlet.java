package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet{
   
   public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
       res.setContentType("text/html");
	   PrintWriter pw=res.getWriter();

	   pw.println("<table border='1'align='center'>");
	   pw.println("<tr><th>player name</th><th>series</th><th>run</th><th>wicket</th></tr>");
	   pw.println("<tr><td>virat kohli</td><td>BAN</td><td>100</td><td>0</td></tr>");
	   pw.println("<tr><td>rahul</td><td>BAN</td><td>120</td><td>0</td></tr>");
	   pw.println("<tr><td>gill</td><td>BAN</td><td>200</td><td>0</td></tr>");
	   pw.println("<tr><td>pujar</td><td>BAN</td><td>300</td><td>0</td></tr>");
	   pw.println("<tr><td>siraj</td><td>BAN</td><td>20</td><td>10</td></tr>");
	   pw.println("<tr><td>axer</td><td>BAN</td><td>80</td><td>12</td></tr>");
	   
	   pw.close();
   }
}