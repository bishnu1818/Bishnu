package com.nt.adv.preparedstatement;

import java.sql.DriverManager;
import java.util.Scanner;
//import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class psInsertTesting {
	private static final String INSERT_STUDENT_QUERY = "INSERT INTO STUDENT VALUES(?,?,?,?)";

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			sc = new Scanner(System.in);

			int count = 0;
			if (sc != null)
				System.out.println("ENTER STUDENT COUNT::");
			count = sc.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager123");

			if (con != null)
				ps = con.prepareStatement(INSERT_STUDENT_QUERY);
			for (int i = 1; i <= count; i++) {
				System.out.println("ENTER" + i + " STUDET DETAILS");
				System.out.println("ENTER NUMBER::");
				int no = sc.nextInt();
				System.out.println("ENTER NAME::");
				String Name = sc.next();
				System.out.println("ENTR ADDR");
				String addr = sc.next();
				System.out.println("ENTE AVG");
				float avg = sc.nextFloat();

				ps.setInt(1, no);
				ps.setString(2, Name);
				ps.setString(3, addr);
				ps.setFloat(4, avg);

				int result = ps.executeUpdate();
				if (result == 0)
					System.out.println(i + "STUSENT RECORD NOT INSERTED");
				else
					System.out.println(i + "STUDENT RECORD INSERTED");

			}
		} 
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
