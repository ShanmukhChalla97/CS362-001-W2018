package calendar;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

    /**
     * Generate Random Tests that tests TimeTable Class.
     */

	 @Test
	  public void test01()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			GregorianCalendar cal = new GregorianCalendar();
			CalDay day = new CalDay(cal);

			LinkedList<Appt> appts = new LinkedList<Appt>();
			TimeTable time = new TimeTable();

			System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 Random random = new Random(randomseed);

				 	int numAppt = ValuesGenerator.getRandomIntBetween(random, 1, 10);

					for (int i = 0; i < numAppt; i++)
					{
						int startHour=ValuesGenerator.RandInt(random);
						int startMinute=ValuesGenerator.RandInt(random);
						int startDay=ValuesGenerator.RandInt(random);;
						int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);

						int startYear=ValuesGenerator.RandInt(random);
						String title="Birthday Party";
						String description="This is my birthday party.";

						//Construct a new Appointment object with the initial data
						Appt appt = new Appt(startHour,
										 startMinute ,
										 startDay ,
										 startMonth ,
										 startYear ,
										 title,
										description);

						appts.add(appt);
					}

				//for (int j = 0; j < numAppt; j++)
				//{
					int rand = ValuesGenerator.getRandomIntBetween(random, 0, numAppt - 1); //index to delete from
					time.deleteAppt(appts, appts.get(0));
				//}
					assertNull(time.deleteAppt(null, null));

					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					 if((iteration%10000)==0 && iteration!=0 )
							System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 } catch(NullPointerException e){

		 }
			System.out.println("Done testing...");

	 }

	 @Test
	 public void test02()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		TimeTable time = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();

		System.out.println("Start testing...");

	 try{
		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startDay= ValuesGenerator.RandInt(random);
				int startMonth= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear= ValuesGenerator.RandInt(random);

				int endDay= ValuesGenerator.RandInt(random);
				int endMonth= ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int endYear= ValuesGenerator.getRandomIntBetween(random, 1980, 2017);

				GregorianCalendar startday = new GregorianCalendar(startYear, startMonth, startDay); //date is before last day
				GregorianCalendar endday = new GregorianCalendar(endYear, endMonth, endDay);

				time.getApptRange(appts, startday, endday);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		 }
	 }catch(NullPointerException e){

	 }

		System.out.println("Done testing...");
	}

	@Test
	public void test03()  throws Throwable  {
	 long startTime = Calendar.getInstance().getTimeInMillis();
	 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

	 GregorianCalendar cal = new GregorianCalendar();
	 CalDay day = new CalDay(cal);
	 TimeTable time = new TimeTable();

	 LinkedList<Appt> appts = new LinkedList<Appt>();

	 System.out.println("Start testing...");

	try{
		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			 long randomseed = System.currentTimeMillis(); //10
			 //			System.out.println(" Seed:"+randomseed );
			 Random random = new Random(randomseed);

			 int starday= ValuesGenerator.getRandomIntBetween(random, 2, 14);
			 int month= ValuesGenerator.getRandomIntBetween(random, 2, 4);
			 int year= ValuesGenerator.getRandomIntBetween(random, 1990, 2012);

			 int endDay= ValuesGenerator.getRandomIntBetween(random, 15, 27);
			 int endMonth= ValuesGenerator.getRandomIntBetween(random, 5, 10);
			 int endYear= ValuesGenerator.getRandomIntBetween(random, 2013, 2017);

			 GregorianCalendar startday = new GregorianCalendar(year, month, starday); //date is before last day
			 GregorianCalendar endday = new GregorianCalendar(endYear, endMonth, endDay);

			 int numAppt = ValuesGenerator.getRandomIntBetween(random, 1, 10);

			 for (int i = 0; i < numAppt; i++)
			 {
				 	int startHour = ValuesGenerator.getRandomIntBetween(random, 2, 22);
	 				int startMinute = ValuesGenerator.getRandomIntBetween(random, 5, 55);
	 				int startDay = ValuesGenerator.getRandomIntBetween(random, 3, 27);
	 				int startMonth = ValuesGenerator.getRandomIntBetween(random, 2, 10);
	 				int startYear = ValuesGenerator.RandInt(random);
	 				String title = "Birthday Party";
	 				String description = "This is my birthday party.";
					Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
					appts.add(appt);
			 }

			 time.getApptRange(appts, startday, endday);

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			 if ((iteration % 10000) == 0 && iteration != 0)
				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		}
	} catch(NullPointerException e){

	}

	 System.out.println("Done testing...");
 }

	 @Test
	 public void test04()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		GregorianCalendar cal = new GregorianCalendar();
		CalDay day = new CalDay(cal);
		TimeTable time = new TimeTable();

		LinkedList<Appt> appts = new LinkedList<Appt>();

		System.out.println("Start testing...");

	 try{
		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				GregorianCalendar startday = new GregorianCalendar(2017, 10, 10);
				GregorianCalendar endday = new GregorianCalendar(2018, 10, 10);

				//int numAppt = ValuesGenerator.getRandomIntBetween(random, 1, 10);

				assertNotEquals(366, time.getApptRange(appts, startday, endday).size());

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		 }
	 } catch(NullPointerException e){

	 }

		System.out.println("Done testing...");
	}

	@Test
	public void test05()  throws Throwable  {
	 long startTime = Calendar.getInstance().getTimeInMillis();
	 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

	 GregorianCalendar cal = new GregorianCalendar();
	 CalDay day = new CalDay(cal);
	 TimeTable time = new TimeTable();

	 LinkedList<Appt> appts = new LinkedList<Appt>();

	 System.out.println("Start testing...");

	try{
		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			 long randomseed = System.currentTimeMillis(); //10
			 //			System.out.println(" Seed:"+randomseed );
			 Random random = new Random(randomseed);

		 	GregorianCalendar startday = new GregorianCalendar(2017, 10, 10);
		 	GregorianCalendar endday = new GregorianCalendar(2017, 10, 11);

		 	assertEquals(1, time.getApptRange(appts, startday, endday).size());

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			 if ((iteration % 10000) == 0 && iteration != 0)
				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		}
	} catch(NullPointerException e){

	}

	 System.out.println("Done testing...");
 }

}
