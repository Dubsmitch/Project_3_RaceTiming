package edu.ncsu.csc216.wolf_results.race_results;

import java.time.LocalDate;

/**
 * creates a race object that knows its name,
 * distance, date, location, and results.
 * 
 * @author William
 *
 */
public class Race {
	/** the name of the race **/
	private String name;
	/** the distance of the race **/
	private double distance;
	/** the date of the race **/
	private LocalDate date;
	/** the location of the race **/
	private String location;
	/** the results list for the race **/
	private RaceResultList results;
	/**
	 * creates a race object without a given race result list
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
	public Race (String name, double distance, LocalDate date, String location) {
		this.name = name;
		this.distance = distance;
		this.date = date;
		this.location = location;
		
		RaceResultList newList = new RaceResultList();
		this.results = newList;
	}
	/**
	 * creates a race object with a given results list
	 * 
	 * @param name
	 * 		the name of the race
	 * @param distance
	 * 		the distance of the race
	 * @param date
	 * 		the date of the race
	 * @param location
	 * 		the location of the race
	 * @param results
	 * 		the results list of the race
	 */
	public Race (String name, double distance, LocalDate date, String location, RaceResultList results) {
		this(name, distance, date, location);
		this.results = results;
	}
	/**
	 * returns the name of the race 
	 * @return String
	 * 		the name of the race
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * returns the distance of the race
	 * 
	 * @return double
	 * 		the distance of the race
	 */
	public double getDistance () {
		return this.distance;
	}
	
	/**
	 * returns the date of the race
	 * 
	 * @return LocalDate
	 * 		the date of the race
	 */
	public LocalDate getDate() {
		return this.date;
	}
	/**
	 * returns the location of the race
	 * 
	 * @return String
	 * 		the location of the race
	 */
	public String getLocation() {
		return this.location;
	}
	/**
	 * returns the list of results
	 * 
	 * @return RaceResultList
	 * 		the list of results
	 */
	public RaceResultList getResults() {
		return this.results;
	}
	/**
	 * adds a result to the result list
	 * 
	 * @param result
	 * 		the result to be added to the result list
	 */
	public void addIndividualResult(IndividualResult result) {
		//to-do
	}
	/**
	 * sets the distance of the race
	 * 
	 * @param newDistance
	 * 		the new distance to set the race to
	 */
	public void setDistance (double newDistance) {
		this.distance = newDistance;
	}
	
	/**
	 * returns a string representation of the race
	 * 
	 * @return String
	 * 		the string representation of the race
	 */
	public String toString() {
		return null;
	}
	/**
	 * returns an integer representation of the object
	 * 
	 * @retun int
	 * 		the hashed code of the race object
	 */
	public int hashCode() {
		return 0;
	}
	/**
	 * returns true if the race is equal to another object
	 * (usually a race); else false
	 * 
	 * @return boolean
	 * 		true if a race is equal to another race; else false
	 */
	public boolean equals(Object o) {
		return false;
	}
	
	/**
	 * Returns a filtered list of results
	 * 
	 * @param minAge
	 * 		the minimum age of participants
	 * @param maxAge
	 * 		the maximum age of participants
	 * @param minPace
	 * 		the minimum pace of participants
	 * @param maxPace
	 * 		the maximum pace of participants
	 * @return RaceResultList
	 * 		the filtered list of results
	 */
	public RaceResultList filter(int minAge, int maxAge, String minPace, String maxPace) {
		return null;
	}
	
	public void addObserver(Race race) {
		// TODO Auto-generated method stub
		
	}
	 
}
