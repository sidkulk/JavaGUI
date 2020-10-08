package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

import java.io.IOException;
import java.sql.SQLException;

import AlertBoxesPack.AlertBoxClass;
import javafx.event.ActionEvent;

public class LoginPageFXMLController {
	@FXML
	private AnchorPane rootLoginPane;

	@FXML
	private Button loginBtn;

	@FXML
	private Button newUserBtn;

	@FXML
	private PasswordField passwordTxtField;

	@FXML
	private TextField userNameTxtField;

	@FXML
	private Button forgotPassBtn;

	@FXML
	private Button exitBtn;

	private static Integer userId;
	private static String userpwd;

	public void setValues() throws SQLException {
		userId = DatabaseOperations.getId(userNameTxtField.getText());
		userpwd = DatabaseOperations.getPwd(passwordTxtField.getText());
	}

	public static int getId() {
		return userId;
	}

	public static String getPwd() {
		return userpwd;
	}

	@FXML
	void LoginCredentialsVarification(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		boolean isValidCred = DatabaseOperations.checkLoginCred(userNameTxtField.getText(), passwordTxtField.getText());
		boolean isEmptyField = DatabaseOperations.checkEmptyField(userNameTxtField.getText(),
				passwordTxtField.getText());
		if (isEmptyField) {
			AlertBoxClass.ErrBox("Empty Field", "One or more fields are left empty!");
		} else if (!isValidCred) {
			AlertBoxClass.ErrBox("LOGIN ERROR", "Please enter correct login details!");
		} else {
			setValues();
			ScreenPackClass.showUserDashBoardPage(rootLoginPane);
		}
	}

	// Event Listener on Button[#newUserBtn].onAction
	@FXML
	public void RegistrationPage(ActionEvent event) throws Exception {
		ScreenPackClass.showRegistrationPage(rootLoginPane);
	}

	@FXML
	void exitApplication(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void forgotPassword(ActionEvent event) throws IOException {
		ScreenPackClass.showForgotPasswordPage(rootLoginPane);
	}
}
