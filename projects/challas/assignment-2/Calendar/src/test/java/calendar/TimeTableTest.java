package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
			TimeTable time = new TimeTable();

			Appt appt1 = new Appt(21 , 30 , 28 , 11 , 2017 , "Homework", "Homework due");
			Appt appt2 = new Appt(21 , 30 , 29 , 11 , 2017 , "Homework", "Homework due");

			LinkedList<Appt> appts = new LinkedList<Appt>();
			appts.add(appt1);
			appts.add(appt2);

			//assertNotNull(time.deleteAppt(appts, appt1));
			assertNull(time.deleteAppt(null, null));

			int[] pv = {0,1};
			assertNotNull(time.permute(appts, pv));

	 }

	 @Test
	  public void test02()  throws Throwable  {
		/*
			LinkedList<Appt> appts = new LinkedList<Appt>();
			GregorianCalendar firstDay = new GregorianCalendar(2017, 05, 16);
			GregorianCalendar lastDay = new GregorianCalendar(2017, 05, 19);

			assertEquals(3, getApptRange(appts, firstDay, lastDay));
		*/
	 }

	 @Test
	  public void test03()  throws Throwable  {
		 GregorianCalendar today = new GregorianCalendar(2017, 11 ,28);
		 GregorianCalendar nextDay = new GregorianCalendar(2017, 11 , 29);
		 CalDay calendarDay = new CalDay(today);
		 CalDay calendarDay2 = new CalDay(nextDay);
		 assertTrue(calendarDay.isValid());

		 LinkedList<Appt> appts = new LinkedList<Appt>();

		 Appt appt = new Appt(21, 30 , 28 , 11 , 2017 , "Homework", "Homework due");
		 assertTrue(appt.getValid());
		 appts.add(appt);

		 Appt appt2 = new Appt(7, 30 , 28 , 11 , 2017 , "Homework", "Homework due");
		 appts.add(appt2);

	 	 TimeTable timetable = new TimeTable();
		 LinkedList<CalDay> days = new LinkedList<CalDay>();
		 days = new LinkedList<CalDay>();

		 assertTrue(days.isEmpty());

		 days = timetable.getApptRange(appts, today, nextDay);
		 assertFalse(days.isEmpty());

		 LinkedList<Appt> deletedAppt = new LinkedList<Appt>();
		 assertTrue(deletedAppt.isEmpty());
		 deletedAppt = timetable.deleteAppt(appts, appts.get(0));
	}
//add more unit tests as you needed
}
