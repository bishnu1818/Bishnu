import java.sql.*;
class ConnTest 
{
	public static void main(String[] args)throws Exception 
	{
		oracle.jdbc.driver.OracleDriver driver= new oracle.jdbc.driver.OracleDriver();
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
		if(con==null)
		System.out.println("connection is not established");
		else
			System.out.println("connection is established");
	}
}
