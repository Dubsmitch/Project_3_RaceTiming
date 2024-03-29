package edu.ncsu.csc216.wolf_results.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import edu.ncsu.csc216.wolf_results.race_results.RaceList;
/**
 * A helper class that saves the race results to a file
 * 
 * @author William
 *
 */
public class WolfResultsWriter {

	/**
	 * writes a face file with a given file name and list
	 * @param filename
	 * 		the file name to save to
	 * @param list
	 * 		the list to be saved
	 *
	 */
	public static void writeRaceFile(String filename, RaceList list) {
		try {
			PrintStream fileWriter = new PrintStream (new File(filename));

			for (int i = 0; i < list.size(); i++) {
				fileWriter.println("# " + list.getRace(i).getName());
				fileWriter.println(list.getRace(i).getDistance());
				fileWriter.println(list.getRace(i).getDate().toString());
				fileWriter.println(list.getRace(i).getLocation());
				fileWriter.println();
				int index = 0;
		
				for (int j = 0; j < list.getRace(i).getResults().size(); j++) {
					fileWriter.print("* " + list.getRace(i).getResults().getResult(index).getName() + ",");
					fileWriter.print(list.getRace(i).getResults().getResult(index).getAge() + ",");
					fileWriter.println(list.getRace(i).getResults().getResult(index).getTime().toString());
					index++;
				}
				fileWriter.println();
		
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException ();
		}
	}
}
