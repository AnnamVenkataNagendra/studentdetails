package Text;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class Display_Servlet extends  HttpServlet {
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException 
	{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		BeanServlet bean=new Request_Beean().retrive(req);
		
		if(bean==null) {
			
			pw.println("===Session has been Expired====");
			RequestDispatcher rq=req.getRequestDispatcher("login.html");
			rq.include(req, res);
		}
		else {
			Cookie ck=new Cookie("getName",bean.getName());
			res.addCookie(ck);
			pw.println("==Welcome To Page=="+bean.getName());
			RequestDispatcher rq=req.getRequestDispatcher("login.html");
			rq.include(req, res);
		}
	}
}
