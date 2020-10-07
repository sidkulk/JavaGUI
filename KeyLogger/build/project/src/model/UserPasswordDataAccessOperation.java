package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import application.App;

public class UserPasswordDataAccessOperation {
	
	
	public static void createPasswordTab() throws Exception {
		/*String query = "CREATE TABLE IF NOT EXISTS passwordtab ( id INTEGER PRIMARY KEY AUTOINCREMENT, pwdtitle VARCHAR(100), pwd VARCHAR(100), user_id INTEGER, FOREIGN KEY (user_id) REFERENCES User(id));";*/
		String raw = "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(100), %s VARCHAR(100), %s INTEGER NOT NULL, FOREIGN KEY (%s) REFERENCES User(%s) ON DELETE CASCADE);";
		String query = String.format(raw, App.Constants.PASSWORD_TABLE_NAME, Constants.PASS_ID, Constants.PASS_TITLE, Constants.PASS_NAME, Constants.USER_ID, Constants.USER_ID, Constants.FOREIGN_KEY);
		String connectionURL = App.Constants.CONNECTION_URL;
		Class.forName(App.Constants.CLASS_FOR_NAME);
		Connection conn =  DriverManager.getConnection(connectionURL);
		PreparedStatement ps =  conn.prepareStatement(query);
		ps.execute();
	}
	
	public static class Constants {
		public static final String PASS_ID = "id";
		public static final String PASS_TITLE = "pwdtitle";
		public static final String PASS_NAME = "pwd";
		public static final String USER_ID = "user_id";
		public static final String FOREIGN_KEY = "id";
	}
}
