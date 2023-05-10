package com.nt.jdbc.cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class CsProcedureCursorTest {
	
	private static final String CALL_PROCEDURE="{CALL p_GET_EMP_DETAILS_BY_DESG(?,?,?,?)}";
	public static void main(String []args) {
		
		try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
		  CallableStatement cs=con.prepareCall( CALL_PROCEDURE);
				){
			String desg1=null,desg2=null,desg3=null;
			if(sc!=null) {
				System.out.println("ENTER DESG1::");
				desg1=sc.next();
				System.out.println("ENTER DESG2::");
				desg2=sc.next();
				System.out.println("ENTER DESG3::");
				desg3=sc.next();
			}
			if(cs!=null)
				cs.registerOutParameter(4 ,OracleTypes.CURSOR );
			if(cs!=null) {
				cs.setString(1,desg1);
				cs.setString(2,desg2);
				cs.setString(3,desg3);
			}
			if(cs!=null)
				cs.execute();
			if(cs!=null) {
				ResultSet rs=(ResultSet)cs.getObject(4);
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getString(5));
				}
						
			}		
						
						
		}			
				catch(SQLException se) {
					se.printStackTrace();
				}
		       catch (Exception e) {
		    	   e.printStackTrace();
						
			}
				
				
			
			
		}
	

}
