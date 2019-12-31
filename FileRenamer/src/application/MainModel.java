package application;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import util.Observable;

public class MainModel extends Observable {
	
	private ArrayList <File> files = new ArrayList<File> ();
	private ArrayList <String> names = new ArrayList<String>();

	public MainModel(List <File> selectedFiles) {
		for (int i = selectedFiles.size()-1; i >= 0; i--) {
			this.files.add(selectedFiles.get(i));
		}
		for (int i = 0; i < selectedFiles.size(); i++) {
			this.names.add(this.files.get(i).getName());
		}
	}
	
	public void fake_rename (String newName) {
		for (int i = 0; i < this.names.size(); i++) {
			this.names.remove(i);
			this.names.add(i, newName + (i+1) + ".txt");
		}
		this.notifyObservers();
	}
	
	public void rename (String newName) {
		for (int i = 0; i < this.files.size(); i++) {
			File newFile = new File(this.files.get(i).getParent() + "\\" + newName + (i+1) + ".txt");
			this.files.get(i).renameTo(newFile);
		}
		this.notifyObservers();
	}
	
	public ArrayList<String> getNames() {
		return this.names;
	}
	
}
