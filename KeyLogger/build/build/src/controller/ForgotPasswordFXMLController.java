package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

import java.io.IOException;

import AlertBoxesPack.AlertBoxClass;
import javafx.event.ActionEvent;

public class ForgotPasswordFXMLController {
	@FXML
	private TextField nickNameTxtField;
	@FXML
	private Button findMeBtn;

	@FXML
	private AnchorPane rootPassRecovPane;
	
	@FXML
    private Button backBtn;

	// Event Listener on Button[#findMeBtn].onAction
	@FXML
	public void findAccDetails(ActionEvent event) throws IOException {
		if(nickNameTxtField.getText().isEmpty()) {
			AlertBoxClass.Amber("CAUTION", "You left the recovery field empty!");
		}
		else {
			boolean accountFound = DatabaseOperations.accountRecovery(nickNameTxtField.getText());
			if (!accountFound) {
				AlertBoxClass.ErrBox("USER NOT FOUND",
						"We failed to retrive your account details. You'll be redirected to login page.");
				ScreenPackClass.showLoginPage(rootPassRecovPane);
			}
			else {
				ScreenPackClass.showRecoveredDetails(rootPassRecovPane);
			}
		}
	}
	
	@FXML
    void backToLogin(ActionEvent event) throws IOException {
		ScreenPackClass.showLoginPage(rootPassRecovPane);
    }
}
