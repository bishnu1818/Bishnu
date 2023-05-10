package com.advj.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class OracleCountTesting {

	public static void main(String[] args) {
		Connection con=null;
			Scanner sc=null;
		ResultSet rs=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
			if(con!=null)
				st=con.createStatement();
			String query="SELECT COUNT(*) FROM EMP";
			if(st!=null)
				rs=st.executeQuery(query);
			if(rs!=null)
				rs.next();
			System.out.println("COUNT OF RECORDS::"+rs.getInt("COUNT(*)"));
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
				if(con!=null)
					con.close();
			}
        catch(SQLException se) {
        	se.printStackTrace();
        }
			try {
				if(rs!=null)
					rs.close();
			}
        catch(SQLException se) {
        	se.printStackTrace();
        }
			try {
				if(st!=null)
					st.close();
			}
        catch(SQLException se) {
        	se.printStackTrace();
        }
			 
			 

		}
	}



}


