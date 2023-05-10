package com.nt.jdbc.ps;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class BLOBRetrieveTest {
	private static final String BLOB_RETRIEVE_QUERY="SELECT * FROM JDBC_CRICKETER_DETAILS WHERE CNO=?";

	public static void main(String []args) {

		int cno=0;
	//	String cname=null;
	//	String caddr=null;
	//	String photo=null;

		try {
			Scanner sc=new Scanner(System.in);
			if(sc!=null)
				System.out.println("ENTER CRICKETER NUMBER::");
			cno=sc.nextInt();

			try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
					PreparedStatement ps=con.prepareStatement( BLOB_RETRIEVE_QUERY);
					){
				if(ps!=null)
					ps.setInt(1, cno);
				try(ResultSet rs=ps.executeQuery()){
					if(rs!=null) {
						if(rs.next()) {
							try(	InputStream is=rs.getBinaryStream(4);
									OutputStream os=new FileOutputStream("RETRIEVE PHOTO_JPG");

									){
								System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
								IOUtils.copy(is,os);
							}
						}
					}
						else {
							System.out.println("RECORD NOT FOUND PLEASE INSERT THE RECORD");
							return;
						}
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


