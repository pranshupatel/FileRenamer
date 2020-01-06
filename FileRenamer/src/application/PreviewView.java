package application;
import util.Observable;
import util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class PreviewView implements Observer { 
	/**
	 * PreviewView class. This class is responsible for all relevant updates to the 
	 * "Preview" ListView display control which stores all the potential names of the files.
	 */
	
	@FXML
	private GridPane gridPreview;
	
	
	public PreviewView(GridPane gridPreview) {
		this.gridPreview = gridPreview;
		for (int i  = 0; i < gridPreview.getChildren().size() / 2; i++) {
			TextField txtName = (TextField) this.gridPreview.getChildren().get(i);
			txtName.setEditable(false);
		}
	}
	@Override
	public void update(Observable o) {
		/*
		 * Updates the Preview GridPane
		 */
		MainModel model = (MainModel)o;
		int start = gridPreview.getChildren().size() / 2;                           // Starts at first label (right hand side column)
		int end = model.getFiles().size() + gridPreview.getChildren().size() / 2;  // Last non empty label index
		
		// Set the real file names
		for (int i = start; i < end ; i++) {
			Label lblRealName = (Label) this.gridPreview.getChildren().get(i);
			lblRealName.setText(model.getFiles().get(i-start).getName());
		}
		
		// Set the "new" selected file names.
		for (int i = 0; i < model.getNames().size(); i++) {
			TextField txtName = (TextField) this.gridPreview.getChildren().get(i);
			txtName.setText(model.getNames().get(i));
		}
	}
	
	public void enableEdit() {
		/*
		 * Enables name editing for selected files
		 */
		
		for (int i = 0; i < this.gridPreview.getChildren().size() / 2; i++) {
			TextField txtName = (TextField) this.gridPreview.getChildren().get(i);
			if (txtName.getText().isEmpty()) {
				break;
			}
			else {
				txtName.setEditable(true);
			}
		}
	}
	
	public void disableEdit() {
		/*
		 * Disables name editing for selected files
		 */
		
		for (int i = 0; i < this.gridPreview.getChildren().size() / 2; i++) {
			TextField txtName = (TextField) this.gridPreview.getChildren().get(i);
			if (txtName.getText().isEmpty()) {
				break;
			}
			else {
				txtName.setEditable(false);
			}
		}
	}
	
	
	public GridPane getGridPreview() {
		return this.gridPreview;
	}

}
