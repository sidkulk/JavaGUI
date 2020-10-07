package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DatabaseOperations;
import model.Password;
import model.UserPasswordDataAccessOperation;
import screenPack.ScreenPackClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import AlertBoxesPack.AlertBoxClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class UserDashBoardFXMLController {
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Password, String> passwordIdColumn;
    
    Alert alert;
    
	@FXML
    private AnchorPane rootUserDashAnchor;
	@FXML
	private TableView<Password> userTableView;

	@FXML
	private Button addPasswordBtn;

	@FXML
	private Button removePasswordBtn;

	@FXML
	private Button signoutBtn;
	public static String pwdTitle;
	public static String pwd;
	public static Integer pId;
	
	@FXML
    private Button deleteMyAccBtn;
	
	@FXML
	private TableColumn<Password, String> nameOfPassword;

	@FXML
	private TableColumn<Password, String> passwordColums;
	
	@FXML
    private Button updatePasswordBtn;
	
	ObservableList<Password> passList;
		// Event Listener on Button[#addPasswordBtn].onAction
	@FXML
	public void AddNewPassword(ActionEvent event) throws IOException {
		ScreenPackClass.showAddNewEntryPage(rootUserDashAnchor);
	}

	// Event Listener on Button[#removePasswordBtn].onAction
	@FXML
	public void RemovePassword(ActionEvent event) {
		Password pass = userTableView.getSelectionModel().getSelectedItem();
		boolean removedFromDb = DatabaseOperations.removeFromDatabase(pass.getId());
		userTableView.getItems().removeAll(userTableView.getSelectionModel().getSelectedItem());
		if(removedFromDb) {
			AlertBoxClass.Notify("SUCCESS", "Password entry removed!");
		}
		else {
			AlertBoxClass.ErrBox("ERROR", "Oops! Something went wrong on our end!");
		}
	}

	// Event Listener on Button[#signoutBtn].onAction
	@FXML
	public void SignOut(ActionEvent event) throws IOException {
		AlertBoxClass.Notify("SIGNOUT", "Successfully SIGNED OUT. You'll be directed to login page!");
		ScreenPackClass.showLoginPage(rootUserDashAnchor);
	}
	
	@FXML
    void UpdatePassword(ActionEvent event) throws IOException {
		pwdTitle = userTableView.getSelectionModel().getSelectedItem().getPwdtitle();
		pwd = userTableView.getSelectionModel().getSelectedItem().getPwd();
		pId = userTableView.getSelectionModel().getSelectedItem().getId();
		ScreenPackClass.showUpdateEntryPage(rootUserDashAnchor);
    }
	
	@FXML
    void deleteAccount(ActionEvent event) throws IOException {
		Stage stage = (Stage) rootUserDashAnchor.getScene().getWindow();
		stage.close();
		AlertBoxClass.UserDeleteConfirmation(rootUserDashAnchor);
	}
	
	@FXML
    void initialize() {
		passwordIdColumn.setCellValueFactory(new PropertyValueFactory<Password, String>(UserPasswordDataAccessOperation.Constants.PASS_ID));
		nameOfPassword.setCellValueFactory(new PropertyValueFactory<Password, String>(UserPasswordDataAccessOperation.Constants.PASS_TITLE));
        passwordColums.setCellValueFactory(new PropertyValueFactory<Password, String>(UserPasswordDataAccessOperation.Constants.PASS_NAME));
        passList = DatabaseOperations.getPassDetails(LoginPageFXMLController.getId());
        userTableView.setEditable(true);
        userTableView.setItems(passList);
    }
	
}
