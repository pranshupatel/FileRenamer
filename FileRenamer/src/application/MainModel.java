package application;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import util.Observable;

/** MainModel class. Stores all relevant information of the selected files and the actions that can be
 * performed with them.
 *
 */
public class MainModel extends Observable {
	
	/**
	 * === Private Attributes ===
	 * files: Stores all selected file objects in an ArrayList
	 * names: Stores all the "Preview" file names in an ArrayList
	 **/
	
	private ArrayList <File> files	= new ArrayList <File> ();
	private ArrayList <String> names = new ArrayList<String>();
	
	public void fakeRenameAll (String newName) {
		/*
		 * Rename all values in the this.names to match the name of the the text inputted in the textfield (with the correct
		 * format and extension ex. txt, pdf, etc)
		 */
		
		for (int i = 0; i < this.names.size(); i++) {
			this.names.remove(i);
			this.names.add(i, newName + (i+1) + getExtension(this.files.get(i)));
		}
		this.notifyObservers();
	}
	
	public void renameAll (PreviewView view) {
		/*
		 * Rename all the file names in this.files to match the name of the text inputted in the textfield (with the 
		 * correct formatted extension ex. txt, pdf, etc.)
		 */
		for (int i = 0; i < this.files.size(); i++) {
			TextField txtName = (TextField) view.getGridPreview().getChildren().get(i);
			File file = this.files.get(i);
			String newPath = file.getParent() + "\\" + txtName.getText();
			File newFile = new File(newPath);
			this.files.get(i).renameTo(newFile);
			this.files.remove(i);
			this.files.add(i, newFile);
		}
		this.notifyObservers();
	}
	
	public void fakeRenameSeperate(PreviewView view) {
		/*
		 * "Fake" renames the files seperately by each textbox. NOT MEANT FOR BULK FILE EDITING.
		 */
		for (int i = 0; i < this.names.size(); i++) {
			this.names.remove(i);
			TextField txtName = (TextField) view.getGridPreview().getChildren().get(i);
			this.names.add(i, txtName.getText());
		}
		this.notifyObservers();
	}
	
	public void extend(List <File> newFiles) {
		/*
		 * Extend the <files> attribute with all the new files in <newFiles>. NOTE: Works same as the .extend
		 * method for Lists in Python.
		 */
		
		for (int i = 0; i < newFiles.size(); i++) {
			if (!this.files.contains(newFiles.get(i))){
				this.files.add(newFiles.get(i));
				this.names.add(newFiles.get(i).getName());
			}
		}
		this.notifyObservers();
	}
	
	
	// === HELPER METHODS ===
	
	public Boolean isEmpty() {
		return this.files.isEmpty();
	}
	
	public ArrayList<String> getNames() {
		return this.names;
	}
	
	public ArrayList <File> getFiles() {
		return this.files;
	}
	
	public static String getExtension (File file) {
		/*
		 * Return the extension of <file>. Ex, ".txt" or ".pdf"
		 * HELPER METHOD, DONT CHANGE
		 */
		String name = file.getName();
		ArrayList<String> nameSplit = split(name, ".");
		return nameSplit.get(1);
	}
	
	public static ArrayList <String> split (String name, String chr) {
		/*
		 * Return an ArrayList containing all the parts of the String <name> that are 
		 * seperated by <chr>".
		 * HELPER METHOD, DONT CHANGE
		 */
		ArrayList <String> split = new ArrayList<String>();
		int index = name.indexOf(chr);
		split.add(name.substring(0, index));
		split.add(name.substring(index));
		return split;
		
	} 
	
}
