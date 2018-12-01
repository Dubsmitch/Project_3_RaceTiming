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
		

		//RaceTime avg5 = new RaceTime("0:05:05");
		//Race race, String name, int age, RaceTime time
		//RaceTime min75 = new RaceTime("1:15:00");
		//RaceTime avg15 = new RaceTime("0:15:00");
		//IndividualResult dubsRes= new IndividualResult(race, "Dubs", 27, min25);
	}

}
