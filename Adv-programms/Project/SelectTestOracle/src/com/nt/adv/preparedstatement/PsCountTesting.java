package com.nt.adv.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class PsCountTesting {
	private static final String EMP_COUNT_QUERY="SELECT COUNT (*) FROM EMP";
	public static void main(String []args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");


			if(con!=null)
				ps=con.prepareStatement(EMP_COUNT_QUERY);
			if (ps!=null)
				rs=ps.executeQuery();
			if(rs!=null)
				rs.next();
			System.out.println("COUNT OF RECORD::"+rs.getInt("COUNT(*)"));

		
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
			if (rs != null)
				rs.close();
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
  









