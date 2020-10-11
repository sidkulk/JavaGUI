package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import model.RegistrationValidation;
import screenPack.ScreenPackClass;

import java.io.IOException;
import AlertBoxesPack.AlertBoxClass;
import javafx.event.ActionEvent;

public class RegisterPageFXMLController {
	@FXML
	private TextField userNameTxtField;
	@FXML
	private PasswordField pwdTxtField;

	@FXML
	private PasswordField confPwdTxtField;
	@FXML
	private TextField nickNameField;
	@FXML
	private Button registerBtn;
	@FXML
	private Button backToLoginBtn;
	@FXML
	private AnchorPane rootRegisterPane;
	@FXML
	private TextField childhoodFrndName;

	private String username;
	private String password;
	private String nickname;
	private String childhoodFrnd;

	// Event Listener on Button[#registerBtn].onAction
	@FXML
	public void registerUser(ActionEvent event) throws IOException, Exception {
		boolean areFieldsEmpty = RegistrationValidation.isEmptyField(userNameTxtField.getText(), pwdTxtField.getText(),
				confPwdTxtField.getText(), nickNameField.getText(), childhoodFrndName.getText());
		boolean arePwdConfPwdSame = RegistrationValidation.isPwdconfPwdSame(pwdTxtField.getText(),
				confPwdTxtField.getText());

		if (areFieldsEmpty) {
			AlertBoxClass.ErrBox("Missing Fields", "You left one ore more fields blank!");
		} else if (!arePwdConfPwdSame) {
			AlertBoxClass.ErrBox("Registration Error", "Please check your password fields properly!");
		} else {
			username = userNameTxtField.getText().trim();
			password = pwdTxtField.getText().trim();
			nickname = nickNameField.getText().trim();
			childhoodFrnd = childhoodFrndName.getText().toLowerCase().trim();

			int isSuccessful = DatabaseOperations.saveToDatabase(username.trim(), password.trim(), nickname.trim(),
					childhoodFrnd.toLowerCase().trim());

			if (isSuccessful > 0) {
				System.out.println("Success Status: " + isSuccessful);
				AlertBoxClass.Notify("SUCCESS", "Welcome " + username + " You'll be now directed to login page");
				ScreenPackClass.showLoginPage(rootRegisterPane);
			} else {
				System.out.println("Failure Status: " + isSuccessful);
			}
		}
	}

	@FXML
	public void backToLoginPage(ActionEvent event) throws IOException {
		ScreenPackClass.showLoginPage(rootRegisterPane);
	}
}
