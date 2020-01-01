package application;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
	
	private ArrayList <File> files = new ArrayList<File> ();
	private ArrayList <String> names = new ArrayList<String>();
	
	public void fake_rename (String newName) {
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
	
	public void rename (String newName) {
		/*
		 * Rename all the file names in this.files to match the name of the text inputted in the textfield (with the 
		 * correct formatted extension ex. txt, pdf, etc.)
		 */
		for (int i = 0; i < this.files.size(); i++) {
			File file =  this.files.get(i);
			String newPath = file.getParent() + "\\" + newName + (i+1) + getExtension(file);
			File newFile = new File(newPath);
			this.files.get(i).renameTo(newFile);
		}
		this.notifyObservers();
	}
	
	public void extend(List <File> newFiles) {
		this.files.addAll(newFiles);
		for (int i = this.names.size(); i < this.files.size(); i++) {
			this.names.add(this.files.get(i).getName());
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
