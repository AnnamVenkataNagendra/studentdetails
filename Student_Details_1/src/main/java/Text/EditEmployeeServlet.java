package Text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/edit")
@SuppressWarnings("serial")
public class EditEmployeeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		BeanServlet re=new RetriveDao2().retrive(req);
		
		if(re==null) {
			pw.print("===Invalied user Id:===");
			RequestDispatcher t=req.getRequestDispatcher("update.html");
			t.include(req, resp);
		}
		else {
			pw.println("<form action='update' method='post'>");
			pw.println("<input type='hidden' name='pass' value='"+re.getPass()+"'>");
			pw.println("<input type='hidden' name='id' value='"+re.getId()+"'>");
			pw.println("<input type='hidden' name='dsc' value='"+re.getDsc()+"'>");
			pw.println("<input type='hidden' name='company' value='"+re.getCompany()+"'>");
			pw.println("<input type='hidden' name='place' value='"+re.getPlace()+"'>");
			pw.println("<input type='submit' value='UpdateEmployee'>");
			pw.println("</form>");
			
		}
		
		
	}


}
