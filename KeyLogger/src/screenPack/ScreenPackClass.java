package screenPack;

import java.io.IOException;

import application.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ScreenPackClass {
	public static void showLoginPage(AnchorPane rootpane) throws IOException {
		Parent root = FXMLLoader.load(App.class.getResource("/view/LoginPageFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setTitle("Key Logger");
		stage.setScene(scene);
		stage.show();
	}

	public static void showLoginPage() throws IOException {
		Parent root = FXMLLoader.load(App.class.getResource("/view/LoginPageFXML.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.getIcons().add(new Image("file:key.png"));
		stage.setResizable(false);
		stage.setTitle("Key Logger");
		stage.setScene(scene);
		stage.show();
	}

	public static void showUpdateEntryPage(AnchorPane rootpane) throws IOException {
		Parent root = FXMLLoader.load(App.class.getResource("/view/UpdateEntryFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void showAddNewEntryPage(AnchorPane rootpane) throws IOException {
		Parent root = FXMLLoader.load(App.class.getResource("/view/AddNewEntryFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void showUserDashBoardPage(AnchorPane rootpane) throws IOException {
		Parent root = FXMLLoader.load(App.class.getResource("/view/UserDashBoardFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void showRegistrationPage(AnchorPane rootpane) throws IOException{
		Parent root = FXMLLoader.load(App.class.getResource("/view/RegisterPageFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void showConfirmationWindow(AnchorPane rootpane) throws IOException {
		Parent root = FXMLLoader.load(App.class.getResource("/view/DeleteUserAccConfBoxFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}
