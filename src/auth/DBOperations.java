package auth;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperations {


		MyConnection db = new MyConnection();
//		Statement st;
		PreparedStatement ps;

		public void SignUp(int id, String userName, String pass) {

			try {
				ps = db.getPreparedStatement("insert into login values(?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, userName);
				ps.setString(3, pass);
				ps.execute();

				db.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
}
