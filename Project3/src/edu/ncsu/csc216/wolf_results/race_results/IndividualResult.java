package edu.ncsu.csc216.wolf_results.race_results;

import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.wolf_results.util.RaceTime;

/**
 * this class is an observer and implements the comparable interface
 * @author William
 *
 */
public class IndividualResult extends Observable implements Comparable<IndividualResult>{

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
		if (race == null) {
			throw new IllegalArgumentException ();
		}
		if (name == null || name.equals("") || name.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		if (age < 0) {
			throw new IllegalArgumentException();
		}
		if (time == null) {
			throw new IllegalArgumentException();
		}
		this.race = race;
		this.name= name.trim();
		this.age = age;
		this.time = time;
		
		//finding pace//
		//1st find the seconds and divide that by distance//
		double seconds = this.time.getTimeInSeconds();
		double paceTime = seconds/this.race.getDistance();
		//cast back to an int
		int paceTimeInt = (int) paceTime;
		//2nd find out how many hours there are//
		//3600 seconds in an hour
		//find out how to make it even (modulo)
		int howManyHours = paceTimeInt % 3600;
		//subtract that 
		int evenHours = paceTimeInt;
		evenHours = howManyHours - paceTimeInt;
		int hours = evenHours / 3600; 
		//60 seconds in a minute
		//subtract the number of seconds in x number of hours to get remaining minutes
		int hoursSeconds = hours * 3600;
		int minutesSecondsLeft = paceTimeInt - hoursSeconds;
		int remainder = minutesSecondsLeft % 60;
		minutesSecondsLeft = minutesSecondsLeft - remainder;
		int minutes = minutesSecondsLeft / 60;
		
		int hoursAndMinutes = (hours * 3600) + (minutes * 60);
		int seconds2 = paceTimeInt - hoursAndMinutes;
		this.pace = new RaceTime(hours, minutes, seconds2);
		
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
		return this.pace;
	}
	/**
	 * compares one individual result to another result
	 * 
	 * @return int
	 * 		if the result is greater then 1 is returned, if the other result is equal to the comparing result
	 * 		then 0 is returned, else -1
	 */
	public int compareTo(IndividualResult that) {
		return this.time.compareTo(that.time);
	
	}
	/**
	 * returns the result as a string
	 * 
	 * @return String
	 * 		String representation of the result
	 */
	public String toString() {
		String individualResultString = "IndividualResult [name=" + name + ", age=" + age + ", time=" + time.toString() + ", pace=" + pace.toString() + "]";
		return individualResultString;
	}
	/**
	 * updates when an observed object changes
	 * @param thing
	 * 		no idea
	 * @param o
	 * 		no idea
	 */
	public void update(Observable thing, Object o) {
		
		Race race = (Race) thing;
		double newDistance = race.getDistance();
		double seconds = this.time.getTimeInSeconds();
		double paceTime = seconds/newDistance;
		//cast back to an int
		int paceTimeInt = (int) paceTime;
		//2nd find out how many hours there are//
		//3600 seconds in an hour
		//find out how to make it even (modulo)
		int howManyHours = paceTimeInt % 3600;
		//subtract that 
		int evenHours = paceTimeInt;
		evenHours = howManyHours - paceTimeInt;
		int hours = evenHours / 3600; 
		//60 seconds in a minute
		//subtract the number of seconds in x number of hours to get remaining minutes
		int hoursSeconds = hours * 3600;
		int minutesSecondsLeft = paceTimeInt - hoursSeconds;
		int remainder = minutesSecondsLeft % 60;
		minutesSecondsLeft = minutesSecondsLeft - remainder;
		int minutes = minutesSecondsLeft / 60;
		
		int hoursAndMinutes = (hours * 3600) + (minutes * 60);
		int seconds2 = paceTimeInt - hoursAndMinutes;
		this.pace = new RaceTime(hours, minutes, seconds2);
		
	}
}
