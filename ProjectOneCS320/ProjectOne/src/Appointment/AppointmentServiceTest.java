package Appointment;

/*
 * Jessie Smith
 * SNHU
 * CS 320
 * 18 February 2023
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest
{
	protected String idTest, descTest;
	protected Date dateTest;
	protected String idFail, descFail;
	protected Date dateFail;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() 
	{
		idTest = "1234567890"; // This ID is within the 10 char limit
		descTest = "This is within the 50 char limit."; // Desc within 50 char limit
		dateTest = new Date(2077, Calendar.NOVEMBER, 9);
		idFail = "12345678901234567890"; // This ID is too long
		descFail = "This is way too long to be the description of an Appointment Object"; // This description is too long
		dateFail = new Date(0);
	}
	
	
	// Each of the following test the newAppointment functions in AppointmentService.java
	@Test
	void newAppointmentTest()
	{
		AppointmentService appt = new AppointmentService();
		appt.newAppointment();
		Date date = new Date();
		assertAll("newAppointment test",
				() -> assertNotNull(appt.getAppointments().get(0).getAppointmentId()),
				() -> assertEquals(appt.getAppointments().get(0).getAppointmentDate(), date),
				() -> assertEquals(appt.getAppointments().get(0).getDescription(), "EMPTY")
				);
	}
	
	@Test
	void newAppointmentTest2()
	{
		AppointmentService appt = new AppointmentService();
		appt.newAppointment(dateTest);
		assertAll("newAppointment test2",
				() -> assertNotNull(appt.getAppointments().get(0).getAppointmentId()),
				() -> assertEquals(appt.getAppointments().get(0).getAppointmentDate(), dateTest),
				() -> assertEquals(appt.getAppointments().get(0).getDescription(), "EMPTY")
				);
	}
	
	@Test
	void newAppointmentTest3()
	{
		AppointmentService appt = new AppointmentService();
		appt.newAppointment(dateTest, descTest);
		assertAll("newAppointment test3",
				() -> assertNotNull(appt.getAppointments().get(0).getAppointmentId()),
				() -> assertEquals(appt.getAppointments().get(0).getAppointmentDate(), dateTest),
				() -> assertEquals(appt.getAppointments().get(0).getDescription(), descTest)
				);
	}
	
	
	// Each of the following tests the update functions from
	// AppointmentService.java, they are tested to ensure they update 
	// the required variables, and that they throw exceptions 
	// when using a null or invalid string
	
	// This tests the updateDate function
	@Test
	void updateDateTest() throws Exception
	{
		AppointmentService appt= new AppointmentService();
		appt.newAppointment();
		appt.updateDate(appt.getAppointments().get(0).getAppointmentId(), dateTest);
		assertAll("updateDate test",
				() -> assertEquals(appt.getAppointments().get(0).getAppointmentDate(), dateTest),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.updateDate(appt.getAppointments().get(0).getAppointmentId(), null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.updateDate(appt.getAppointments().get(0).getAppointmentId(), dateFail))
				);
	}
	
	// This tests the updateDescription function
	@Test
	void updateDescriptionTest() throws Exception
	{
		AppointmentService appt = new AppointmentService();
		appt.newAppointment();
		appt.updateDescription(appt.getAppointments().get(0).getAppointmentId(), descTest);
		assertAll("updateDescription test",
				() -> assertEquals(appt.getAppointments().get(0).getDescription(), descTest),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.updateDescription(appt.getAppointments().get(0).getAppointmentId(), null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.updateDescription(appt.getAppointments().get(0).getAppointmentId(), descFail))
				);
	}
}