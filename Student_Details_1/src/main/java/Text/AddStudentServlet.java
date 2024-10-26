package Text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")

public class AddStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie []ck=req.getCookies();
		
		if(ck==null) {
			pw.println("===Details is Not Added===");
			RequestDispatcher rq=req.getRequestDispatcher("add.html");
			rq.include(req, res);
		}
		else {
			String avaliableString=ck[0].getValue();
			AddValues add=new AddValues();
			add.setName(req.getParameter("name"));
			add.setPass(req.getParameter("pass"));
			add.setId(Integer.parseInt(req.getParameter("id")));
			add.setDsc(req.getParameter("dsc"));
			add.setCompany(req.getParameter("company"));
			add.setPlace(req.getParameter("place"));
			int k=new InsertDao_Values().insert(add);
			pw.println("==Welcome To page=="+avaliableString);
			if(k>0) {
				pw.println("===Student_details is Added===");
			}
			RequestDispatcher rq=req.getRequestDispatcher("add.html");
			rq.include(req, res);
		}
		
	}
}
