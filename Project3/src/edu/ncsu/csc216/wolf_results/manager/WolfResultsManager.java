package edu.ncsu.csc216.wolf_results.manager;

import java.util.Observable;

import edu.ncsu.csc216.wolf_results.race_results.RaceList;
/**
 * creates a manager
 * 
 * the manager is a singleton and it updates and manages a racelist
 * 
 * @author William
 *
 */
public class WolfResultsManager {
	/** an instance of itself **/
	private WolfResultsManager instance;
	/** an instance of the race list **/
	private RaceList list;
	/** filename **/
	private String filename;
	/** if the file has been changed or not **/
	private boolean changed;
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
		return null;
	}
	/**
	 * calls getInstance to construct an instance
	 * of itself
	 */
	private WolfResultsManager() {
		//make a constructor
	}
	/**
	 * creates a new list
	 */
	public void newList() {
		//creates a new list
	}
	/**
	 * checks to see if the file has been changed
	 * if yes then changed is set to true; else false.
	 * @return boolean
	 * 		if a file has been changed
	 */
	public boolean isChanged() {
		return false;
	}
	/**
	 * sets if a file has been changed or not
	 */
	private void setChanged() {
		//create this
	}
	/**
	 * returns the name of the file
	 * @return String
	 * 		the name of the file
	 */
	public String getFilename() {
		return null;
	}
	/**
	 * sets the filename
	 * @param filename
	 * 		the file name to be set to
	 */
	public void setFilename(String filename) {
		//sets the filename
	}
	/**
	 * loads from file
	 * @param filename
	 * 		the file to be read from
	 */
	public void loadFile(String filename) {
		//call io class filereader
	}
	/**
	 * writes to a file
	 * @param filename
	 * 		the file to be saved to
	 */
	public void saveFile(String filename) {
		//call io filewriter
	}
	/**
	 * gets a racelist
	 * @return RaceList
	 * 		the racelist that was gotten
	 */
	public RaceList getRaceList() {
		return null;
	}
	/**
	 * updates an object based on changes to the observable objecct
	 * @param o
	 * 		observable object
	 * @param args
	 * 		object under observation (?)
	 */
	public void update(Observable o, Object args) {
		//no idea what this means exactly
	}
}
