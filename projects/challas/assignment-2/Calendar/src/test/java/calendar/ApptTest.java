package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 Appt appt = new Appt(21, 30 , 28 , 11 , 2017 , "Homework", "Homework due");

		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(28, appt.getStartDay());
		 assertEquals(11, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Homework", appt.getTitle());
		 assertEquals("Homework due", appt.getDescription());
	 }

	 @Test
	  public void test02()  throws Throwable  {
			Appt appt = new Appt(21, 30 , 28 , 11 , 2017 , "Homework", "Homework due");

			appt.setRecurrence(null, 5, 5, 5);

			int test = appt.getRecurNumber();
			assertEquals(test, 5);

			int test2 = appt.getRecurBy();
			assertEquals(test2, 5);

			int[] recurrenceTest = appt.getRecurDays();

	 }

	 @Test
	  public void test03()  throws Throwable  {
				Appt appt = new Appt(21, 30 , 28 , 11 , 2017 , "Homework", "Homework due");

				appt.setStartHour(21);
				appt.setStartMinute(30);
				appt.setStartDay(28);
				appt.setStartMonth(11);
				appt.setStartYear(2017);
				appt.setTitle("Homework");
				appt.setDescription("Homework due");

				assertEquals(21, appt.getStartHour());
				assertEquals(30, appt.getStartMinute());
				assertEquals(28, appt.getStartDay());
				assertEquals(11, appt.getStartMonth());
				assertEquals(2017, appt.getStartYear());
				assertEquals("Homework", appt.getTitle());
				assertEquals("Homework due", appt.getDescription());

	 }

	 @Test
	  public void test04()  throws Throwable  {
			Appt appt = new Appt(21 , 30 , 28 , 11 , 2017 , "Homework", "Homework due");

			String representation = appt.toString();

			assertTrue(appt.getValid());
			assertEquals(representation, "\t11/28/2017 at 9:30pm ,Homework, Homework due\n");

			// Check compareTo() method
			assertEquals(0, appt.compareTo(appt)); // Verifies that the events are the same

	 }

}
