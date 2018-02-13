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
			GregorianCalendar today = new GregorianCalendar(2017, 11 ,28);
			GregorianCalendar nextDay = new GregorianCalendar(2017, 11 , 29);

			Appt appt1 = new Appt(21 , 30 , 28 , 11 , 2017 , "Homework", "Homework due");
			Appt appt2 = new Appt(21 , 30 , 29 , 11 , 2017 , "Homework", "Homework due");
			Appt appt3 = new Appt(21 , 30 , 29 , 11 , 2017 , "Homework", "Homework due");

			LinkedList<Appt> appts = new LinkedList<Appt>();
			appts.add(appt1);

			appt3.setStartHour(24);
			assertFalse(appt3.getValid());
			assertNull(time.deleteAppt(appts, appt3));

			int[] recurArray = {0,1};

			appt2.setRecurrence(recurArray, 1, 3, 2);
			appts.add(appt2);

			assertNotNull(time.getApptRange(appts, today, nextDay));
			assertEquals(1, time.getApptRange(appts, today, nextDay).get(0).getSizeAppts());

			//assertNotNull(time.deleteAppt(appts, appt1));
			assertNull(time.deleteAppt(null, null));

			int[] pv = {0,1};
			assertNotNull(time.permute(appts, pv));

	 }

	 @Test
	  public void test02()  throws Throwable  {

			LinkedList<Appt> appts = new LinkedList<Appt>();
			TimeTable timetable = new TimeTable();
			GregorianCalendar firstDay = new GregorianCalendar(2017, 05, 16);
			GregorianCalendar lastDay = new GregorianCalendar(2017, 05, 19);

			assertNotNull(timetable.getApptRange(appts, firstDay, lastDay));

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

		 assertNull(timetable.deleteAppt(appts, null));
		 assertNull(timetable.deleteAppt(null, appt));

		 assertNotNull(timetable.getApptRange(appts, today, nextDay));
 	 	 assertEquals(2, timetable.getApptRange(appts, today, nextDay).get(0).getSizeAppts());
		 assertNotNull(timetable.getApptRange(appts, today, nextDay).get(0).getAppts());
		 assertEquals(1, timetable.getApptRange(appts, today, nextDay).size());
 	}

	@Test
	 public void test04()  throws Throwable  {
		 //LinkedList<Appt> appts = new LinkedList<Appt>();
		 //TimeTable timetable = new TimeTable();

		 //Appt appt = new Appt(21, 30 , 12 , 02 , 2018 , "Homework", "Homework due");

		 //int[] recurDays = {2, 4, 6};
		 //assertFalse(recurDays.isEmpty());

		 //assertNotNull(timetable.getApptRange(appts, firstDay, lastDay));

	}
//add more unit tests as you needed
}
