package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.UserDataAccessOperation;
import model.UserPasswordDataAccessOperation;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		createAllTables();
		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPageFXML.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Key Logger");
		stage.setScene(scene);
		stage.show();

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

