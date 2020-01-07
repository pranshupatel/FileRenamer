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

public class MainController{
	
	// Model and Views 
	private MainModel model = new MainModel();
	private PreviewView preview;
	
	// Displays/Controls
	@FXML
	private Button btnFile;
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private TextField txtRename;
	@FXML
	private GridPane gridPreview; 
	@FXML
	private Button btnPreview;
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnDone;
	
	
	@FXML
	public void BtnFileAction(ActionEvent action) {
		 /* 
		  * "Select File" button click action. Note: This method acts as the model and view initializer.
		  */              
		FileChooser fc = new FileChooser();
		Stage stage = (Stage)anchorpane.getScene().getWindow();
		java.util.List<File> files = fc.showOpenMultipleDialog(stage);
		
			if (files != null) {
				// View Initialization
				this.preview = new PreviewView(this.gridPreview);
				this.model.attach(this.preview); // Model View hookup
				this.model.extend(files);  // Initialize Model based on selected files
			}
		this.btnDone.setDisable(true);
	}
	
	@FXML
	public void BtnRenameAction(ActionEvent action) {
		/*
		 * "Rename All" button click action. Note: This method ACTUALLY renames the files.
		 */
		this.model.renameAll(this.preview);
	}
	
	@FXML
	public void BtnPreviewAction(ActionEvent action) {
		/*
		 * "Preview" button click action. Note: This method does NOT actually rename the files.
		 */
		if (!this.txtRename.getText().isEmpty()) {
			this.model.fakeRenameAll(this.txtRename.getText());
		}
	}

	@FXML
	public void BtnEditAction(ActionEvent action) {
		/*
		 * "Edit" button click action. Simply enables editing for all texfields with file name. 
		 */
		this.btnDone.setDisable(false);
		this.preview.enableEdit();
		this.btnEdit.setDisable(true);
	}
	
	@FXML
	public void BtnDoneAction (ActionEvent event) {
		/*
		 * "Done" button click action. Fake renames all file names and disables editing.
		 */
		this.model.fakeRenameSeperate(this.preview);
		this.preview.disableEdit();
		this.btnDone.setDisable(true);
		this.btnEdit.setDisable(false);
		
	}
	
}
