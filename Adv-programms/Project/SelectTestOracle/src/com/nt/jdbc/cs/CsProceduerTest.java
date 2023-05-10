package com.nt.jdbc.cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProceduerTest {
	
	private static final String CALL_PROCEDURE="{CALL P_GET_EMPDETAILS_BY_NO(?,?,?,?)}";
		
		public static void main (String[] args ) {
			
			int no=0;

		
		try(Scanner sc=new Scanner(System.in)){
			
			
			
		if(sc!=null) {
			System.out.println("ENTER EMPLOYEE NUMBER::");
		no=sc.nextInt();
		}
		}	
		
		catch(Exception e) {
			e.printStackTrace();
		}
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
		CallableStatement cs=con.prepareCall( CALL_PROCEDURE);
		){
		 
		
		if(cs!=null) {
		
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.FLOAT);
			
		}
		if(cs!=null) 
		cs.setInt(1,no);
			
			
		
		if(cs!=null) 
			cs.execute();
		
		if(cs!=null) {
			System.out.println("ENTER NAME OF EMPLOYEE\t::\t"   +cs.getString(2));
			System.out.println("ENTER DESG OF EMPLOYEE\t::\t"    +cs.getString(3));
			System.out.println("ENTER SALARY OF EMPLOYEE\t::" +cs.getFloat(4));
			
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
