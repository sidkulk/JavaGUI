package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.App;

public class RegistrationDetailsSaveToDatabase {
	static PreparedStatement ps;
	static ResultSet keys;
	public static int saveToDatabase(String uname, String pwd, String nickname) throws ClassNotFoundException, SQLException {
		int result = -1;
		try {
			String connectionURL = App.Constants.CONNECTION_URL;
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn =  DriverManager.getConnection(connectionURL);
			String raw = "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)";
			String query = String.format(raw, App.Constants.USER_TABLE_NAME, UserDataAccessOperation.Constants.USER_NAME, UserDataAccessOperation.Constants.USER_PWD, UserDataAccessOperation.Constants.USER_NICK);
			ps = SqlConnectionClass.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setString(3, nickname);
			int i = ps.executeUpdate();
			System.out.println("Query status: "+i);
			keys = ps.getGeneratedKeys();
			if(keys.next()) {
				result =  keys.getInt(1);
			}
			else {
				result =  -1;
			}
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				keys.close();
			}
			catch(Exception e) {
				
			}
		}
		return result;
	}
	
	public static boolean addNewPwd(String pwdTitle, String pwd, Integer userid) throws ClassNotFoundException, SQLException {
		int result = -1;
		try {
			String connectionURL = App.Constants.CONNECTION_URL;
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn =  DriverManager.getConnection(connectionURL);
			String raw = "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)";
			String query = String.format(raw, App.Constants.PASSWORD_TABLE_NAME, UserPasswordDataAccessOperation.Constants.PASS_TITLE, UserPasswordDataAccessOperation.Constants.PASS_NAME, UserPasswordDataAccessOperation.Constants.USER_ID);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setString(1, pwdTitle);
			ps.setString(2, pwd);
			ps.setInt(3, userid);
			result = ps.executeUpdate();
			
			System.out.println("Quary status: "+result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				ps.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(result>0) {
			return true;
		}
		else {
			return false;
		}
	}
}
