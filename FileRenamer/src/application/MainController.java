package application;

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
	private MainModel model;
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
		if (fc.showOpenMultipleDialog(stage) != null) {
			
			this.model = new MainModel(fc.showOpenMultipleDialog(stage));  // Initialize Model based on selected files
			// View Initialization
			this.preview = new PreviewView(this.lstPreview);
			this.model.attach(this.preview); // Model View hookup
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
		this.model.fake_rename(this.txtRename.getText());
	}

	
}
