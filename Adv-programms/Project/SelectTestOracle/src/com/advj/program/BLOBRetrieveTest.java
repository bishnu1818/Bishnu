
package com.nt.jdbc.ps;

import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BLOBRetrieveTest {
	private static final String BLOB_RETRIEVE_QUERY="SELECT * FROM JDBC_CRICKETER_DETAILS WHERE CNO=?";
	
	public static void main(String []args) {
		
		int cno=0;
		String cname=null;
		String caddr=null;
		String photo=null;
		
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
				try(ResultSet rs=ps.executeQuery()){\
					if(rs!null) {
						if(rs.next()) {
							InputStream is=rs.getBinarytStream(4);
							System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
							
							OutputStream os=new FileOutputStream("RETRIEVE PHOTO_JPG");
							IOUtils.copy(is,os);
						}
					}
				}
			}
					
			
		}
	}

}
