package edu.ncsu.csc216.wolf_results.model.io;

import static org.junit.Assert.*;
 
import org.junit.Test;

import edu.ncsu.csc216.wolf_results.race_results.RaceList;
/**
 * tests the class that writes a file
 * @author William
 *
 */
public class WolfResultsWriterTest {
	/**
	 * tests writing a file
	 */
	@Test
	public void test() {
			
			RaceList list = WolfResultsReader.readRaceListFile("test-files/sample.md");
			assertEquals(list.getRace(0).getResults().size(), 25);
			assertEquals(list.getRace(1).getResults().size(), 10);
			assertEquals(list.getRace(0).getResults().getResult(7).getName(), "ANDREW FISHER");
			
			//WolfResultsWriter thing = new WolfResultsWriter();
			WolfResultsWriter.writeRaceFile("test-files/sample_test.md", list);
		
		
		
	}

}
