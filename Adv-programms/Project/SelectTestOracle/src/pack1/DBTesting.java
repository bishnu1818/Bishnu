package pack1;
import java.sql.*;
import java.util.*;

public class DBTesting {
	public static void main(String []args)throws Exception {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter initial character of employee name::");
	   String initChars=sc.next();
	   initChars="'"+initChars+"%'";
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
	   Statement st=con.createStatement();
	   String query="SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE ENAME LIKE"+initChars;
	   System.out.println(query);
	   ResultSet rs=st.executeQuery(query);
	   boolean b=false;
	   while(rs.next()!=false) {
		   b=true;
		   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getFloat(3)+"  "+rs.getString(4));
	   }
	   if (b==false)
		   System.out.println("record not found");
	   rs.close();
	   st.close();
	   con.close();
	   }
	
}
	   
	   
	


