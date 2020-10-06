package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import application.App;

public class UserDataAccessOperation {
	static Connection conn;
	public static void createUserTable() throws Exception {
		//String query = "CREATE TABLE IF NOT EXISTS User ( id INTEGER PRIMARY KEY AUTOINCREMENT, uname VARCHAR(50), password VARCHAR(50), nickname VARCHAR(50) );";
		String raw = "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(50), %s VARCHAR(50), %s VARCHAR(50) );";
		String query = String.format(raw, App.Constants.USER_TABLE_NAME, Constants.USER_ID, Constants.USER_NAME, Constants.USER_PWD, Constants.USER_NICK);
		String connectionURL = App.Constants.CONNECTION_URL;
		Class.forName(App.Constants.CLASS_FOR_NAME);
		conn =  DriverManager.getConnection(connectionURL);
		PreparedStatement ps =  conn.prepareStatement(query);
		boolean exe = ps.execute();
	}
	
	public static class Constants {
		public static final String USER_ID = "id";
		public static final String USER_NAME = "uname";
		public static final String USER_PWD = "password";
		public static final String USER_NICK = "nickname";
	}
}
