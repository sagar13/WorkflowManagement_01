package utility;

import java.sql.*;

public class DBService {
	
	public static String db_authenticate(String username, String password){
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		String returnString = "login_fail";
		
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement("select password, role from login_credentials where username = ? and active_flag = 1");
			query.setString(1, username);
			result = query.executeQuery();

			while(result.next()){

				if(password.equals(result.getString("password")))
					returnString = result.getString("role");
				else
					returnString = "login_fail";
			}
			conn.close();
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
		}
		return returnString;
	}
}
