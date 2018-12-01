package edu.ncsu.csc216.wolf_results.race_results;

import java.time.LocalDate;
import java.util.Observable;
//import java.util.Observer;
import java.util.Observer;

import edu.ncsu.csc216.wolf_results.util.RaceTime;

/**
 * creates a race object that knows its name,
 * distance, date, location, and results.
 * 
 * @author William
 *
 */
public class Race extends Observable {
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
		if (name == null || name.equals("") || name.trim().length() == 0){
			throw new IllegalArgumentException();
		}
		if (distance <= 0) {
			throw new IllegalArgumentException();
		}
		if (date == null) {
			throw new IllegalArgumentException();
		}
		if (location == null) {
			throw new IllegalArgumentException();
		}

		this.name = name.trim();
		this.distance = distance;
		this.date = date;
		this.location = location.trim();
		
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
		if (results == null) {
			throw new IllegalArgumentException();
		}
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
		//Race race, String name, int age, RaceTime time
		IndividualResult a = result;
		results.addResult(result);
		this.addObserver((Observer) a);
	}
	/**
	 * sets the distance of the race
	 * 
	 * @param newDistance
	 * 		the new distance to set the race to
	 */
	public void setDistance (double newDistance) {
		this.distance = newDistance;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * returns a string representation of the race
	 * 
	 * @return String
	 * 		the string representation of the race
	 */
	public String toString() {
		String theRace = name + " (" + distance + " miles) on " + date + " at " + location;
		return theRace;
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
		//get the size of the list
		//traverse the list looking for all ages within the range
		//make a new results list in which to store the new datums
		RaceResultList ageHolder = new RaceResultList();
		for (int i = 0; i < results.size(); i++) {
			IndividualResult a = results.getResult(i);
			if (a.getAge() >= minAge && a.getAge() <= maxAge) {
				ageHolder.addResult(a);
			}
		}
		RaceTime minPaces = new RaceTime(minPace);
		RaceTime maxPaces = new RaceTime(maxPace);
		RaceResultList bothFilters = new RaceResultList();
		for (int i = 0; i < ageHolder.size(); i++) {
			IndividualResult a = results.getResult(i);
			if (a.getPace().getSeconds() >= minPaces.getTimeInSeconds() &&
					a.getPace().getTimeInSeconds() <= maxPaces.getTimeInSeconds()) {
				bothFilters.addResult(a);
			}
		}
		
		return bothFilters;
	}
	/**
	 * returns an integer representation of the object
	 * 
	 * @retun int
	 * 		the hashed code of the race object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	 * returns true if the race is equal to another object
	 * (usually a race); else false
	 * 
	 * @return boolean
	 * 		true if a race is equal to another race; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
	 
}
