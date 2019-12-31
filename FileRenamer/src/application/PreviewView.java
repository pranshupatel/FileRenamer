package application;
import util.Observable;
import util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PreviewView implements Observer { 
	/**
	 * PreviewView class. This class is responsible for all relevant updates to the 
	 * "Preview" ListView display control which stores all the potential names of the files.
	 */
	
	@FXML
	private ListView <String> lstPreview;
	
	public PreviewView(ListView <String> lstPreview) {
		this.lstPreview = lstPreview;
	}
	@Override
	public void update(Observable o) {
		/*
		 * Updates the Preview ListView.
		 */
		MainModel model = (MainModel)o;
		this.lstPreview.getItems().remove(0, this.lstPreview.getItems().size());
		for (int i = 0; i < model.getNames().size(); i++) {
			this.lstPreview.getItems().add(model.getNames().get(i));
		}
	}

}
