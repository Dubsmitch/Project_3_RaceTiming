package edu.ncsu.csc216.wolf_results.race_results;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.util.RaceTime;

public class IndividualResultTest {

	@Test
	public void testConstructor() {
		//String name, double distance, LocalDate date, String location
		LocalDate now = LocalDate.now();
		Race race = new Race("5 mile", 5, now, "Here");
		RaceTime min25 = new RaceTime("0:25:25");
		RaceTime avg5 = new RaceTime("0:05:05");
		//Race race, String name, int age, RaceTime time
		RaceTime min75 = new RaceTime("1:15:00");
		RaceTime avg15 = new RaceTime("0:15:00");
		IndividualResult dubsRes= new IndividualResult(race, "Dubs", 27, min25);
		
		//check that minutes pace conversion works
		assertEquals(dubsRes.getPace().getTimeInSeconds(), avg5.getTimeInSeconds());
		
		//check that hours conversion works
		IndividualResult dubsRes15= new IndividualResult(race, "Dubs", 27, min75);
		assertEquals(dubsRes15.getPace().getTimeInSeconds(), avg15.getTimeInSeconds());
		
		//test compare to
		assertEquals(dubsRes15.compareTo(dubsRes), 1);
		assertEquals(dubsRes15.compareTo(dubsRes15), 0);
		assertEquals(dubsRes.compareTo(dubsRes15), -1);
		
		//IndividualResult [name=NAME, age=AGE, time=TIME, pace=PACE])
		//test to string
		String result = "IndividualResult [name=Dubs, age=27, time=0:25:25, pace=0:05:05]";
		assertEquals(dubsRes.toString(), result);
	}
	/**
	 * tests obeserver update;
	 */
	@Test
	public void testObserver() {
		LocalDate now = LocalDate.now();
		Race race = new Race("5 mile", 5, now, "Here");
		RaceTime min25 = new RaceTime("0:25:25");
		
		IndividualResult dubsRes= new IndividualResult(race, "Dubs", 27, min25);
		race.addIndividualResult(dubsRes);
		assertEquals(race.getResults().getResult(0), dubsRes);
		double raceDistance = 2.5;
		race.setDistance(raceDistance);
		assertEquals(race.getResults().getResult(0), dubsRes);
		assertEquals(raceDistance, dubsRes.getRace().getDistance(), .01);

	}

}
