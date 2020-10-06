package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import AlertBoxesPack.AlertBoxClass;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DatabaseOperations;

public class UpdateEntryFXMLController {
	@FXML
	private AnchorPane rootUpdatePane;
	@FXML
	private TextField passwdTitleTxtField;
	@FXML
	private TextField updatedPasswordTxtField;
	@FXML
	private Button updateBtn;
	@FXML
	private Button abortBtn;

	// Event Listener on Button[#updateBtn].onAction
	@FXML
	public void updateDatabase(ActionEvent event) throws IOException {
		String pwdTitle = passwdTitleTxtField.getText();
		String pwd = updatedPasswordTxtField.getText();
		boolean isPasswordupdated = DatabaseOperations.updatepassword(UserDashBoardFXMLController.pId, pwdTitle, pwd);
		
		if(isPasswordupdated) {
			AlertBoxClass.Notify("SUCCESS", "Password entry UPDATED!");
			Parent root = FXMLLoader.load(getClass().getResource("/view/UserDashBoardFXML.fxml"));
			Stage stage = (Stage)rootUpdatePane.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
		}
		else {
			AlertBoxClass.ErrBox("ERROR", "Oops! Something went wrong on our end!");
		}
	}
	// Event Listener on Button[#abortBtn].onAction
	@FXML
	public void abortAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/UserDashBoardFXML.fxml"));
		Stage stage = (Stage)rootUpdatePane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
	@FXML
	public void initialize() {
		passwdTitleTxtField.setText(UserDashBoardFXMLController.pwdTitle);
		updatedPasswordTxtField.setText(UserDashBoardFXMLController.pwd);
	}
}
