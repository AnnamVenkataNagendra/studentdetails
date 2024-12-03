package Text;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/update")
@SuppressWarnings("serial")
public class DisplayUpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int k=new UpdateValues().updatevalues(req);
		if(k>0) {
			pw.println("===Student Updates Successfully===<br>");
		}
		RequestDispatcher re=req.getRequestDispatcher("link.html");
		re.include(req, res);
		
	}
	
}
