package com.nt.jdbc.cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTest2 {
	private static final String CALL_PROCEDURE="{CALL P_AUTH_EMP(?,?,?)}";
	
    public static void main (String[] args) {
    	
    	try(Scanner sc=new Scanner(System.in);
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##bishnu","bishnu");
    			CallableStatement cs=con.prepareCall( CALL_PROCEDURE);
    			){
    				
    				String uname=null,pwd=null;
    		
    		if(sc != null) {
    			System.out.println("ENTER USER NAME::");
    			uname=sc.nextLine();
    			System.out.println("ENTER PASSWARD NAME::");
    			pwd=sc.nextLine();
    		
    		}
    		
    		if(cs!=null) 
    	      cs.registerOutParameter(3,Types.VARCHAR);
    			
    		
    		if(cs!=null) {
    		cs.setString(1,uname);
    		cs.setString(2,pwd);
    			
    			
    		
    		if(cs!=null) 
    			cs.execute();
    		
    		if(cs!=null) {
             System.out.println("Result is::"+cs.getString(2));
             
    		}
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
