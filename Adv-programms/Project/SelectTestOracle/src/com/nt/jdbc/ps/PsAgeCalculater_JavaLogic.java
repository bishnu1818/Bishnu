package com.nt.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;



public class PsAgeCalculater_JavaLogic {
	private static final String GET_DOB_BY_ID="SELECT DOB FROM CITIZEN_DETAILS WHERE CID=?";
	public static void main(String []args) {

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner sc=null;

		int no=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("ENTER CITIZEN NUMBER::");
				no=sc.nextInt();
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
			if(con!=null)
				ps=con.prepareStatement(GET_DOB_BY_ID);
			if(ps!=null)
				ps.setInt(1, no);
			if(ps!=null) 
				rs=ps.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					java.sql.Date sqdob=rs.getDate(1);
					long dobMs=sqdob.getTime();
					long sysDateMs=System.currentTimeMillis();
					float age=(sysDateMs-dobMs)/(1000.0f*60.0f*60.0f*24.0f*365.25f);
					System.out.println("PERSON AGE"+age);
				}
				else {
					System.out.println("PERSON NOT FOUND");

				}




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
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();












			}

		}

	}


}

	


