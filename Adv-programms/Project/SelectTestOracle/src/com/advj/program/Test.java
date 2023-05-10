package com.advj.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
	public static void main(String[] args) throws Exception{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:em","system","manager");
		PreparedStatement st=con.prepareStatement("SELECT COUNT (*) FROM student");
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getInt(1));
		}
	}
}
