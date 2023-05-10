package com.advj.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Statement;
//import java.io.IOException;
import java.util.Scanner;


public class Testing2 {
	public static void main(String []args) {
		Scanner sc =null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String desg1=null;
		String desg2=null;
		String desg3=null;
		boolean flag =false;

		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("ENTER DESG1");
				desg1=sc.next().toUpperCase();
				System.out.println("ENTER DESG2");
				desg2=sc.next().toUpperCase();
				System.out.println("ENTER DESG3");
				desg3=sc.next().toUpperCase();
				//    	System.out.println(cond);
			}
			String cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","manager123");
			if(con!=null);
			st=con.createStatement();
			String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN "+cond+"ORDER BY JOB";
			System.out.println(query);
			if (st!=null);
			rs=st.executeQuery(query);
			if(rs!=null);
			while(rs.next()) {
				flag=true;
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getString(4));
			}
			if(flag==false)
				System.out.println("No records found");
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
			catch(Exception se) {
				se.printStackTrace();



			}




		}
	}

}



