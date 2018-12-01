package edu.ncsu.csc216.wolf_results.util;

import java.util.Scanner;

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
		@SuppressWarnings("resource")
		Scanner a = new Scanner(time).useDelimiter(":");
		int hoursh = 0;
		int minutesm = 0;
		int secondss = 0;
		if (a.hasNextInt()) {
			hoursh = a.nextInt();
			if (hoursh < 0) {
				a.close();

				throw new IllegalArgumentException();
			}
		} else {
			a.close();

			throw new IllegalArgumentException();
		}
		
		if (a.hasNextInt()) {
			minutesm = a.nextInt();
			String thing = Integer.toString(minutesm);
			if (thing.length() > 2) {
				a.close();
				throw new IllegalArgumentException();
			}
		} else {
			a.close();

			throw new IllegalArgumentException();
		}
		
		if (a.hasNextInt()) {
			secondss = a.nextInt();
			String thing = Integer.toString(secondss);
			if (thing.length() > 2) {
				a.close();

				throw new IllegalArgumentException();

			}
		} else {
			a.close();
			throw new IllegalArgumentException();
		}
		
		if (a.hasNext()) {
			a.close();

			throw new IllegalArgumentException();
		}
		
		if (secondss > 59 || minutesm > 59 || secondss < 0 || minutesm < 0) {
			a.close();

			throw new IllegalArgumentException();
		}
		this.hours = hoursh;
		this.minutes = minutesm;
		this.seconds = secondss;
		a.close();
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
		return this.hours;
	}
	/**
	 * returns the seconds of the result
	 * @results int
	 * 		the seconds place in the result time
	 */
	public int getSeconds() {
		return this.seconds;
	}
	/**
	 * returns the minuntes of the result
	 * 
	 * @return int
	 * 		the minutes place of the time of the result
	 */
	public int getMinutes() {
		return this.minutes;
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
		String hoursh = "";
		String minutem = "";
		String secondss = "";
		
		hoursh = Integer.toString(hours);
		minutem = Integer.toString(minutes);
		secondss = Integer.toString(seconds);
		
		if (secondss.length() == 1) {
			secondss = "0" + secondss;
		}
		if (minutem.length() == 1) {
			minutem = "0" + minutem;
		}
		String together = hoursh + ":" + minutem + ":" + secondss;
		return together;
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
		if (other.getTimeInSeconds() > this.getTimeInSeconds()) {
			return -1;
		} else if (other.getTimeInSeconds() == this.getTimeInSeconds()) {
			return 0;
		} else {
			return 1;
		}
	}
}
