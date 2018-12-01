package edu.ncsu.csc216.wolf_results.util;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * tests the raceTime class
 * @author William
 *
 */
public class RaceTimeTest {
	/**
	 * tests the constructor
	 */
	@Test
	public void testConstructor() {
		@SuppressWarnings("unused")
		RaceTime a = new RaceTime("10:10:10");
		@SuppressWarnings("unused")
		RaceTime b = new RaceTime("0:10:10");
		@SuppressWarnings("unused")
		RaceTime c = new RaceTime("10:05:10");
		@SuppressWarnings("unused")
		RaceTime d = new RaceTime("10:10:05");
		
		assertEquals(d.getHours(), 10);
		assertEquals(d.getMinutes(), 10);
		assertEquals(d.getSeconds(), 5);



		try {
			@SuppressWarnings("unused")

			RaceTime e = new RaceTime("0:60:10");
			fail("");
		} catch (IllegalArgumentException e) {
			assertEquals(d.getHours(), 10);

		}
		
		try {
			@SuppressWarnings("unused")

			RaceTime e = new RaceTime("-1:59:10");
			fail("");
		} catch (IllegalArgumentException e) {
			assertEquals(d.getHours(), 10);

		}
		
		try {
			@SuppressWarnings("unused")

			RaceTime e = new RaceTime("0:-59:10");
			fail("");
		} catch (IllegalArgumentException e) {
			assertEquals(d.getHours(), 10);

		}
		try {
			@SuppressWarnings("unused")

			RaceTime e = new RaceTime("0:59:-10");
			fail("");
		} catch (IllegalArgumentException e) {
			assertEquals(d.getHours(), 10);

		}
		try {
			@SuppressWarnings("unused")

			RaceTime e = new RaceTime("0:59:");
			fail("");
		} catch (IllegalArgumentException e) {
			assertEquals(d.getHours(), 10);

		}
		try {
			@SuppressWarnings("unused")
			RaceTime e = new RaceTime("0::10");
			fail("");
		} catch (IllegalArgumentException e) {
			assertEquals(d.getHours(), 10);

		}
	}
	/**
	 * tests the to seconds method
	 */
	@Test
	public void testToSeconds() {
		RaceTime toseconds = new RaceTime("3:48:24");
		assertEquals(toseconds.getTimeInSeconds(), 13704);
	}
	/**
	 * tests the to string method
	 */
	@Test
	public void testToString() {
		RaceTime a = new RaceTime("3:48:24");
		String aString = "3:48:24";
		assertEquals(a.toString(), aString);
		
		RaceTime b = new RaceTime("3:08:24");
		String bString = "3:08:24";
		assertEquals(b.toString(), bString);
		
		RaceTime c = new RaceTime("3:48:04");
		String cString = "3:48:04";
		assertEquals(c.toString(), cString);
		
	}
	/**
	 * tests the compare to method
	 */
	@Test
	public void testCompareTo() {
		RaceTime a = new RaceTime("3:48:24");
		
		RaceTime b = new RaceTime("3:47:24");
		
		RaceTime c = new RaceTime("3:47:04");
		
		assertEquals(c.compareTo(c), 0);
		assertEquals(a.compareTo(b), 1);
		assertEquals(c.compareTo(a), -1);
	}
}
