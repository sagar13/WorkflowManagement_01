package utility;

import java.sql.*;
import java.util.ArrayList;

import model.WorkflowMaster;


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
	
	
	
	public static ResultSet dbExecuteQuery(String strQuery, String whereClause){
		
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet result = null;
		
		try{
			conn = new MySqlConnection().getConnection();
			query = conn.prepareStatement(strQuery+" "+whereClause);
			result = query.executeQuery();
			conn.close();
			return result;
		}catch(Exception ex){
			System.out.println("Exception caught:\n" + ex);
			return null;
		}
		
	}


	public static int insertObjectInDB(String insertQuery,ArrayList<String> params){
		int result;
		Connection conn=null;
		PreparedStatement pst = null;
		int i=1;

		try {
			conn= new MySqlConnection().getConnection();
			pst=conn.prepareStatement(insertQuery);
			for (String string : params) {
				pst.setString(i, string);
				i++;
			}
			
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result =0;
		}
		return result;
	}
}
