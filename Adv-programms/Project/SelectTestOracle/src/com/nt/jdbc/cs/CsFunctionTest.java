package com.nt.jdbc.cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;
import java.sql.SQLException;

public class CsFunctionTest {
	
	private static final String CALL_FUNCTION="{?=CALL_FX_GET_EMP_DETAILS_BY_ENO(?,?,?,?)}";
	public static void main (String []args) {
		
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
			  CallableStatement cs=con.prepareCall( CALL_FUNCTION);
					){
			int no=0;
			if(sc!=null) {
				System.out.println("ENTER EMPLOYEE NUMBER::");
				no=sc.nextInt();
				
			}
			if(cs!=null) {
		     	cs.registerOutParameter(1,Types.INTEGER);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.INTEGER);
			}
			if(cs!=null) 
				cs.setInt(2, no);
			if(cs!=null)
				cs.execute();
			
			if(cs!=null) {
				System.out.println("EMPLOYEE NAME::"+cs.getString(3));
				System.out.println("EMPLOYEE DESG::"+cs.getString(4));
				System.out.println("EMPLOYEE SALARY::"+cs.getInt(5));
				System.out.println("EMPLOYEE DEPTNO::"+cs.getInt(1));
				
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
