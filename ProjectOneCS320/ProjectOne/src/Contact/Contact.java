package Contact;

/*
 * Jessie Smith
 * SNHU
 * CS 320
 * 18 February 2023
 */

public class Contact {
	private static final int CONTACT_ID_LENGTH = 10;
	private static final int FIRST_NAME_LENGTH = 10;
	private static final int LAST_NAME_LENGTH = 10;
	private static final int PHONE_NUM_LENGTH = 10;
	private static final int ADDRESS_LENGTH = 30;
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	// Initializer
	Contact() {
		this.contactId = "EMPTY";
		this.firstName = "EMPTY";
		this.lastName = "EMPTY";
		this.phoneNum = "0000000000";
		this.address = "EMPTY";
	}
	
	Contact(String contactId) {
		setContactId(contactId);
		this.firstName = "EMPTY";
		this.lastName = "EMPTY";
		this.phoneNum = "0000000000";
		this.address = "EMPTY";
	}
	
	Contact (String contactId, String firstName) {
		setContactId(contactId);
		setFirstName(firstName);
		this.lastName = "EMPTY";
		this.phoneNum = "0000000000";
		this.address = "EMPTY";
	}
	
	Contact (String contactId, String firstName, String lastName) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		this.phoneNum = "0000000000";
		this.address = "EMPTY";
	}
	
	Contact (String contactId, String firstName, String lastName, String phoneNum) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		this.address = "EMPTY";
	}
	
	Contact (String contactId, String firstName, String lastName, String phoneNum, String address) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}
	
	
	// Getter functions
	public final String getContactId() {
		return this.contactId;
	}
	
	public final String getFirstName() {
		return this.firstName;
	}
	
	public final String getLastName() {
		return this.lastName;
	}
	
	public final String getPhoneNum() {
		return this.phoneNum;
	}
	
	public final String getAddress() {
		return this.address;
	}
	
	
	// Setter functions
	protected void setContactId(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		else if (contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID cannot be longer than " + CONTACT_ID_LENGTH + " characters.");
		}
		else {
			this.contactId = contactId;
		}
	}
	
	protected void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be null.");
		}
		else if (firstName.length() > FIRST_NAME_LENGTH) {
			throw new IllegalArgumentException("First name cannot be longer than " + FIRST_NAME_LENGTH + " characters.");
		}
		else {
			this.firstName = firstName;
		}
	}
	
	protected void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be null.");
		}
		else if (lastName.length() > LAST_NAME_LENGTH) {
			throw new IllegalArgumentException("Last name cannot be more than " + LAST_NAME_LENGTH + " characters.");
		}
		else {
			this.lastName = lastName;
		}
	}
	
	protected void setPhoneNum(String phoneNum) {
		if (phoneNum == null) {
			throw new IllegalArgumentException("Phone number cannot be null.");
		}
		else if (phoneNum.length() != PHONE_NUM_LENGTH) {
			throw new IllegalArgumentException("Phone number must be exactly " + PHONE_NUM_LENGTH + " digits long.");
		}
		else {
			for (int i = 0; i < PHONE_NUM_LENGTH; i++) {
				if (!Character.isDigit(phoneNum.charAt(i))) {
					throw new IllegalArgumentException("Phone number must only consist of digits.");
				}
			}
			this.phoneNum = phoneNum;
		}
	}
	
	protected void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be null.");
		}
		else if (address.length() > ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address cannot be longer than " + ADDRESS_LENGTH + " characters.");
		}
		else this.address = address;
	}
	
}