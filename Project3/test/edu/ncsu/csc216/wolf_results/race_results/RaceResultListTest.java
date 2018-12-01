package edu.ncsu.csc216.wolf_results.race_results;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.util.RaceTime;
/**
 * tests the raceresultlist class
 * @author William
 *
 */
public class RaceResultListTest {
	/**
	 * tests the constructor and the add methods
	 */
	@Test
	public void test() {
		RaceResultList list = new RaceResultList();
		LocalDate now = LocalDate.now();
		
		Race race = new Race("5 mile", 5, now, "Here");
		
		RaceTime min25 = new RaceTime("0:25:25");
		IndividualResult dubsRes = new IndividualResult(race, "Dubs", 27, min25);

		
		list.addResult(dubsRes);
		assertEquals(list.size(), 1);
		
		list.addResult(race, "Duder", 27, min25);
		assertEquals(list.size(), 2);
		try {
			list.addResult(null);
		} catch (IllegalArgumentException e) {
			//nothing needed here
		}
	}
	/**
	 * tests retrieval of results
	 */
	@Test
	public void testGetResult() {
		RaceResultList list = new RaceResultList();
		LocalDate now = LocalDate.now();
		
		Race race = new Race("5 mile", 5, now, "Here");
		
		RaceTime min25 = new RaceTime("0:25:25");
		IndividualResult dubsRes = new IndividualResult(race, "Dubs", 27, min25);

		
		list.addResult(dubsRes);
		assertEquals(list.size(), 1);
		
		list.addResult(race, "Duder", 27, min25);
		assertEquals(list.size(), 2);
		
		assertEquals(list.getResult(1), dubsRes);
	}
	/**
	 * testing the 2D array
	 */
	@Test
	public void testGetArray() {
		RaceResultList list = new RaceResultList();
		LocalDate now = LocalDate.now();
		
		Race race = new Race("5 mile", 5, now, "Here");
		
		RaceTime min25 = new RaceTime("0:25:25");
		IndividualResult dubsRes = new IndividualResult(race, "Dubs", 27, min25);

		
		list.addResult(dubsRes);
		assertEquals(list.size(), 1);
		
		list.addResult(race, "Duder", 27, min25);
		assertEquals(list.size(), 2);
		
		assertEquals(list.getResult(1), dubsRes);
		
		String name = list.getResult(1).getName();
		String time = list.getResult(1).getPace().toString();
		
		String[][] listarray = list.getResultsAsArray();
		assertEquals(listarray[1][0], name);
		assertEquals(listarray[1][3], time);
		
		list.addResult(race, "Duder", 15, min25);
		
		assertEquals(list.filter(14, 16, "00:00:00", "1:00:00").size(), 1);
		
		
		
	}
	
}
