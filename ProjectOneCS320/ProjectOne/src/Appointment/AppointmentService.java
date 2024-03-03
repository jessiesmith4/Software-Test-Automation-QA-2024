package Appointment;

/*
 * Jessie Smith
 * SNHU
 * CS 320
 * 18 February 2023
 */

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AppointmentService
{
	private String uniqueId;
	private List<Appointment> appointments = new ArrayList<>();
	
	
	// Creates uniqueId
	private String newUniqueId() 
	{
		uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return uniqueId;
	}
	
	
	// Creates new appointments:
	public void newAppointment()
	{
		Appointment appointment = new Appointment(newUniqueId());
		appointments.add(appointment);
	}
	
	public void newAppointment(Date date)
	{
		Appointment appointment = new Appointment(newUniqueId(), date);
		appointments.add(appointment);
	}
	
	public void newAppointment(Date date, String desc)
	{
		Appointment appointment = new Appointment(newUniqueId(), date, desc);
		appointments.add(appointment);
	}
	
	
	// Searches appointments
	private Appointment getAppointment(String ID) throws Exception
	{
		for (int i = 0; i < appointments.size(); i++)
		{
			if(ID.equals(appointments.get(i).getAppointmentId()))
				return appointments.get(i);
		}
		throw new Exception("Appointment ID " + ID + " does not exist.");
	}
	
	
	// Update functions
	protected void updateDate(String ID, Date date) throws Exception { getAppointment(ID).setDate(date); }
	
	protected void updateDescription(String ID, String desc) throws Exception { getAppointment(ID).setDescription(desc); }
	
	
	// Returns appointments list
	protected List<Appointment> getAppointments() { return appointments; }
}

