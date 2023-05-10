package com.nt.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PsOracleSequenceTest {
	private static final String INSERT_CITIZEN_DETAILS="INSERT INTO CITIZEN_DETAILS VALUES(CID_SEQ1.NEXTVAL,?,?,?,?,?)";

	public static void main(String []args) {
		Scanner sc=null;
		PreparedStatement ps=null;
		Connection con=null;

		try {
			sc=new Scanner(System.in);
			String name=null;
			String addr=null;
			String dob=null;
			String dom=null;
			String doj=null;

			if(sc!=null) {
				System.out.println("ENTER CITIZEN NAME::");
				name=sc.next();
				System.out.println("ENTER CITIZEN ADDRESS::");
				addr=sc.next();
				System.out.println("ENTER CITIZEN DATE OF BARTH(DD-MM-YYYY)::");
				dob=sc.next();
				System.out.println("ENTER CITIZEN DATE OF MARRIAGE(MM-DD-YYYY)::");
				dom=sc.next();
				System.out.println("ENTER CITIZEN DATE OF JOIN(YYYY-MM-DD)::");
				doj=sc.next();
			}
			SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
			java.util.Date judob= sdf.parse(dob);
			long ms=judob.getTime();
			java.sql.Date sqdob=new java.sql.Date(ms);

			SimpleDateFormat sdf1=new SimpleDateFormat("MM-DD-YYYY");
			java.util.Date judom=sdf1.parse(dom);
			java.sql.Date sqdom=new java.sql.Date(judom.getTime());

			java.sql.Date sqdoj=java.sql.Date.valueOf(doj);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","manager123");


			if(con!=null)
				ps=con.prepareStatement(INSERT_CITIZEN_DETAILS);
			if(ps!=null) {
				ps.setString(1,name);
				ps.setString(2, addr);
				ps.setDate(3, sqdob);
				ps.setDate(4, sqdom);
				ps.setDate(5, sqdoj);

				int result=ps.executeUpdate();
				if(result==0)
					System.out.println("ACTION  RECORD INSERT RESULT IS WESTED");
				else 
					System.out.println("ACTION( RECORD INSERT SUCCESSFUL)");
			}

		}

		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}


	}
	
}
