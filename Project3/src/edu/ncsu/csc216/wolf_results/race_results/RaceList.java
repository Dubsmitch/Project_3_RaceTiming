package edu.ncsu.csc216.wolf_results.race_results;

import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.wolf_results.util.ArrayList;
/**
 * creates a list of races
 * 
 * does not have a particular order
 * 
 * @author William
 *
 */
public class RaceList extends Observable implements Observer{
	/** a list in which to hold results **/
	private ArrayList races;
	/**
	 * create a new, empty racelist
	 */
	public RaceList() {
		races = new ArrayList();
	}
	/**
	 * adds a race to the list
	 * @param race
	 * 		the race to be added to the list
	 */
	public void addRace(Race race) {
		// to-do
	}
	/**
	 * adds a race to the list
	 * (will need to construct the race object
	 * so that it can be added to the list)
	 * 
	 * @param name
	 * 		the name of the race
	 * @param distance
	 * 		the distance of the race
	 * @param date
	 * 		the date of the race
	 * @param location
	 * 		the location of the race
	 */
	public void addRace(String name, double distance, LocalDate date, String location) {
		//to-do
	}
	/**
	 * removes a list at a particular index
	 * @param idx
	 * 		the index from which to remove a race
	 */
	public void removeRace(int idx) {
		//remove a race
	}
	/**
	 * returns a race from the list at a specified
	 * index
	 * @param idx
	 * 		the index from which to retrieve the race
	 * @return Race
	 * 		the race at the spefified index
	 * 
	 */
	public Race getRace(int idx) {
		return null;
	}
	/**
	 * returns the size of the list of races
	 * @return int
	 * 		the size of the lis
	 */
	public int size() {
		return races.size();
	}
	/**
	 * updates the observable if there are any changes
	 * @param o
	 * 		no idea
	 * @param args
	 * 		no idea
	 */
	public void update(Observable o, Object args) {
		//no idea how to do this
	}
	
	public void addRace(String name, double distance, LocalDate date, String location, RaceResultList results) {

		//Other code as appropriate
		Race race = new Race(name, distance,date, location, results);
		race.addObserver(this); //Adds the current object as an Observer
		//Other code as appropriate

	}
	
}
