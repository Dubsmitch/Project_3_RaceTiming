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
	
	public IndividualResult (Race race, String name, int age, RaceTime time) {
		this.race = race;
		this.name = name;
		this.age = age;
		this.time = time;
		this.pace = null;
		//RaceTime thePace = new RaceTime()
		//double totalSeconds = ((double) this.time.getTimeInSeconds() / this.race.getDistance()); // do more logic
	}
	
	public String getName() {
		return this.name;
	}
	
	public Race getRace() {
		return this.race;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public RaceTime getTime() {
		return this.time;
	}
	
	public RaceTime getPace() {
		return null;
	}
	
	public int compareTo(IndividualResult that) {
		return 0;
	}
	
	public String toString() {
		return null;
	}
	
	public void update(Observable thing, Object o) {
		//no idea what to do here
	}
}
