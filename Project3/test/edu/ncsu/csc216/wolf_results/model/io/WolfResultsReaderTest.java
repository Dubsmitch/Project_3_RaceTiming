package edu.ncsu.csc216.wolf_results.model.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.race_results.RaceList;
/**
 * tests the class that reads files
 * 
 * @author William
 *
 */
public class WolfResultsReaderTest {
	/**
	 * tests reading a file
	 */
	@Test
	public void test() {
		
			
		RaceList list = WolfResultsReader.readRaceListFile("test-files/sample.md");
		assertEquals(list.getRace(0).getResults().size(), 25);
		assertEquals(list.getRace(1).getResults().size(), 10);
			
		RaceList list2 = WolfResultsReader.readRaceListFile("test-files/not_a_file.md");
		
		
	}

}
