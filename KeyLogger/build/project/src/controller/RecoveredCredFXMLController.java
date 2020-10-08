package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

import java.io.IOException;

import javafx.event.ActionEvent;

public class RecoveredCredFXMLController {
	@FXML
	private TextField usernameTxtField;
	@FXML
	private TextField userPasswordTxtField;
	@FXML
	private Button backBtn;

	@FXML
	private AnchorPane rootRecoveryPane;

	// Event Listener on Button[#backBtn].onAction
	@FXML
	public void backToLoginPage(ActionEvent event) throws IOException {
		ScreenPackClass.showLoginPage(rootRecoveryPane);
	}

	@FXML
	void initialize() {
		usernameTxtField.setText(DatabaseOperations.username);
		userPasswordTxtField.setText(DatabaseOperations.password);
		usernameTxtField.setEditable(false);
		userPasswordTxtField.setEditable(false);
	}
}
