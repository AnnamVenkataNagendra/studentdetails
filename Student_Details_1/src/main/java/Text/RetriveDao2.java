package Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class RetriveDao2 extends HttpServlet {
	
public BeanServlet bean=null;
	
	public BeanServlet retrive(HttpServletRequest req) 
	{
		
		try {
			Connection con=DbConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Student_Details_1 where name=?");
			ps.setString(1 ,req.getParameter("name"));
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				bean =new BeanServlet();
				bean.setName(rs.getString(1));
				bean.setPass(rs.getString(2));
				bean.setId(rs.getInt(3));
				bean.setDsc(rs.getString(4));
				bean.setCompany(rs.getString(5));
				bean.setPlace(rs.getString(6));
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bean;
		
	}
	

}
