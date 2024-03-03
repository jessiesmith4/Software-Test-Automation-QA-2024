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



public class ContactServiceTest {
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
	
	// Each of these test the new contact methods
	@Test 
	void newContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll("New contact",
			() -> assertNotNull(service.getContacts().get(0).getContactId()),
			() -> assertEquals("EMPTY", service.getContacts().get(0).getFirstName()),
			() -> assertEquals("EMPTY", service.getContacts().get(0).getLastName()),
			() -> assertEquals("0000000000", service.getContacts().get(0).getPhoneNum()),
			() -> assertEquals("EMPTY", service.getContacts().get(0).getAddress()));
			
	}
	
	@Test 
	void newContactTest2() {
		ContactService service = new ContactService();
		service.newContact(firstNameTest);
		assertAll("New contact 2",
			() -> assertNotNull(service.getContacts().get(0).getContactId()),
			() -> assertEquals(firstNameTest, service.getContacts().get(0).getFirstName()),
			() -> assertEquals("EMPTY", service.getContacts().get(0).getLastName()),
			() -> assertEquals("0000000000", service.getContacts().get(0).getPhoneNum()),
			() -> assertEquals("EMPTY", service.getContacts().get(0).getAddress()));
	}
	
	@Test 
	void newContactTest3() {
		ContactService service = new ContactService();
		service.newContact(firstNameTest, lastNameTest);
		assertAll("New contact 3",
			() -> assertNotNull(service.getContacts().get(0).getContactId()),
			() -> assertEquals(firstNameTest, service.getContacts().get(0).getFirstName()),
			() -> assertEquals(lastNameTest, service.getContacts().get(0).getLastName()),
			() -> assertEquals("0000000000", service.getContacts().get(0).getPhoneNum()),
			() -> assertEquals("EMPTY", service.getContacts().get(0).getAddress()));
			
	}
	
	@Test 
	void newContactTest4() {
		ContactService service = new ContactService();
		service.newContact(firstNameTest, lastNameTest, phoneNumTest);
		assertAll("New contact 4",
			() -> assertNotNull(service.getContacts().get(0).getContactId()),
			() -> assertEquals(firstNameTest, service.getContacts().get(0).getFirstName()),
			() -> assertEquals(lastNameTest, service.getContacts().get(0).getLastName()),
			() -> assertEquals(phoneNumTest, service.getContacts().get(0).getPhoneNum()),
			() -> assertEquals("EMPTY", service.getContacts().get(0).getAddress()));
			
	}
	
	@Test 
	void newContactTest5() {
		ContactService service = new ContactService();
		service.newContact(firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("New contact 5",
			() -> assertNotNull(service.getContacts().get(0).getContactId()),
			() -> assertEquals(firstNameTest, service.getContacts().get(0).getFirstName()),
			() -> assertEquals(lastNameTest, service.getContacts().get(0).getLastName()),
			() -> assertEquals(phoneNumTest, service.getContacts().get(0).getPhoneNum()),
			() -> assertEquals(addressTest, service.getContacts().get(0).getAddress()));
			
	}
	
	// Each of the following tests test functions from ContactService.java
	// They are tested to ensure they update the required variables, and
	// that they throw exceptions when using a null or invalid string
	
	// This tests the updateFirstName function
	@Test
	void updateFirstNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateFirstName(service.getContacts().get(0).getContactId(), firstNameTest);
		assertEquals(firstNameTest, service.getContacts().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateFirstName(service.getContacts().get(0).getContactId(), null));
		assertThrows(IllegalArgumentException.class,
				() -> service.updateFirstName(service.getContacts().get(0).getContactId(), failFirstName));
	}
	
	// This tests the updatelastName function
	@Test
	void updateLastNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateLastName(service.getContacts().get(0).getContactId(), lastNameTest);
		assertEquals(lastNameTest, service.getContacts().get(0).getLastName());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateLastName(service.getContacts().get(0).getContactId(), null));
		assertThrows(IllegalArgumentException.class,
				() -> service.updateLastName(service.getContacts().get(0).getContactId(), failLastName));
	}
	
	// This tests the updatePhoneNum function
	@Test
	void updatePhoneNumTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updatePhoneNum(service.getContacts().get(0).getContactId(), phoneNumTest);
		assertEquals(phoneNumTest, service.getContacts().get(0).getPhoneNum());
		assertThrows(IllegalArgumentException.class,
				() -> service.updatePhoneNum(service.getContacts().get(0).getContactId(), null));
		assertThrows(IllegalArgumentException.class,
				() -> service.updatePhoneNum(service.getContacts().get(0).getContactId(), failPhoneNum));
	}
	
	// This tests the updateAddress function
	@Test
	void updateAddressTest() throws Exception{
		ContactService service = new ContactService();
		service.newContact();
		service.updateAddress(service.getContacts().get(0).getContactId(), addressTest);
		assertEquals(addressTest, service.getContacts().get(0).getAddress());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateAddress(service.getContacts().get(0).getContactId(), null));
		assertThrows(IllegalArgumentException.class,
				() -> service.updateAddress(service.getContacts().get(0).getContactId(), failAddress));
	}
	
}
	