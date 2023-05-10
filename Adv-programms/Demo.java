import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
@WebServlet("/welcome")
public class Demo extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		PrintWriter writer=resp.getWriter();
		writer.println("Welcome to Servlet");
	}

}