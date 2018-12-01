package edu.ncsu.csc216.wolf_results.race_results;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.util.RaceTime;
/**
 * tests the racelist class
 * @author William
 *
 */
public class RaceListTest {
	/**
	 * tests the constructor and add
	 */
	@Test
	public void test() {
		RaceList list = new RaceList();
		
		//create a race and a result and then add it to the list
		LocalDate now = LocalDate.now();
		Race race = new Race("5 mile", 5, now, "Here");
		
		RaceTime min25 = new RaceTime("0:25:25");
		IndividualResult dubsRes = new IndividualResult(race, "Dubs", 27, min25);
		
		race.addIndividualResult(dubsRes);
		assertEquals(race.getResults().getResult(0), dubsRes);
		double raceDistance = 2.5;
		race.setDistance(raceDistance);
		assertEquals(race.getResults().getResult(0), dubsRes);
		assertEquals(raceDistance, dubsRes.getRace().getDistance(), .01);
		
		list.addRace(race);
		assertEquals(list.size(), 1);
		list.addRace("Frenzy", 15.5, now, "Durango");
		assertEquals(list.size(), 2);
		
		
	}
	/**
	 * testing removing a race
	 */
	@Test
	public void testRemove() {
		RaceList list = new RaceList();
		
		//create a race and a result and then add it to the list
		LocalDate now = LocalDate.now();
		Race race = new Race("5 mile", 5, now, "Here");
		
		RaceTime min25 = new RaceTime("0:25:25");
		IndividualResult dubsRes = new IndividualResult(race, "Dubs", 27, min25);
		
		race.addIndividualResult(dubsRes);
		assertEquals(race.getResults().getResult(0), dubsRes);
		double raceDistance = 2.5;
		race.setDistance(raceDistance);
		assertEquals(race.getResults().getResult(0), dubsRes);
		assertEquals(raceDistance, dubsRes.getRace().getDistance(), .01);
		
		list.addRace(race);
		assertEquals(list.size(), 1);
		list.addRace("Frenzy", 15.5, now, "Durango");
		assertEquals(list.size(), 2);
		
		list.removeRace(0);
		assertEquals(list.size(), 1);
		
		list.removeRace(0);
		assertEquals(list.size(), 0);
	}
	
	/**
	 * tests getting a race from a list
	 */
	@Test
	public void testGetRace() {
		RaceList list = new RaceList();
		
		//create a race and a result and then add it to the list
		LocalDate now = LocalDate.now();
		Race race = new Race("5 mile", 5, now, "Here");
		
		RaceTime min25 = new RaceTime("0:25:25");
		IndividualResult dubsRes = new IndividualResult(race, "Dubs", 27, min25);
		
		race.addIndividualResult(dubsRes);
		assertEquals(race.getResults().getResult(0), dubsRes);
		double raceDistance = 2.5;
		race.setDistance(raceDistance);
		assertEquals(race.getResults().getResult(0), dubsRes);
		assertEquals(raceDistance, dubsRes.getRace().getDistance(), .01);
		
		list.addRace(race);
		assertEquals(list.size(), 1);
		list.addRace("Frenzy", 15.5, now, "Durango");
		assertEquals(list.size(), 2);
		Race newRace = new Race("Frenzy", 15.5, now, "Durango");
		
		assertEquals(list.getRace(0), race);
		assertEquals(list.getRace(1), newRace);
		
		try {
			list.getRace(-1);
			fail();
			
		} catch (IllegalArgumentException e) {
			assertEquals(list.getRace(0), race);

		}
		
		try {
			list.getRace(2);
		} catch (IllegalArgumentException e) {
			assertEquals(list.getRace(0), race);

		}
	}
}
