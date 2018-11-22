package edu.ncsu.csc216.wolf_results.util;
/**
 * creates a race time out of integer and string
 * inputs with a valid construction
 * 
 * @author William
 *
 */
public class RaceTime {
	/** hours **/
	private int hours;
	/** minutes **/
	private int minutes;
	/** seconds **/
	private int seconds;
	
	/**
	 * creates a RaceTime object, namely a time with the format
	 * hh:mm:ss
	 * 
	 * @param hours
	 * 		time in hours position
	 * @param minutes
	 * 		time in minutes position
	 * @param seconds
	 * 		time in seconds position
	 */
	public RaceTime (int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	/**
	 * creates a RaceTime object (a time) from a given string
	 * in the format hh:mm:ss
	 * @param time
	 * 		the time of the result
	 */
	public RaceTime (String time) {
		//must be in the format hh:mm:ss
		//easy, create a scanner with the : as a delimiter.
		//this.hours = 1;
		//this.minutes = 1;
		//this.seconds = 0;
	}
	/**
	 * returns the hours of the result
	 * @return int
	 * 		the time in hours
	 */
	public int getHours() {
		return 0;
	}
	/**
	 * returns the seconds of the result
	 * @results int
	 * 		the seconds place in the result time
	 */
	public int getSeconds() {
		return 0;
	}
	/**
	 * returns the minuntes of the result
	 * 
	 * @return int
	 * 		the minutes place of the time of the result
	 */
	public int getMinutes() {
		return 0;
	}
	
	/**
	 * returns the time in seconds
	 * @return int
	 * 		the time in seconds
	 */
	public int getTimeInSeconds() {
		int myHours = this.hours;
		int myMinutes = this.minutes;
		int mySeconds = this.seconds;
		int totalTime = 0;
		totalTime = (myHours * 60 * 60) + (myMinutes * 60) + mySeconds;
		return totalTime;
	}
	/**
	 * returns the race time as a string
	 * 
	 * @return String
	 * 			the string to be returned in format
	 * 			hh:mm:ss
	 */
	public String toString() {
		String a = null;
		return a;
	}
	/**
	 * compares one race time to another one
	 * 
	 * @param other
	 * 		the race time to be compared to
	 * @return int
	 * 		-1 if less, 0 if the same, 1 if greater than
	 */
	public int compareTo(RaceTime other) {
		return 0;
	}
}
