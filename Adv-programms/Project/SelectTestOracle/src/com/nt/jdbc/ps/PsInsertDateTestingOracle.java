package com.nt.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PsInsertDateTestingOracle {
	
	private static final String GET_CITIZEN_DETAILS="INSERT INTO CITIZEN_DETAILS VALUES(?,?,?,?,?,?)";
	public static void main(String []args) {
		
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			sc=new Scanner(System.in);
			int cno=0;
			String name=null;
			String addr=null;
			String dob=null,dom=null,doj=null;
			
			if(sc!=null) {
				System.out.println("ENTER CITIZEN ID::");
				cno=sc.nextInt();
				System.out.println("ENTER CITIZEN NAME::");
				name=sc.next();
				System.out.println("ENTER CITIZEN ADDRESS::");
				addr=sc.next();
				System.out.println("ENTER CITIZEN DATE OF BARTH(DD-MM-YYYY)::");
				dob=sc.next();
				System.out.println("ENTER CITIZEN DATE OF MARRIAGE(MM-DD-YYYY)::");
				dom=sc.next();
				System.out.println("ENTER CITIZEN DATE OF JOIN(YYYY-MM-DD)::");
				doj=sc.next();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date udob=sdf.parse(dob);
				long ms=udob.getTime();
				java.sql.Date sdob=new java.sql.Date(ms);
				SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
				java.util.Date udom=sdf1.parse(dom);
				java.sql.Date sdom=new java.sql.Date(udom.getTime());
				java.sql.Date sdoj=java.sql.Date.valueOf(doj);
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
				if(con!=null)
					ps=con.prepareStatement(GET_CITIZEN_DETAILS);
					ps.setInt(1,cno);
				    ps.setString(2,name);
				    ps.setString(3,addr);
				    ps.setDate(4,sdob);
				    ps.setDate(5,sdom);
				    ps.setDate(6,sdoj);
			}
			int result=ps.executeUpdate();
			if(result==0)
				System.out.println("ACTION (RECORD INSERTION) IS WESTED");
			else
				System.out.println("ACTION (RECORD ARE INSERTION) IS SUCCESSFUL");
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
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			
		
				    
				
				
				
				
				
				
				
			}
					
		}
		
	}

}
