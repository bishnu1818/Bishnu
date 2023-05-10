package com.advj.program;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertTestOracle {
	public static void main(String []args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			sc=new Scanner(System.in);
			int no=0;
			String name=null; String addr=null; float avg=0.0f;
			if(sc!=null);
			System.out.println("ENTER STUDENT NUMBER::");
			no=sc.nextInt();
			System.out.println("ENTER STUDENT NAME::");
			name=sc.next();
			System.out.println("ENTER STUDENT ADDRESS::");
			addr=sc.next();
			System.out.println("ENTER STUDENT AVERAGE::");
			avg=sc.nextFloat();
			name="'+name+'";
			addr="'+addr+'";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			if(con!=null)
				st=con.createStatement();
			String query="INSERT INTO STUDENT VALUES("+no+","+name+","+addr+","+avg+")";
			System.out.println(query);
			int count=0;
			if (st!=null)
				count=st.executeUpdate(query);
			if (count==0)
				System.out.println("RECORD NOT INSERTED");
			else
				System.out.println("RECORD IS INSERTED");
		}
		catch(SQLException se) {
			if(se.getErrorCode()==1)
				System.out.println("DUPLICATE OR EMPTY VALUE CAN NOT INSERTED TO PRIMERY COLUMN");
			else
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
				if(st!=null)
					st.close();	
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
				if(sc!=null)
					sc.close();	
			}
			catch(Exception e) {
				e.printStackTrace();



			}

		}
		
	}
}
		
