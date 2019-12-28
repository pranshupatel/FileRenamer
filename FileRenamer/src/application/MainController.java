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
	private Button btnFile;
	@FXML
	private TextField txtNewName;
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ListView <String> lstPreview;
	
	@FXML
	public void BtnFileAction(ActionEvent action) {
		FileChooser fc = new FileChooser();
		
		Stage stage = (Stage)anchorpane.getScene().getWindow();
		this.files = fc.showOpenMultipleDialog(stage);
		for(int i = this.files.size() - 1; i >= 0; i--) {
			String filename = this.files.get(i).getName();
			this.lstPreview.getItems().add(filename);
		}
	}
	
	@FXML
	public void BtnRenameAction(ActionEvent action) {
		for (int i = this.files.size() - 1; i >= 0; i--) {
			this.files.get(i).renameTo(new File (this.files.get(i).getParent() + "\\"+ this.txtNewName.getText() + (files.size() - i) + ".txt"));
		}
	}
	
	@FXML
	public void btnPreviewAction(ActionEvent action) {
		for (int i = 0; i < this.lstPreview.getItems().size(); i++) {
		}
	}
}
