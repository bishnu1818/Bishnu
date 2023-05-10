package com.advj.program;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//import java.io.IOException;

public class Testing3 {
	public static void main(String[]args) {
		Connection con=null;
		Scanner sc=null;
		ResultSet rs=null;
		Statement st=null;
		boolean flag=false;

		try {
			sc=new Scanner(System.in);
			int no=0;
			if (sc!=null)
				System.out.println("ENTER EMPLOYEE NUMBER::");
			no=sc.nextInt();

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
			if(con!=null)
				st=con.createStatement();
			String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO="+no;
			if(st!=null)
				rs=st.executeQuery(query);
			if(rs!=null)
				//	while(rs.next()) {
				if(rs.next()) {
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"  "+rs.getString(4));


				}
				else {
					System.out.println("EMPLOYEE RECORD NOT FOUND");

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
				if(con!=null)
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
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
		}
	}
	


}
