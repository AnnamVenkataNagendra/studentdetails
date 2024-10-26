package Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetrivingData {
	
	ArrayList<AddValues> array=new ArrayList<AddValues>();
	
	public ArrayList<AddValues> retriveing()
	{
		
		try {
			
			Connection con=DbConnection.getCon();
			PreparedStatement ps=
					con.prepareStatement("select * from student_Details_1");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				AddValues add=new AddValues();
				add.setName(rs.getString(1));
				add.setPass(rs.getString(2));
				add.setId(rs.getInt(3));
				add.setDsc(rs.getString(4));
				add.setCompany(rs.getString(5));
				add.setPlace(rs.getString(6));
				array.add(add);
			}
				
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return array;
		
	}

}
