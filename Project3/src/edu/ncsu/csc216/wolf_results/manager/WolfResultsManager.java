package edu.ncsu.csc216.wolf_results.manager;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.wolf_results.model.io.WolfResultsReader;
import edu.ncsu.csc216.wolf_results.model.io.WolfResultsWriter;
import edu.ncsu.csc216.wolf_results.race_results.RaceList;
/**
 * creates a manager
 * 
 * the manager is a singleton and it updates and manages a racelist
 * 
 * @author William
 *
 */
public class WolfResultsManager extends Observable implements Observer {
	/** an instance of itself **/
	private static WolfResultsManager instance;
	/** an instance of the race list **/
	private RaceList list;
	/** filename **/
	private String filename;
	/** if the file has been changed or not **/
	private boolean changed;

	/**
	 * calls getInstance to construct an instance
	 * of itself
	 */
	private WolfResultsManager() {
		list = new RaceList();
		list.addObserver(this);
	}
	
	/**
	 * creates an instance if there is none, else returns
	 * the one that exists
	 * @return WolfResultsManager
	 * 		the singleton of this class.
	 * 		there can only be on instance of this class so this method
	 * 		checks to see if there is one and if yes, returns the
	 * 		current one, else creates one.
	 */
	public static WolfResultsManager getInstance() {
		if (instance == null) {
			instance = new WolfResultsManager();
		}
		return instance;
	}
	/**
	 * creates a new list
	 */
	public void newList() {
		list = new RaceList();
	}
	/**
	 * checks to see if the file has been changed
	 * if yes then changed is set to true; else false.
	 * @return boolean
	 * 		if a file has been changed
	 */
	public boolean isChanged() {
		return this.changed;
	}
	/**
	 * sets if a file has been changed or not
	 */
	private void setChanged(boolean changed) {
		this.changed = changed;
	}
	/**
	 * returns the name of the file
	 * @return String
	 * 		the name of the file
	 */
	public String getFilename() {
		return this.filename;
	}
	/**
	 * sets the filename
	 * @param filename
	 * 		the file name to be set to
	 */
	public void setFilename(String filename) {
		if (filename == null || filename.equals("") || filename.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.filename = filename;
	}
	/**
	 * loads from file
	 * @param filename
	 * 		the file to be read from
	 */
	public void loadFile(String filename) {
		RaceList list = WolfResultsReader.readRaceListFile(filename);
		this.list = list;
		
	}
	/**
	 * writes to a file
	 * @param filename
	 * 		the file to be saved to
	 */
	public void saveFile(String filename) {
			
		WolfResultsWriter.writeRaceFile(filename, this.list);
	}
	/**
	 * gets a racelist
	 * @return RaceList
	 * 		the racelist that was gotten
	 */
	public RaceList getRaceList() {
		return this.list;
	}
	/**
	 * updates an object based on changes to the observable objecct
	 * @param o
	 * 		observable object
	 * @param args
	 * 		object under observation (?)
	 */
	public void update(Observable o, Object args) {
		setChanged(true);
	}
}
