package AlertBoxesPack;

import javafx.scene.control.Alert;

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
}
