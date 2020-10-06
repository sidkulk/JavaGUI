package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.RegistrationDetailsSaveToDatabase;

import java.io.IOException;
import java.sql.SQLException;

import AlertBoxesPack.AlertBoxClass;
import javafx.event.ActionEvent;

public class AddNewEntryFXMLController {
	@FXML
	private TextField pwdTitle;
	@FXML
	private TextField pwdContent;
	@FXML
	private Button saveBtn;
	@FXML
	private Button backBtn;
	@FXML
    private AnchorPane rootAnchorPane;
	UserDashBoardFXMLController obj;
	// Event Listener on Button[#saveBtn].onAction
	@FXML
	public void savePasswordData(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		//obj = new LoginPageFXMLController();
		System.out.println(LoginPageFXMLController.getId()+" "+LoginPageFXMLController.getPwd());
		boolean isPasswordSaved = RegistrationDetailsSaveToDatabase.addNewPwd(pwdTitle.getText(), pwdContent.getText(), LoginPageFXMLController.getId());
		
		if(isPasswordSaved) {
			AlertBoxClass.Notify("SUCCESS", "Password entry Added!");
			Parent root = FXMLLoader.load(getClass().getResource("/view/UserDashBoardFXML.fxml"));
			Stage stage = (Stage)rootAnchorPane.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			//UserDashBoardFXMLController.updateTable();
		}
		else {
			AlertBoxClass.ErrBox("ERROR", "Oops! Something went wrong on our end!");
		}
	}
	// Event Listener on Button[#backBtn].onAction
	@FXML
	public void goBackToUserDash(ActionEvent event) {
		// TODO Autogenerated
		Stage stage = (Stage) backBtn.getScene().getWindow();
		stage.close();
	}
}
