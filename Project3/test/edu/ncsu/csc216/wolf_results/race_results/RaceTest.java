package edu.ncsu.csc216.wolf_results.race_results;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.util.RaceTime;
/**
 * tests the race class
 * @author William
 *
 */
public class RaceTest {
	/**
	 * tests the constructor
	 */
	@Test
	public void testConstructor() {
		//create a time
		LocalDate now = LocalDate.now();
		
		Race race = new Race("5 mile", 5, now, "Here");
		
		RaceTime min25 = new RaceTime("0:25:25");
		IndividualResult dubsRes = new IndividualResult(race, "Dubs", 27, min25);

		race.addIndividualResult(dubsRes);
		
		RaceResultList list = new RaceResultList();

		
		list.addResult(dubsRes);		
		
		Race racePlus = new Race ("15 miles", 15, now, "here", list);
		
		assertEquals(racePlus.getResults().size(), 1);
		
		assertEquals(racePlus.getName(), "15 miles"); 
		assertEquals(racePlus.getDate(), now);
		assertEquals(racePlus.getDistance(), 15, .01);
		assertEquals(racePlus.getLocation(), "here");
		
		racePlus.setDistance(10);
		assertEquals(racePlus.getDistance(), 10, .01);
		
		IndividualResult a = new IndividualResult(race, "Dubs", 26, min25);
		
		IndividualResult b = new IndividualResult(race, "Dubs", 20, min25);
		IndividualResult d = new IndividualResult(race, "Dubs", 21, min25);
		list.addResult(a);
		list.addResult(b);
		list.addResult(d);

		race.addIndividualResult(a);
		race.addIndividualResult(b);
		race.addIndividualResult(d);
		assertEquals(race.filter(0, 21, "00:00:00", "1:00:00").size(), 2);
	
		
		//RaceTime avg5 = new RaceTime("0:05:05");
		//Race race, String name, int age, RaceTime time
		//RaceTime min75 = new RaceTime("1:15:00");
		//RaceTime avg15 = new RaceTime("0:15:00");
		//IndividualResult dubsRes= new IndividualResult(race, "Dubs", 27, min25);
	}
	/**
	 * tests the equals and hashcodes
	 */
	@Test
	public void testEqualsHash() {
		LocalDate now = LocalDate.now();
		RaceResultList list = new RaceResultList();

		Race race = new Race("5 mile", 5, now, "Here");
		Race racePlus = new Race ("15 miles", 15, now, "here", list);

		assertTrue(race.equals(race));
		assertTrue(!race.equals(racePlus));
		
		assertEquals(race.hashCode(), race.hashCode());
		
		assertTrue(!race.equals(racePlus));
	}
	
	/**
	 * tests the to String method
	 */
	@Test
	public void testToString() {
		LocalDate now = LocalDate.now();
		Race race = new Race("5 mile", 5, now, "Here");
		String raceString = "5 mile (5.0 miles) on " + now.toString() + " at Here";
		assertEquals(race.toString(), raceString);
	}
}
