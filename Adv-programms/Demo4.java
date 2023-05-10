import java.sql.*;
public class  Test
{
	public static void main(String[] args) throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT COUNT(*) FROM EMP");
		int count=rs.getInt(1);
		System.out.println(count);
	}
}
