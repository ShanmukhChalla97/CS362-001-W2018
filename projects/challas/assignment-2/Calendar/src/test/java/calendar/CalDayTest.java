package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
				GregorianCalendar gc = new GregorianCalendar(2017, 11, 28);
				CalDay cd = new CalDay(gc);
				cd.toString();
				assertEquals(2017, cd.getYear());
				assertEquals(11, cd.getMonth());
				assertEquals(28, cd.getDay());

	 }
	 @Test
	  public void test02()  throws Throwable  {

			 Appt appt = new Appt(21 , 30 , 28 , 11 , 2017 , "Homework", "Homework due");
			 assertTrue(appt.getValid());

	 }
	 @Test
	 public void test03()  throws Throwable  {
		 /*
		  GregorianCalendar gc = new GregorianCalendar(2017, 11, 28);
			CalDay cd = new CalDay(gc);

			String testDate = cd.toString();

			assertEquals(testDate, "11/28/2017");
		 */
	}

	@Test
	public void test04()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2017 , 11, 28);
		CalDay calendarDay = new CalDay(today);
		assertTrue(calendarDay.isValid());

		Appt appt = new Appt(21 , 30 , 28 , 11 , 2017 , "Homework", "Homework due");

		calendarDay.addAppt(appt);
		assertTrue(calendarDay.isValid());
		calendarDay.toString();

		appt.setStartHour(7);
		assertTrue(appt.getValid());
		calendarDay.addAppt(appt);
		assertTrue(calendarDay.isValid());

		appt.setStartHour(23);
		assertTrue(appt.getValid());
		calendarDay.addAppt(appt);
		assertTrue(calendarDay.isValid());

		assertEquals(3, calendarDay.getSizeAppts());
		assertEquals(28, calendarDay.getDay());
		assertEquals(11, calendarDay.getMonth());
		assertEquals(2017, calendarDay.getYear());

	}
//add more unit tests as you needed
}
