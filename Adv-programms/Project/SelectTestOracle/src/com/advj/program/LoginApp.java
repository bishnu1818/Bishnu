package com.advj.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {
	public static void main (String []args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try {
			sc=new Scanner(System.in);
			String user=null, 
			pwd=null;
			if(sc!=null)
				System.out.println("ENTER USER NAME ::");
			user=sc.nextLine();
			System.out.println("ENTER PASSWORD ::");
			pwd=sc.nextLine();
			user="'"+user+"'";
			pwd="'"+pwd+"'";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##bishnu","bishnu");

			if(con!=null)
				st=con.createStatement();
			String query="SELECT COUNT (*) FROM USERLIST WHERE UNAME="+user+" AND PWD="+pwd;
			System.out.println(query);
			if(st!=null)
				rs= st.executeQuery(query);
			if(rs!=null) {
				int count=0; 
				rs.next();
				count=rs.getInt(1);
				if(count==0)
					System.out.println("INVALID USER NAME PASSWORD");
				else
					System.out.println("VALID CREDENTIAL");

			}
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
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();

			}
		}










	}
}







