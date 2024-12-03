package Text;

import java.sql.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class UpdateValues  extends HttpServlet{
	
	public int k=0;
	
	public int updatevalues(HttpServletRequest req)
	{
		
		try {
			
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update Student_Details_1 set password=?, id=?, dsc=?, company=?, place=? where name=? ");
			ps.setString(2,req.getParameter("pass"));
			ps.setString(3,req.getParameter("id"));
			ps.setString(4,req.getParameter("dsc"));
			ps.setString(5,req.getParameter("company"));
			ps.setString(6,req.getParameter("place"));
			k=ps.executeUpdate();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return k;
		
		
	}
	

}
