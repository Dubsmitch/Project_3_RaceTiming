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
		if (result == null) {
			throw new IllegalArgumentException();
		}
		results.add(result);
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
		IndividualResult a = new IndividualResult (race, name, age, time);
		results.add(a);
	}
	/**
	 * returns a result at a particular index
	 * @param idx
	 * 		index from which to get result
	 * @return IndividualResult
	 * 		the returned result
	 */
	public IndividualResult getResult (int idx) {
		if (idx < 0 || idx >= results.size()) {
			throw new IllegalArgumentException();
		}
		return results.get(idx);
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
		String [][] resultsArray = new String[results.size()][4];
		for (int i = 0; i < results.size(); i++) {
			IndividualResult s = results.get(i);
			resultsArray[i][0] = s.getName();
			resultsArray[i][1] = Integer.toString(s.getAge());
			resultsArray[i][2] = s.getTime().toString();
			resultsArray[i][3] = s.getPace().toString();
		}
		return resultsArray;
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
		//get the size of the list
		//traverse the list looking for all ages within the range
		//make a new results list in which to store the new datums
		RaceResultList ageHolder = new RaceResultList();
		for (int i = 0; i < results.size(); i++) {
			IndividualResult a = results.get(i);
			if (a.getAge() >= minAge && a.getAge() <= maxAge) {
				ageHolder.addResult(a);
			}
		}
		RaceTime minPaces = new RaceTime(minPace);
		RaceTime maxPaces = new RaceTime(maxPace);
		RaceResultList bothFilters = new RaceResultList();
		for (int i = 0; i < ageHolder.size(); i++) {
			IndividualResult a = ageHolder.getResult(i);
			if (a.getPace().getSeconds() >= minPaces.getTimeInSeconds() &&
					a.getPace().getTimeInSeconds() <= maxPaces.getTimeInSeconds()) {
				bothFilters.addResult(a);
			}
		}

		return bothFilters;	
		}
}
