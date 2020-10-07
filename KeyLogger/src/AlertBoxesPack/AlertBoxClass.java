package AlertBoxesPack;

import java.io.IOException;
import java.util.Optional;

import controller.LoginPageFXMLController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

public class AlertBoxClass {
	
	public static void ErrBox(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText("ERROR");
		alert.setContentText(msg);
		alert.showAndWait();
	}

	public static void Notify(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText("NOTIFY");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public static void Amber(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText("WARNING");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public static void UserDeleteConfirmation(AnchorPane rootpane) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Delete User");
	    alert.setHeaderText("Are you sure you want to delete your account?");
	    alert.setContentText("DELETE ACCOUNT");
	    
	    Optional<ButtonType> option = alert.showAndWait();
	    if(option.get() == ButtonType.OK) {
	    	boolean isdeleted = DatabaseOperations.deleteUser(LoginPageFXMLController.getId());
	    	if(isdeleted) {
	    		AlertBoxClass.Notify("ACCOUNT DELETED", "You account has been removed, you'll be redirected to login page.");
	    		ScreenPackClass.showLoginPage();
	    	}
	    	else {
	    		AlertBoxClass.ErrBox("ERROR", "Failed to delete your account! Contact your software vendor!");
	    	}
	    }
	    else if(option.get() == ButtonType.CANCEL) {
	    	ScreenPackClass.showUserDashBoardPage(rootpane);
	    }
	}
}
