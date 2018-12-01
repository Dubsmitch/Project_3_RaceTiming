package edu.ncsu.csc216.wolf_results.race_results;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.util.RaceTime;

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
		IndividualResult dubsRes= new IndividualResult(race, "Dubs", 27, min25);

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
		
		assertEquals(list.filter(0, 100, "00:00:00", "1:00:00").size(), 1);
	
		
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
	}

}
