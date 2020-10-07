package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

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
	@FXML
	public void savePasswordData(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		System.out.println(LoginPageFXMLController.getId()+" "+LoginPageFXMLController.getPwd());
		if(pwdTitle.getText().isEmpty() || pwdContent.getText().isEmpty()) {
			AlertBoxClass.Amber("EMPTY FIELD", "You left some fields empty!");
		}
		else {
			boolean isPasswordSaved = DatabaseOperations.addNewPwd(pwdTitle.getText(), pwdContent.getText(), LoginPageFXMLController.getId());
			
			if(isPasswordSaved) {
				AlertBoxClass.Notify("SUCCESS", "Password entry Added!");
				ScreenPackClass.showUserDashBoardPage(rootAnchorPane);
			}
			else {
				AlertBoxClass.ErrBox("ERROR", "Oops! Something went wrong on our end!");
			}
		}
	}
	@FXML
	public void goBackToUserDash(ActionEvent event) throws IOException {
		ScreenPackClass.showUserDashBoardPage(rootAnchorPane);
	}
}
