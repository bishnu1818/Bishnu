package com.nt.jdbc.cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTestSum {
	
	private static final String CALL_PROCEDURE="{CALL P_SUM(?,?,?)}";

	public static void main(String []args) {
		
		int first=0,second=0;
		
		try(Scanner sc=new Scanner(System.in)){
			if(sc!=null) {
				System.out.println("ENTER FIRST NUMBER::");
				first=sc.nextInt();
				System.out.println("ENTER SECOND NUMBER");
				second=sc.nextInt();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
			CallableStatement cs=con.prepareCall( CALL_PROCEDURE);	
				){
			if(cs!=null)
				cs.registerOutParameter(3,Types.INTEGER);
			if(cs!=null)
				cs.setInt(1,first);
			    cs.setInt(2, second);
				
		    if(cs!=null)
	    	 cs.execute();
		    if(cs!=null) {
		    	int result=0;
		    	result=cs.getInt(3);
		    	System.out.println("Sum::"+result);
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
