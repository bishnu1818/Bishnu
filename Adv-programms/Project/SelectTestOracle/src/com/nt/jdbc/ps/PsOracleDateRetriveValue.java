package com.nt.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;


public class PsOracleDateRetriveValue {

	private static final String GET_DATE_VALUES="SELECT CID,CNAME,CADD,DOB,DOM,DOJ FROM CITIZEN_DETAILS";
	public static void main(String []args) {


		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;


		try {


			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
			if(con!=null)
				ps=con.prepareStatement(GET_DATE_VALUES);
			if(ps!=null)
				rs=ps.executeQuery();
			if(rs!=null) {

				while(rs.next()) {
					int cno=rs.getInt(1);
					String name=rs.getString(2);
					String addrs=rs.getString(3);
					java.sql.Date sqdob=rs.getDate(4);
					java.sql.Date sqdom=rs.getDate(5);
					java.sql.Date sqdoj=rs.getDate(6);
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					String sd1=sdf.format(sqdob);
					String sd2=sdf.format(sqdom);
					String sd3=sdf.format(sqdoj);
					System.out.println(cno+" "+name+" "+addrs+" "+sqdob+" "+sqdom+" "+sqdoj);
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
