package Text;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Spliterator;

import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		ArrayList<AddValues>array=new RetrivingData().retriveing();
		
		if(array.size()==0) {
			pw.println("===Details Is Not In The Box===");
		}
		else {
			Spliterator<AddValues> sp=array.spliterator();
			
			sp.forEachRemaining((k)->{
				
				AddValues ad=(AddValues)k;
				pw.println(ad.getName()+" "+ad.getPass()
				+" "+ad.getId()+" "+ad.getDsc()+" "+ad.getCompany()+" "+ad.getPlace());
			});
		}
		RequestDispatcher rq=req.getRequestDispatcher("link.html");
		rq.include(req, resp);
		
	}

}
