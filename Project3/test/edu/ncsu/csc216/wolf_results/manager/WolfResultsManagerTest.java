package edu.ncsu.csc216.wolf_results.manager;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.race_results.IndividualResult;
import edu.ncsu.csc216.wolf_results.race_results.Race;
import edu.ncsu.csc216.wolf_results.util.RaceTime;

public class WolfResultsManagerTest {

	@Test
	public void testConstrctor() {
		WolfResultsManager a = WolfResultsManager.getInstance();
		
		a.loadFile("test-files/sample.md");
		assertEquals(a.getRaceList().getRace(0).getResults().size(), 25);
		
		a.newList();
		assertEquals(a.getRaceList().size(), 0);
		
		//creating a race and an associated result//
		LocalDate now = LocalDate.now();
		RaceTime min25 = new RaceTime("0:25:25");

		Race race = new Race("5 mile", 5, now, "Here");
		IndividualResult dubsRes= new IndividualResult(race, "Dubs", 27, min25);
		a.getRaceList().addRace(race);
		race.addIndividualResult(dubsRes);
		
		assertEquals(race.getResults().getResult(0), dubsRes);
		double raceDistance = 2.5;
		race.setDistance(raceDistance);
		assertEquals(race.getResults().getResult(0), dubsRes);
		assertEquals(raceDistance, dubsRes.getRace().getDistance(), .01);
		
		//assertTrue()
		assertTrue(a.isChanged());
		
		a.saveFile("test-files/sample_manager_test.md");

	}
	
	@Test 
	public void testFilenamejunk() {
		WolfResultsManager a = WolfResultsManager.getInstance();
		
		a.loadFile("test-files/sample.md");
		assertEquals(a.getRaceList().getRace(0).getResults().size(), 25);
		
		assertEquals(a.getFilename(), "test-files/sample.md");
		
		a.setFilename("hello");
		
		assertEquals(a.getFilename(), "hello");
	}

}
