package Task;

/*
 * Jessie Smith
 * SNHU
 * CS 320
 * 18 February 2023
 */

public class Task {
	
	private String taskId;
	private String name;
	private String description;
	private static final int TASK_ID_LENGTH = 10;
	private static final int NAME_LENGTH = 20;
	private static final int DESCRIPTION_LENGTH = 50;
	
	
	// Constructors:
	Task() {
		this.taskId = "EMPTY";
		this.name = "EMPTY";
		this.description = "EMPTY";
	}
	
	Task(String taskId) {
		setTaskId(taskId);
		this.name = "EMPTY";
		this.description = "EMPTY";
	}
	
	Task(String taskId, String name) {
		setTaskId(taskId);
		setName(name);
		this.description = "EMPTY";
	}
	
	Task(String taskId, String name, String description) {
		setTaskId(taskId);
		setName(name);
		setDescription(description);
	}
	
	
	// Getter functions
	public final String getTaskId() {return this.taskId;}
	
	public final String getName() {return this.name;}
	
	public final String getDescription() {return this.description;}
	
	
	// Setter functions
	protected void setTaskId(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
		}
		else if (taskId.length() > TASK_ID_LENGTH) {
			throw new IllegalArgumentException("Task ID cannot be longer than " + TASK_ID_LENGTH + " characters.");
		}
		else {
			this.taskId = taskId;
		}
	}
	
	protected void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		else if (name.length() > NAME_LENGTH) {
			throw new IllegalArgumentException("Name cannot be longer than " + NAME_LENGTH + " characters.");
		}
		else {
			this.name = name;
		}
	}
	
	protected void setDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null.");
		}
		else if (description.length() > DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException("Description cannot be longer than " + DESCRIPTION_LENGTH + " characters.");
		}
		else {
			this.description = description;
		}
	}
}