package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shiftTimeZone() {
		DateTime timeInSweden = new DateTime(2018,10,2,15,16,30);
		DateTime timeInUSA = TimeZoneTranslator.shiftTimeZone(timeInSweden, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_CENTRAL.getOffset());
		assertEquals(timeInUSA.toString(), "2018-10-02 08:16");
	}
	
	@Test
	public void shiftEventTimeZone() {
		DateTime start = new DateTime(2018,10,3,18,00,00);
		DateTime end = new DateTime(2018,10,3,20,00,00);
		Person viktor = new Person("Viktor Zenk");
		Person martin = new Person("Martin Malmström");
		Person adam = new Person("Adam Håkansson");
		Place myHouse = new Place("Viktor's house",57.792715, 14.138267,170.0);
		Event kalas = new Event("Kalas",start,end,new HashSet<>(Arrays.asList(viktor, martin, adam)),myHouse);
		
		Event kalasShifted = TimeZoneTranslator.shiftEventTimeZone(kalas,TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_CENTRAL);
		
		assertEquals(kalasShifted.getStartDate().toString(), "2018-10-03 11:00");
		assertEquals(kalasShifted.getEndDate().toString(), "2018-10-03 13:00");
	}
	
	@Test
	public void shiftTimeZone2() {
		DateTime timeInSweden = new DateTime(2016,1,1,6,0,0);
		DateTime timeInUSA = TimeZoneTranslator.shiftTimeZone(timeInSweden, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		assertEquals(timeInUSA.toString(), "2015-12-31 21:00");
		
		timeInUSA = new DateTime(2015,12,31,21,0,0);
		timeInSweden = TimeZoneTranslator.shiftTimeZone(timeInUSA, TimeZone.US_PACIFIC.getOffset(), TimeZone.CENTRAL_EUROPEAN_TIME.getOffset());
		assertEquals(timeInSweden.toString(), "2016-01-01 06:00");
	}
}
