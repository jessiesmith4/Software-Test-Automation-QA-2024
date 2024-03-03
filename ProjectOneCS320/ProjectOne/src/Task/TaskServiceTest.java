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

public class TaskServiceTest {
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
	
	
	// Each of the following test the newTask methods in TaskService.java
	@Test
	void newTasktest() {
		TaskService task = new TaskService();
		task.newTask();
		assertAll("newTask test",
				() -> assertNotNull(task.getTasksList().get(0).getTaskId()),
				() -> assertEquals("EMPTY", task.getTasksList().get(0).getName()),
				() -> assertEquals("EMPTY", task.getTasksList().get(0).getDescription()));
	}
	
	@Test
	void newTaskTest2() {
		TaskService task = new TaskService();
		task.newTask(nameTest);
		assertAll("newTask test2",
				() -> assertNotNull(task.getTasksList().get(0).getTaskId()),
				() -> assertEquals(nameTest, task.getTasksList().get(0).getName()),
				() -> assertEquals("EMPTY", task.getTasksList().get(0).getDescription()));
	}
	
	@Test
	void newTaskTest3() {
		TaskService task = new TaskService();
		task.newTask(nameTest, descriptionTest);
		assertAll("newTask test3",
				() -> assertNotNull(task.getTasksList().get(0).getTaskId()),
				() -> assertEquals(nameTest, task.getTasksList().get(0).getName()),
				() -> assertEquals(descriptionTest, task.getTasksList().get(0).getDescription()));
	}
	
	
	// Each of the following tests the update functions from
	// TaskService.java, they are tested to ensure they update 
	// the required variables, and that they throw exceptions 
	// when using a null or invalid string
	
	// This tests the updateName function
	@Test
	void updateNameTest() throws Exception{
		TaskService task = new TaskService();
		task.newTask();
		task.updateName(task.getTasksList().get(0).getTaskId(), nameTest);
		assertEquals(nameTest, task.getTasksList().get(0).getName());
		assertThrows(IllegalArgumentException.class,
				() -> task.updateName(task.getTasksList().get(0).getTaskId(), null));
		assertThrows(IllegalArgumentException.class,
				() -> task.updateName(task.getTasksList().get(0).getTaskId(), nameFail));
	}
	
	// This tests the updateDescription function
	@Test
	void updateDescriptionTest() throws Exception {
		TaskService task = new TaskService();
		task.newTask();
		task.updateDescription(task.getTasksList().get(0).getTaskId(), descriptionTest);
		assertEquals(descriptionTest, task.getTasksList().get(0).getDescription());
		assertThrows(IllegalArgumentException.class,
				() -> task.updateDescription(task.getTasksList().get(0).getTaskId(), null));
		assertThrows(IllegalArgumentException.class,
				() -> task.updateDescription(task.getTasksList().get(0).getTaskId(), descriptionFail));
	}
}