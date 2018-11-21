package edu.ncsu.csc216.wolf_results.race_results;
/**
 * creates a race 
 * @author William
 *
 */

import edu.ncsu.csc216.wolf_results.util.RaceTime;
import edu.ncsu.csc216.wolf_results.util.SortedLinkedList;

public class RaceResultList {
	/** the sortedLinkedList that will hold the results **/
	private SortedLinkedList<IndividualResult> results;
	
	/**
	 * creates a new list of results
	 */
	public RaceResultList() {
		results = new SortedLinkedList<IndividualResult>();
	}
	/**
	 * adds a new result to the list
	 * @param result
	 * 		the result to be added to the list
	 */
	public void addResult(IndividualResult result) {
		//todo
	}
	/**
	 * adds a race to the list 
	 * @param race
	 * 		the race that the racer was in
	 * @param name
	 * 		the name of the racer
	 * @param age
	 * 		the age of the racer
	 * @param time
	 * 		the time the racer ran
	 */
	public void addResult(Race race, String name, int age, RaceTime time) {
		//make a race
	}
	/**
	 * returns a result at a particular index
	 * @param idx
	 * 		index from which to get result
	 * @return IndividualResult
	 * 		the returned result
	 */
	public IndividualResult getResult (int idx) {
		return null;
	}
	
	/**
	 * the size of the results list
	 * @return int
	 * 		the size of the list
	 */
	public int size() {
		//return the size of the list
		return results.size();
	}
	/**
	 * returns a string of results
	 * 
	 * @return String[][]
	 * 		the array of results
	 */
	public String[][] getResultsAsArray(){
		return null;
	}
	/**
	 * filters the list based on age and time
	 * @param minAge
	 * 		the minimum age
	 * @param maxAge
	 * 		the maximum age
	 * @param minPace
	 * 		the minimum pace
	 * @param maxPace
	 * 		the maximum pace
	 * @return RaceResultList
	 * 		the filtered list of results
	 */
	public RaceResultList filter (int minAge, int maxAge, String minPace, String maxPace) {
		return null;
	}
}
