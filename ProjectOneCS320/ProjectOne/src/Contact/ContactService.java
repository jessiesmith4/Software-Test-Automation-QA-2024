package Contact;

/*
 * Jessie Smith
 * SNHU
 * CS 320
 * 18 February 2023
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	private String uniqueId;
	private List<Contact> contacts = new ArrayList<>();
	
	
	// Creates uniqueId
	private String newUniqueId() {
		uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return uniqueId;
	}
	
	
	// Creates new contacts
	public void newContact() {
		Contact contact = new Contact(newUniqueId());
		contacts.add(contact);
	}
	
	public void newContact(String firstName) {
		Contact contact = new Contact(newUniqueId(), firstName);
		contacts.add(contact);
	}
	
	public void newContact(String firstName, String lastName) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName);
		contacts.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String phoneNum) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNum);
		contacts.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String phoneNum, String address) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNum, address);
		contacts.add(contact);
	}
	
	// Searches contacts list
	private Contact getContact(String contactId) throws Exception {
		for (int i = 0; i < contacts.size(); i++) {
			if (contactId.equals(contacts.get(i).getContactId())) {
				return contacts.get(i);
			}
		}
		throw new Exception("Contact ID does not exist");
	}
	
	
	// Updates variables
	protected void updateFirstName(String contactId, String firstName) throws Exception {
		getContact(contactId).setFirstName(firstName);
	}
	
	protected void updateLastName(String contactId, String lastName) throws Exception {
		getContact(contactId).setLastName(lastName);
	}
	
	protected void updatePhoneNum(String contactId, String phoneNum) throws Exception {
		getContact(contactId).setPhoneNum(phoneNum);
	}
	
	protected void updateAddress(String contactId, String address) throws Exception {
		getContact(contactId).setAddress(address);
	}
	
	
	// Returns contacts list
	protected List<Contact> getContacts() {return contacts;}
	
	
	// Deletes contact
	protected void deleteContact(String contactId) throws Exception {
		contacts.remove(getContact(contactId));
	}
}