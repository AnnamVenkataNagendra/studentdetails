package Text;

import java.sql.*;

public class InsertDao_Values {

  public  int k=0;
  
  public  int insert(AddValues add)
  
  {
	  try {
		  Connection con=DbConnection.getCon();
		  PreparedStatement ps=con.prepareStatement("insert into Student_Details_1 values(?,?,?,?,?,?)");
		  ps.setString(1, add.getName());
		  ps.setString(2, add.getPass());
		  ps.setInt(3, add.getId());
		  ps.setString(4, add.getDsc());
		  ps.setString(5, add.getCompany());
		  ps.setString(6, add.getPlace());
		  k=ps.executeUpdate();
	  }
	  catch (Exception e) {
		System.out.println(e.getMessage());
	}
	  
	return k;
	  
  }
	
}
