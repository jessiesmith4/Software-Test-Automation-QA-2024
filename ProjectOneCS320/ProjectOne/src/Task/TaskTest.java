package Task;

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


public class TaskTest {
	protected String taskIdTest, nameTest, descriptionTest;
	protected String taskIdFail, nameFail, descriptionFail;
	
	@BeforeEach
	void setUp() {
		taskIdTest = "1234567890"; // Task id is within 10 char limit
		nameTest = "Task name"; // Task name is within 20 char limit
		descriptionTest = "This is a description"; // Task description is within 50 char limit
		taskIdFail = "12345678901234567890"; // This task id is too long
		nameFail = "This is too long to be the task name"; // This task name is too long
		descriptionFail = "This description is way too long for the task description"; // This description is too long
	}
	
	// Each of the following test the constructors in Task.java
	@Test
	void taskTest() {
		Task task = new Task();
		assertAll("Constructor",
				() -> assertNotNull(task.getTaskId()),
				() -> assertNotNull(task.getName()),
				() -> assertNotNull(task.getDescription()));
	}
	
	@Test
	void constructor1Test() {
		Task task = new Task(taskIdTest);
		assertAll("Constructor 1",
				() -> assertEquals(taskIdTest, task.getTaskId()),
				() -> assertNotNull(task.getName()),
				() -> assertNotNull(task.getDescription()));
	}
	
	@Test
	void constructor2Test() {
		Task task = new Task(taskIdTest, nameTest);
		assertAll("Constructor 2",
				() -> assertEquals(taskIdTest, task.getTaskId()),
				() -> assertEquals(nameTest, task.getName()),
				() -> assertNotNull(task.getDescription()));
	}
	
	@Test
	void constructor3Test() {
		Task task = new Task(taskIdTest, nameTest, descriptionTest);
		assertAll("Constructor 3",
				() -> assertEquals(taskIdTest, task.getTaskId()),
				() -> assertEquals(nameTest, task.getName()),
				() -> assertEquals(descriptionTest, task.getDescription()));
	}
	
	
	// Each of the following test the setter functions in Task.java
	// They each insure that variables that are set, equal the correct value,
	// and that null or invalid entries throw exceptions
	@Test
	void setTaskIdTest() {
		Task task = new Task();
		task.setTaskId(taskIdTest);
		assertAll("setTaskId test",
				() -> assertEquals(taskIdTest, task.getTaskId()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> task.setTaskId(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> task.setTaskId(taskIdFail)));
	}
	
	@Test
	void setNameTest() {
		Task task = new Task();
		task.setName(nameTest);
		assertAll("setName test",
				() -> assertEquals(nameTest, task.getName()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> task.setName(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> task.setName(nameFail)));
	}
	
	@Test
	void setDescriptionTest() {
		Task task = new Task();
		task.setDescription(descriptionTest);
		assertAll("setDescription test",
				() -> assertEquals(descriptionTest, task.getDescription()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> task.setDescription(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> task.setDescription(descriptionFail)));
	}
}

