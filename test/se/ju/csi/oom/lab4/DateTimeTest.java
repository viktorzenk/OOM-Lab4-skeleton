package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void stringTest() {
		DateTime date1 = new DateTime(2018,10,3,11,0,0);
		assertEquals(date1.toString(),"2018-10-03 11:00");
		
		DateTime date2 = new DateTime("2018-10-03 12:00:00");
		DateTime date3 = new DateTime(2018,10,3,12,0,0);
		assertEquals(date2.toString(),date3.toString());
	}

}
