package auth;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchLog {
	
	MyConnection con = new MyConnection();
	
	PreparedStatement pt;
	
	public boolean login(String user,String pass)
	{	
		
		try {
			pt = con.getPreparedStatement("select * from login where username = ? AND password = ?");
			
			pt.setString(1, user);
			pt.setString(2, pass);
			
			ResultSet rs = pt.executeQuery();
			Integer id = null;
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				id = rs.getInt(1);
			}
			
			
			if(id!=null)
				return true;

		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println("wrong Sql");
		}
		
		return false;
	}

}
