package Contact;

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


public class ContactTest {
	protected String contactIdTest, firstNameTest, lastNameTest, phoneNumTest, addressTest;
	protected String failContactId, failFirstName, failLastName, failPhoneNum, failAddress;
	
	@BeforeEach
	void setUp() {
		contactIdTest = "10987ui98l"; // contactId with 10 char limit
		firstNameTest = "Jess"; // firstName within 10 char limit
		lastNameTest = "Bass"; // lastName within 10 char limit
		phoneNumTest = "1234567890"; // phoneNum is exactly 10 digits
		addressTest = "1 Street, City, State, Zip"; // address within 30 char limit
		failContactId = "12345678901234567890"; // This contactId is too long
		failFirstName = "This is way too long";
		failLastName = "This is also too long";
		failPhoneNum = "1234567890jess";
		failAddress = "This is longer than 30 characters for certain";
	}
	
	// Each of the following test the constructors in Contact.java
	@Test
	void contactTest() {
		Contact contact = new Contact();
		assertAll("Constructor",
			() -> assertNotNull(contact.getContactId()),
			() -> assertNotNull(contact.getFirstName()),
			() -> assertNotNull(contact.getLastName()),
			() -> assertNotNull(contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void Constructor1Test() {
		Contact contact = new Contact(contactIdTest);
		assertAll("Constructor 1",
			() -> assertEquals(contactIdTest, contact.getContactId()),
			() -> assertNotNull(contact.getFirstName()),
			() -> assertNotNull(contact.getLastName()),
			() -> assertNotNull(contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void Constructor2Test() {
		Contact contact = new Contact(contactIdTest, firstNameTest);
		assertAll("Constructor 2",
			() -> assertEquals(contactIdTest, contact.getContactId()),
			() -> assertEquals(firstNameTest, contact.getFirstName()),
			() -> assertNotNull(contact.getLastName()),
			() -> assertNotNull(contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void Constructor3Test() {
		Contact contact = new Contact(contactIdTest, firstNameTest, lastNameTest);
		assertAll("Constructor 3",
		() -> assertEquals(contactIdTest, contact.getContactId()),
		() -> assertEquals(firstNameTest, contact.getFirstName()),
		() -> assertEquals(lastNameTest, contact.getLastName()),
		() -> assertNotNull(contact.getPhoneNum()),
		() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void Constructor4Test() {
		Contact contact = new Contact(contactIdTest, firstNameTest, lastNameTest, phoneNumTest);
		assertAll("Constructor 4",
		() -> assertEquals(contactIdTest, contact.getContactId()),
		() -> assertEquals(firstNameTest, contact.getFirstName()),
		() -> assertEquals(lastNameTest, contact.getLastName()),
		() -> assertEquals(phoneNumTest, contact.getPhoneNum()),
		() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void Constructor5Test() {
		Contact contact = new Contact(contactIdTest, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("Constructor 5",
		() -> assertEquals(contactIdTest, contact.getContactId()),
		() -> assertEquals(firstNameTest, contact.getFirstName()),
		() -> assertEquals(lastNameTest, contact.getLastName()),
		() -> assertEquals(phoneNumTest, contact.getPhoneNum()),
		() -> assertEquals(addressTest, contact.getAddress()));
	}
	
	// Each of the following test the set functions in Contact.java
	// They each insure that variables that are set, equal the correct value,
	// and that null or invalid entries throw exceptions
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstNameTest);
		assertAll("First name",
			() -> assertEquals(firstNameTest, contact.getFirstName()),
			() -> assertThrows(IllegalArgumentException.class,
					() -> contact.setFirstName(null)),
			() -> assertThrows(IllegalArgumentException.class,
			 		() -> contact.setFirstName(failFirstName)));
	}
	
	@Test
	void setLastNameTest() {
		Contact contact = new Contact();
		contact.setLastName(lastNameTest);
		assertAll("Last name",
			() -> assertEquals(lastNameTest, contact.getLastName()),
			() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setLastName(null)),
			() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setLastName(failLastName)));
	}
	
	@Test
	void setPhoneNumTest() {
		Contact contact = new Contact();
		contact.setPhoneNum(phoneNumTest);
		assertAll("Phone number",
			() -> assertEquals(phoneNumTest, contact.getPhoneNum()),
			() -> assertThrows(IllegalArgumentException.class,
						() -> contact.setPhoneNum(null)),
			() ->assertThrows(IllegalArgumentException.class,
						() -> contact.setPhoneNum(failPhoneNum)));
	}
	
	@Test
	void setAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(addressTest);
		assertAll("Address test",
			() -> assertEquals(addressTest, contact.getAddress()),
			() -> assertThrows(IllegalArgumentException.class,
					() -> contact.setAddress(null)),
			() -> assertThrows(IllegalArgumentException.class,
					() -> contact.setAddress(failAddress)));
				
	}
	
}
