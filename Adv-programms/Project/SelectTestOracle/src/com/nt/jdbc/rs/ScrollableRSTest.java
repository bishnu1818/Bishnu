package com.nt.jdbc.rs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableRSTest {
	
	private static final String GET_EMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	
	
	public static void main(String []args) {

	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(GET_EMP_QUERY)){
		  System.out.println("ENTER RECORD TOP TO BOTTOM");
		  
		  if(rs!=null) {
			  while(rs.next()) {
				  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				  
			  }
			  rs.afterLast();
		  }
	
	 System.out.println("----------------");
			  if(rs!=null) {
				  rs.first();
				  System.out.println( rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				  rs.last();
				  System.out.println(rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				  rs.relative(-4);
				  System.out.println( rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				  rs.absolute(4);
				  System.out.println( rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				  rs.absolute(-8);
				  System.out.println( rs.getRow()+"---->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			  }
				
			}
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}

}
