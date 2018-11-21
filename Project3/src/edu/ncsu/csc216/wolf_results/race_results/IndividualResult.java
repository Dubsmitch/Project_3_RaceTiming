package edu.ncsu.csc216.wolf_results.race_results;

import java.util.Observable;

import edu.ncsu.csc216.wolf_results.util.RaceTime;

/**
 * this class is an observer and implements the comparable interface
 * @author William
 *
 */
public class IndividualResult implements Comparable<IndividualResult>{

	/** the name of the racer **/
	private String name;
	/** the age of the racer **/
	private int age;
	/** the pace of the racer **/
	private RaceTime pace;
	/** the time of the racer **/
	private RaceTime time;
	/** the race the runner was in **/
	private Race race;
	/**
	 * Creates a result object
	 * 
	 * @param race
	 * 		the race's name
	 * @param name
	 * 		the racer's name
	 * @param age
	 * 		the racer's age
	 * @param time
	 * 		the racer's time
	 */
	public IndividualResult (Race race, String name, int age, RaceTime time) {
		this.race = race;
		this.name = name;
		this.age = age;
		this.time = time;
		this.pace = null;
		//RaceTime thePace = new RaceTime()
		//double totalSeconds = ((double) this.time.getTimeInSeconds() / this.race.getDistance()); // do more logic
	}
	/**
	 * returns the racer's name
	 * 
	 * @return String
	 * 		the racer's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * returns the race the runner ran in
	 * @return Race
	 * 		the race the runner ran in
	 */
	public Race getRace() {
		return this.race;
	}
	
	/**
	 * returns the age of the runner
	 * 
	 * @return int
	 * 		the age of the runner
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * returns the time of the racer
	 * @return RaceTime
	 * 		the RaceTime associated with the racer's result
	 */
	public RaceTime getTime() {
		return this.time;
	}
	/**
	 * Returns the pace of the result (minutes:seconds per mile)
	 * 
	 * @return RaceTime
	 * 		the pace of the runner
	 */
	public RaceTime getPace() {
		return null;
	}
	/**
	 * compares one individual result to another result
	 * 
	 * @return int
	 * 		if the result is greater then 1 is returned, if the other result is equal to the comparing result
	 * 		then 0 is returned, else -1
	 */
	public int compareTo(IndividualResult that) {
		return 0;
	}
	/**
	 * returns the result as a string
	 * 
	 * @return String
	 * 		String representation of the result
	 */
	public String toString() {
		return null;
	}
	/**
	 * updates when an observed object changes
	 * @param thing
	 * 		no idea
	 * @param o
	 * 		no idea
	 */
	public void update(Observable thing, Object o) {
		//no idea what to do here
	}
}
