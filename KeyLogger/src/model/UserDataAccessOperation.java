package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import application.App;

public class UserDataAccessOperation {
	static Connection conn;

	public static void createUserTable() throws Exception {
		String raw = "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(50) NOT NULL UNIQUE, %s VARCHAR(50) NOT NULL, %s VARCHAR(50), %s VARCHAR(50));";
		String query = String.format(raw, App.Constants.USER_TABLE_NAME, Constants.USER_ID, Constants.USER_NAME,
				Constants.USER_PWD, Constants.USER_NICK, Constants.USER_CHCILDHOOD_FRND);
		String connectionURL = App.Constants.CONNECTION_URL;
		Class.forName(App.Constants.CLASS_FOR_NAME);
		conn = DriverManager.getConnection(connectionURL);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.execute();
	}

	public static class Constants {
		public static final String USER_ID = "id";
		public static final String USER_NAME = "uname";
		public static final String USER_PWD = "password";
		public static final String USER_NICK = "nickname";
		public static final String USER_CHCILDHOOD_FRND = "childhoodFrnd";
	}
}
