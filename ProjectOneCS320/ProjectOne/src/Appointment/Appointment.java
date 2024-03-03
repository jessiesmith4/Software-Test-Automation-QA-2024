package Appointment;

/*
 * Jessie Smith
 * SNHU
 * CS 320
 * 18 February 2023
 */

import java.util.Date;

public class Appointment 
{
	private String appointmentId;
	private Date appointmentDate;
	private String description;
	private static final int ID_LENGTH = 10;
	private static final int DESC_LENGTH = 50;
	
	
	// Constructors;
	Appointment() 
	{
		Date date = new Date();
		this.appointmentId = "EMPTY";
		this.appointmentDate = date;
		this.description = "EMPTY";
	}
	
	Appointment(String ID)
	{
		Date date = new Date();
		setAppointmentId(ID);
		this.appointmentDate = date;
		this.description = "EMPTY";
	}
	
	Appointment(String ID, Date date)
	{
		setAppointmentId(ID);
		setDate(date);
		this.description = "EMPTY";
	}
	
	Appointment(String ID, Date date, String desc)
	{
		setAppointmentId(ID);
		setDate(date);
		setDescription(desc);
	}
	
	
	// Getters
	public final String getAppointmentId() { return this.appointmentId; }
	
	public final Date getAppointmentDate() { return this.appointmentDate; }
	
	public final String getDescription() { return this.description; }
	
	
	// Setters
	protected void setAppointmentId(String ID)
	{
		if (ID == null)
			throw new IllegalArgumentException("Appointment ID cannot be null.");
		else if (ID.length() > ID_LENGTH)
			throw new IllegalArgumentException("Appointment ID cannot be longer than " + ID_LENGTH + " characters.");
		else 
			this.appointmentId = ID;
	}
	
	protected void setDate(Date date)
	{
		if (date == null)
			throw new IllegalArgumentException("Date cannot be null.");
		else if (date.before(new Date()))
			throw new IllegalArgumentException("Date cannot be in the past.");
		else
			this.appointmentDate = date;
	}
	
	protected void setDescription(String desc)
	{
		if (desc == null)
			throw new IllegalArgumentException("Description cannot be null.");
		else if (desc.length() > DESC_LENGTH)
			throw new IllegalArgumentException("Description cannot be longer than " + DESC_LENGTH + " characters.");
		else 
			this.description = desc;
	}
}
