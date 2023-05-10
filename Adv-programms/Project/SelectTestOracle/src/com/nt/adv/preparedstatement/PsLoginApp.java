package com.nt.adv.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class PsLoginApp {
	
	private static final String LOGIN_QUERY="SELECT COUNT (*) FROM USERLIST WHERE UNAME=? AND PWD=?";

	public static void main(String[] args) {
		
		Scanner sc =null;
		Connection con=null;
		PreparedStatement ps=null;
		String user =null,pss=null;
		ResultSet rs=null;
		
		try {
			sc=new Scanner(System.in);
			if(sc!=null)
				System.out.println("ENTER USER NAME::");
			user=sc.nextLine();
			System.out.println("ENTER PASSWORD::");
			pss=sc.nextLine();
			
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##bishnu","bishnu");
		if(con!=null)
			ps=con.prepareStatement(LOGIN_QUERY);
		if(ps!=null)
			ps.setString(1,user);
		    ps.setString(2, pss);
		    if(ps!=null)
		    	rs=ps.executeQuery();
		    	if (rs!=null)
		    		rs.next();
		    	int count=rs.getInt(1);
		    	if(count==0)
		    		System.out.println( "IN VALID CREDENTIAL");
		    	else
		    		System.out.println("VALID CREDENTIAL");
		    	
		    	

		
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(ClassNotFoundException cnf) {
		cnf.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(rs!=null)
				rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(sc!=null)
				sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}










}
}







    	
	


