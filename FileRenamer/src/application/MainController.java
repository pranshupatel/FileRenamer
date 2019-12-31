package application;
import util.Observer;

import java.awt.event.ActionListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {
	
	private MainModel model;
	@FXML
	private Button btnFile;
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ListView <String >lstPreview;
	private PreviewView preview; 
	@FXML
	private TextField txtRename;
	@FXML
	private Button btnPreview;
	
	@FXML
	public void BtnFileAction(ActionEvent action) {
		FileChooser fc = new FileChooser();
		Stage stage = (Stage)anchorpane.getScene().getWindow();
		this.model = new MainModel(fc.showOpenMultipleDialog(stage));
		this.preview = new PreviewView(this.lstPreview);
		this.model.attach((Observer)this.preview);
	}
	
	@FXML
	public void BtnRenameAction(ActionEvent action) {
		this.model.rename(this.txtRename.getText());
	}
	
	@FXML
	public void TxtAutoRename(ActionEvent action) {
		this.model.fake_rename(this.txtRename.getText());
	}

	
}
