package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.RegistrationDetailsSaveToDatabase;
import model.RegistrationValidation;

import java.io.IOException;
import java.sql.SQLException;

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
	
	private String username;
	private String password;
	private String nickname;
	
	// Event Listener on Button[#registerBtn].onAction
	@FXML
	public void registerUser(ActionEvent event) throws IOException, Exception {
		// TODO Autogenerated
		boolean areFieldsEmpty = RegistrationValidation.isEmptyField(userNameTxtField.getText(), pwdTxtField.getText(), confPwdTxtField.getText(), nickNameField.getText());
		boolean arePwdConfPwdSame = RegistrationValidation.isPwdconfPwdSame(pwdTxtField.getText(), confPwdTxtField.getText());
		if(areFieldsEmpty) {
			AlertBoxClass.ErrBox("Missing Fields", "You left one ore more fields blank!");
		}
		else if(!arePwdConfPwdSame) {
			AlertBoxClass.ErrBox("Registration Error", "Please check your password fields properly!");
		}
		else {
			 username = userNameTxtField.getText();
			 password = pwdTxtField.getText();
			 nickname = nickNameField.getText();
			 
			int isSuccessful = RegistrationDetailsSaveToDatabase.saveToDatabase(username, password, nickname);
			
			if(isSuccessful>0) {
				System.out.println("Status: "+isSuccessful);
			}
			else {
				System.out.println("Status: "+isSuccessful);
			}
			AlertBoxClass.Notify("SUCCESS", "Welcome "+userNameTxtField.getText()+" You'll be directed to Login Page");
			Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPageFXML.fxml"));
			Stage stage = (Stage)rootRegisterPane.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
		}
	}

	// Event Listener on Button[#backToLoginBtn].onAction
	@FXML
	public void backToLoginPage(ActionEvent event) throws IOException {
		// TODO Autogenerated
		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPageFXML.fxml"));
		Stage stage = (Stage)rootRegisterPane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
}
