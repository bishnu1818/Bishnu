package com.nt.jdbc.rs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveUpdateOperationRS {
	private static final String GET_STUDENT_QUERY="SELECT NO,NAME,ADDR,AVG FROM STUDENT";
	public static void main(String[] args) throws InterruptedException {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
				Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery(GET_STUDENT_QUERY);
				
				){
			
			if(rs!=null) {
				
				while(rs.next()) {
					
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					System.out.println("------------------");
					rs.moveToInsertRow();
					rs.updateInt(1,109);
					rs.updateString(2, "joti");
					rs.updateString(3,"delhi");
		            rs.updateFloat(4,90.68f);
		            rs.insertRow();
		            System.out.println("RECORD INSERTED");
					
				
				}
			}
		}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
	}





