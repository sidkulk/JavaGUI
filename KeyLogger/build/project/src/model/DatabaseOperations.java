package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseOperations {
	static PreparedStatement ps;
	static ResultSet rs;
	public static String username = "";
	public static String password = "";
	public static boolean checkLoginCred(String username, String pwd) throws SQLException, ClassNotFoundException {
		boolean result = false;
		try {
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn = DriverManager.getConnection(App.Constants.CONNECTION_URL);
			String raw = "SELECT %s, %s FROM %s WHERE %s = ? AND %s = ?";
			String query = String.format(raw, UserDataAccessOperation.Constants.USER_NAME, UserDataAccessOperation.Constants.USER_PWD, App.Constants.USER_TABLE_NAME, UserDataAccessOperation.Constants.USER_NAME, UserDataAccessOperation.Constants.USER_PWD);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
			else {
				result = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ps.close();
			rs.close();
		}
		
		return result;
	}
	
	public static boolean checkEmptyField(String username, String pwd) {
		if(username.isEmpty() || pwd.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int getId(String username) throws SQLException {
		int result = -1;
		try {
			String raw = "SELECT %s FROM %s WHERE %s = ?";
			String query = String.format(raw, UserDataAccessOperation.Constants.USER_ID, App.Constants.USER_TABLE_NAME, UserDataAccessOperation.Constants.USER_NAME);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				result =  rs.getInt(UserDataAccessOperation.Constants.USER_ID);
			}
			else {
				result = -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ps.close();
			rs.close();
		}
		
		return result;
	}
	
	public static String getPwd(String pwd) throws SQLException {
		String result = "";
		try {
			String raw = "SELECT %s FROM %s WHERE %s = ?";
			String query = String.format(raw, UserDataAccessOperation.Constants.USER_PWD, App.Constants.USER_TABLE_NAME, UserDataAccessOperation.Constants.USER_PWD);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setString(1, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString(UserDataAccessOperation.Constants.USER_PWD);
			}
			else {
				result = "NAN";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ps.close();
			rs.close();
		}
		return result;
	}
	
	public static ObservableList<Password> getPassDetails(Integer id){
		ObservableList<Password> list = FXCollections.observableArrayList();
		try {
			String raw = "SELECT %s, %s FROM %s WHERE %s = ?";
			String query = String.format(raw, UserPasswordDataAccessOperation.Constants.PASS_TITLE, UserPasswordDataAccessOperation.Constants.PASS_NAME, App.Constants.PASSWORD_TABLE_NAME, UserPasswordDataAccessOperation.Constants.USER_ID);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Password(rs.getString(UserPasswordDataAccessOperation.Constants.PASS_TITLE), rs.getString(UserPasswordDataAccessOperation.Constants.PASS_NAME)));
			}
		}catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static boolean removeFromDatabase(Integer id) {
		boolean res = false;
		try {
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn = DriverManager.getConnection(App.Constants.CONNECTION_URL);
			String raw = "DELETE FROM %s WHERE %s = ?;";
			String query = String.format(raw, App.Constants.PASSWORD_TABLE_NAME, UserPasswordDataAccessOperation.Constants.PASS_ID);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0) {
				res = true;
			}
			else {
				res = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public static boolean updatepassword(Integer id, String pwdTitle, String pwd) {
		boolean res = false;
		try {
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn = DriverManager.getConnection(App.Constants.CONNECTION_URL);
			String raw = "UPDATE %s SET %s = ?, %s = ? WHERE %s = ?;";
			String query = String.format(raw, App.Constants.PASSWORD_TABLE_NAME, UserPasswordDataAccessOperation.Constants.PASS_TITLE, UserPasswordDataAccessOperation.Constants.PASS_NAME, UserPasswordDataAccessOperation.Constants.PASS_ID);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setString(1, pwdTitle);
			ps.setString(2, pwd);
			ps.setInt(3, id);
			int i = ps.executeUpdate();
			if(i>0) {
				res = true;
			}
			else {
				res = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public static int saveToDatabase(String uname, String pwd, String nickname) throws ClassNotFoundException, SQLException {
		int result = -1;
		try {
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn = DriverManager.getConnection(App.Constants.CONNECTION_URL);
			String raw = "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)";
			String query = String.format(raw, App.Constants.USER_TABLE_NAME, UserDataAccessOperation.Constants.USER_NAME, UserDataAccessOperation.Constants.USER_PWD, UserDataAccessOperation.Constants.USER_NICK);
			ps = SqlConnectionClass.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setString(3, nickname);
			int i = ps.executeUpdate();
			System.out.println("Query status: "+i);
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				result =  rs.getInt(1);
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
				rs.close();
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
	
	public static boolean deleteUser(int id) {
		int res = -1;
		try {
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn = DriverManager.getConnection(App.Constants.CONNECTION_URL);
			String raw = "DELETE FROM %s WHERE %s = ?";
			String query = String.format(raw, App.Constants.USER_TABLE_NAME, UserDataAccessOperation.Constants.USER_ID);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setInt(1, id);
			res = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean accountRecovery(String nickname) {
		boolean res = false;
		try {
			Class.forName(App.Constants.CLASS_FOR_NAME);
			SqlConnectionClass.conn = DriverManager.getConnection(App.Constants.CONNECTION_URL);
			String raw = "SELECT %s, %s FROM %s WHERE %s = ?;";
			String query = String.format(raw, UserDataAccessOperation.Constants.USER_NAME, UserDataAccessOperation.Constants.USER_PWD, App.Constants.USER_TABLE_NAME, UserDataAccessOperation.Constants.USER_NICK);
			ps = SqlConnectionClass.conn.prepareStatement(query);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			if(rs.next()) {
				res = true;
				username = rs.getString(1);
				password = rs.getString(2);
			}
			else {
				res = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
