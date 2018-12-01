package edu.ncsu.csc216.wolf_results.model.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc216.wolf_results.race_results.RaceList;

public class WolfResultsWriterTest {

	@Test
	public void test() {
		try {
			
			RaceList list = WolfResultsReader.readRaceListFile("test-files/sample.md");
			assertEquals(list.getRace(0).getResults().size(), 25);
			assertEquals(list.getRace(1).getResults().size(), 10);
			
			//WolfResultsWriter thing = new WolfResultsWriter();
			WolfResultsWriter.writeRaceFile("test-files/sample_test.md", list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

}
