package application;
import java.io.*;
import java.util.List;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.fxml.*;

public class MainController {
	
	private List <File> files;
	
	@FXML
	private Label lblMessage;
	@FXML
	private Button btnFile;
	
	@FXML
	private TextField txtNewName;
	
	@FXML
	private AnchorPane anchorpane;
	
	@FXML
	public void BtnFileAction(ActionEvent action) {
		FileChooser fc = new FileChooser();
		
		Stage stage = (Stage)anchorpane.getScene().getWindow();
		this.files = fc.showOpenMultipleDialog(stage);
	}
	
	@FXML
	public void BtnRenameAction(ActionEvent action) {
		for (int i = this.files.size() - 1; i >= 0; i--) {
			this.files.get(i).renameTo(new File (this.files.get(i).getParent() + "\\"+ this.txtNewName.getText() + (files.size() - i) + ".pdf"));
		}
		this.lblMessage.setText("Renamed!");
	}
}
