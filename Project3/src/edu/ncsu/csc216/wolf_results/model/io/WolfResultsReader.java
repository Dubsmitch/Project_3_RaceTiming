package edu.ncsu.csc216.wolf_results.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_results.race_results.IndividualResult;
import edu.ncsu.csc216.wolf_results.race_results.Race;
import edu.ncsu.csc216.wolf_results.race_results.RaceList;
import edu.ncsu.csc216.wolf_results.util.RaceTime;

/**
 * reads a race file from a specified filename
 * 
 * @author William
 *
 */
public class WolfResultsReader {
	/**
	 * creates a Wolf results Reader 
	 * that can read files and create a raceList
	 * from them
	 */
	public WolfResultsReader() {
		
	}
	/**
	 * reads a file and returns a racelist
	 * @param filename
	 * 		the file name to be read
	 * @return RaceList
	 * 		the races and results from the file 
	 * @throws FileNotFoundException 
	 * 			if the file cannot be found
	 */
	@SuppressWarnings("resource")
	public static RaceList readRaceListFile(String filename) {
		RaceList raceList = new RaceList();
		
		Scanner fileReader;
		try {
			fileReader = new Scanner(new FileInputStream(filename));
			Race currentRace = null;
			while (fileReader.hasNextLine()) {
				
				//System.out.println(fileReader.nextLine());
				//make a line scanner
				Scanner lineReader = new Scanner(fileReader.nextLine());
				//Scanner lineReader2 = null;
				//if the line scanner has a # then the next 4 lines are a race
				String lineReaderNext = null;
	
				if (lineReader.hasNext()) {
					lineReaderNext = lineReader.next();
				} else {
					lineReader = new Scanner(fileReader.nextLine());
					lineReaderNext = lineReader.next();
				}					
				//why is this getting hung?!
				//System.out.println(lineReaderNext);
				//if (!lineReaderNext.equals("#")||!lineReaderNext.equals("*")) {
					//System.out.println("why did this go in here?");
	
					//lineReaderNext = lineReader.next();
				//}
				
				
				if (lineReaderNext.equals("#")) {
					Race race = readRace(lineReader.nextLine(),
							fileReader.nextLine(), 
							fileReader.nextLine(), 
							fileReader.nextLine());
					currentRace = race;
				} else if (lineReaderNext.equals("*")) {
					IndividualResult result = readResult(lineReader.nextLine(), currentRace);
					currentRace.addIndividualResult(result);
					System.out.println(result.toString());
				}
				raceList.addRace(currentRace);
				lineReader.close();
				//lineReader2.close();
				//fileReader.nextLine();
		
			}
		} catch (FileNotFoundException e) {
		}
		//fileReader.close();
		return raceList;
		
	}
	@SuppressWarnings("resource")
	private static IndividualResult readResult(String nextLine, Race currentRace) {
		Scanner scanner = new Scanner (nextLine);
		
		scanner.useDelimiter(",");
		String name = "";
		int age = 0;
		RaceTime time = null;
		
		if (scanner.hasNext()) {
			name = scanner.next();
		} else {
			scanner.close();
			throw new IllegalArgumentException();//Race race, String name, int age, RaceTime time
		}
		if (scanner.hasNext()) {
			age = scanner.nextInt();
		} else {
			scanner.close();
			throw new IllegalArgumentException();
		}
		if (scanner.hasNext()) {
			time = new RaceTime(scanner.next());
		} else {
			throw new IllegalArgumentException();
		}
		
		
		IndividualResult result = new IndividualResult(currentRace, name, age, time);
		scanner.close();
		return result;
	}
	@SuppressWarnings("resource")
	private static Race readRace(String nextLineOne, String nextLineTwo, 
			String nextLineThree, String nextLineFour) {
		String name = "";
		double distance = 0;
		String date = "";
		String location = "";
		Scanner one = new Scanner (nextLineOne);
		Scanner two = new Scanner (nextLineTwo);
		Scanner three = new Scanner (nextLineThree);
		Scanner four = new Scanner (nextLineFour);
		
		if (one.hasNext()) {
			while (one.hasNext()) {
				name = name + " " + one.next();
			}
			name = name.trim();
		} else {
			one.close();
			throw new IllegalArgumentException();
		}
		
		if (two.hasNext()) {
			distance = two.nextDouble();
		} else {
			two.close();
			throw new IllegalArgumentException();
		}
		
		if (three.hasNext()) {
			date = three.next();
		} else {
			three.close();
			throw new IllegalArgumentException();
		}
		if( four.hasNext()) {
			while(four.hasNext()) {
				location = location + " " + four.next();
			}
		} else {
			four.close();
			throw new IllegalArgumentException();
		}
		
		LocalDate localdate = LocalDate.parse(date);
		
		Race race = new Race(name, distance, localdate, location);
		one.close();
		two.close();
		three.close();
		four.close();
		return race;
	}
}
