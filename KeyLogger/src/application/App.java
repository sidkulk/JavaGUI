package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.UserDataAccessOperation;
import model.UserPasswordDataAccessOperation;
import screenPack.ScreenPackClass;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		createAllTables();
		ScreenPackClass.showLoginPage();
	}

	private void createAllTables() throws Exception {
		UserDataAccessOperation.createUserTable();
		UserPasswordDataAccessOperation.createPasswordTab();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static class Constants {
		public static final String USER_TABLE_NAME = "User";
		public static final String PASSWORD_TABLE_NAME = "passwordtab";
		public static final String CONNECTION_URL = "jdbc:sqlite:user.db";
		public static final String CLASS_FOR_NAME = "org.sqlite.JDBC";
	}
}