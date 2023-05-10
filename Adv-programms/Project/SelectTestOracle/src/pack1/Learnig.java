package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Learnig {
public static void main(String[] args)throws Exception {
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","maneger123");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("SELECT*FROM emp");
	while(rs.next()!=false) {
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"  "+rs.getFloat(4));
		
	}
	rs.close();
	st.close();
	con.close();
	
}

}
