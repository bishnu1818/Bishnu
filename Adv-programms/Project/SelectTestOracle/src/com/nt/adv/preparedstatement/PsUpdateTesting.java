package com.nt.adv.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsUpdateTesting {
	private static final String STUDENT_UPDATE_QUERY="UPDATE STUDENT SET NAME=?,ADDR=?,AVG=? WHERE NO=?";
	public static void main (String []args) {

		Scanner sc =null;
		Connection con=null;
		PreparedStatement ps=null;
		

		try {

			sc=new Scanner(System.in);
			String newName=null,newaddr=null;
			float newavg=0.0f;
			int No=0;
			if(sc!=null)
				System.out.println("ENTER STUDENT NO::");
			No=sc.nextInt();
			System.out.println("ENTER NEW Name OF STUDENT::");
			newName=sc.next();
			System.out.println("ENTER NEW ADDR OF STUDENT::");
			newaddr=sc.next();
			System.out.println("ENTER NEW AVG OF STUDENT::");
			newavg=sc.nextFloat();
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
		if(con!=null)
			ps=con.prepareStatement(STUDENT_UPDATE_QUERY);
 
		if(ps!=null) {
			ps.setString(1,newName);
			ps.setString(2, newaddr);
		    ps.setFloat(3, newavg);
		    ps.setInt(4, No);
			
		}
		
		int count=0;
		if(ps!=null)
			count=ps.executeUpdate();
		if (count==0)
			System.out.println("STUDENT RECORD NOT FOUND");
		else
			System.out.println(count+"NUMBER OF STUDENT RECORD UPDATED");
			


	}
		catch (SQLException se) {
			se.printStackTrace();
		} 
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();

		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (sc != null)
					sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}
}

	
	  










