package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/** MainController class. Stores all controls (ex. buttons, labels, textfields, etc) and the 
 * Action methods (ex. button clicked).
 **/

public class MainController {
	
	// Model and Views 
	private MainModel model = new MainModel();
	private PreviewView preview;
	
	// Displays/Controls
	@FXML
	private Button btnFile;
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ListView <String >lstPreview; 
	@FXML
	private TextField txtRename;
	@FXML
	private Button btnPreview;
	
	@FXML
	public void BtnFileAction(ActionEvent action) {
		 /* 
		  * "Select File" button click action. Note: This method acts as the model and view initializer.
		  */
		FileChooser fc = new FileChooser();
		Stage stage = (Stage)anchorpane.getScene().getWindow();
		java.util.List<File> files = fc.showOpenMultipleDialog(stage);
		
			if (files != null) {
				this.model.extend(files);  // Initialize Model based on selected files
				// View Initialization
				this.preview = new PreviewView(this.lstPreview);
				this.model.attach(this.preview); // Model View hookup
				this.model.notifyObservers();
			}
	}
	
	@FXML
	public void BtnRenameAction(ActionEvent action) {
		/*
		 * "Rename All" button click action. Note: This method ACTUALLY renames the files.
		 */
		this.model.rename(this.txtRename.getText());
	}
	
	@FXML
	public void TxtAutoRename(ActionEvent action) {
		/*
		 * "Preview" button click action. Note: This method does NOT actually rename the files.
		 */
		if (!this.txtRename.getText().isEmpty()) {
			this.model.fake_rename(this.txtRename.getText());
		}
	}

	
}
