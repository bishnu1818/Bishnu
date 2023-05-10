package com.nt.jdbc.rs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveRSUpdateOperation {
	private static final String GET_STUDENT_QUERY="SELECT NO,NAME,ADDR,AVG FROM STUDENT";
	public static void main(String[] args) throws InterruptedException {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
				Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery(GET_STUDENT_QUERY);
				
				){
			
			if(rs!=null) {
				
				while(rs.next()) {
					
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
					rs.absolute(1);
					rs.updateFloat(1,98.50f);
                    rs.updateRow();				
				}
			}
		}
			catch(SQLException se) {
				se.printStackTrace();
			}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}


}





