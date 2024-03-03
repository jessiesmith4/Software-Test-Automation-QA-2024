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

public class AppointmentTest
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
	
	
	// Constructor tests
	@Test
	void appointmentTest()
	{
		Appointment appt = new Appointment();
		assertAll("Constructor",
				() -> assertNotNull(appt.getAppointmentId()),
				() -> assertNotNull(appt.getAppointmentDate()),
				() -> assertNotNull(appt.getDescription())
				);
	}
	
	@Test
	void appointmentTest2()
	{
		Appointment appt = new Appointment(idTest);
		assertAll("Constructor 2",
				() -> assertEquals(appt.getAppointmentId(), idTest),
				() -> assertNotNull(appt.getAppointmentDate()),
				() -> assertNotNull(appt.getDescription())
				);
	}
	
	@Test
	void appointmentTest3()
	{
		Appointment appt = new Appointment(idTest, dateTest);
		assertAll("Constructor 3",
				() -> assertEquals(appt.getAppointmentId(), idTest),
				() -> assertEquals(appt.getAppointmentDate(), dateTest),
				() -> assertNotNull(appt.getDescription())
				);
	}
	
	@Test
	void appointmentTest4()
	{
		Appointment appt = new Appointment(idTest, dateTest, descTest);
		assertAll("Constructor 4",
				() -> assertEquals(appt.getAppointmentId(), idTest),
				() -> assertEquals(appt.getAppointmentDate(), dateTest),
				() -> assertEquals(appt.getDescription(), descTest)
				);
	}
	
	
	// Each of the following test the setter functions in Appointment.java
	// They each insure that variables that are set, equal the correct value,
	// and that null or invalid entries throw exceptions
	@Test
	void setAppointmentIdTest()
	{
		Appointment appt = new Appointment();
		appt.setAppointmentId(idTest);
		assertAll("setAppointmentId test",
				() -> assertEquals(appt.getAppointmentId(), idTest),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.setAppointmentId(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.setAppointmentId(idFail))
				);
	}
	
	@Test
	void setDateTest()
	{
		Appointment appt = new Appointment();
		appt.setDate(dateTest);
		assertAll("setDate test",
				() -> assertEquals(appt.getAppointmentDate(), dateTest),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.setDate(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.setDate(dateFail))
				);
	}
	
	@Test 
	void setDescriptionTest()
	{
		Appointment appt = new Appointment();
		appt.setDescription(descTest);
		assertAll("setDescription test",
				() -> assertEquals(appt.getDescription(), descTest),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.setDescription(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> appt.setDescription(descFail))
				);
				
	}
}