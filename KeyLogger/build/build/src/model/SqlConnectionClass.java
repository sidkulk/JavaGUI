package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import application.App;

public class SqlConnectionClass {
	static Connection conn;
	public static Connection sqlConnection() throws SQLException, ClassNotFoundException {
		Class.forName(App.Constants.CLASS_FOR_NAME);
		conn = DriverManager.getConnection(App.Constants.CONNECTION_URL);
		return conn;
	}
}
