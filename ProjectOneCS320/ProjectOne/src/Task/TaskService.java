package Task;

/*
 * Jessie Smith
 * SNHU
 * CS 320
 * 18 February 2023
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TaskService {
	private String uniqueId;
	private List<Task> tasks = new ArrayList<>();
	
	
	// Creates uniqueId
	private String newUniqueId() {
		uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return uniqueId;
	}
	
	
	// Creates new tasks
	public void newTask() {
		Task task = new Task(newUniqueId());
		tasks.add(task);
	}
	
	public void newTask(String name) {
		Task task = new Task(newUniqueId(), name);
		tasks.add(task);
	}
	
	public void newTask(String name, String description) {
		Task task = new Task(newUniqueId(), name, description) ;
		tasks.add(task);
	}
	
	
	// Searches tasks list
	private Task getTask(String taskId) throws Exception {
		for (int i = 0; i < tasks.size(); i++) {
			if (taskId.equals(tasks.get(i).getTaskId())) {
				return tasks.get(i);
			}
		}
		throw new Exception("Task ID does not exist.");
	}
	
	
	// Update functions
	protected void updateName(String taskId, String name) throws Exception {
		getTask(taskId).setName(name);
	}
	
	protected void updateDescription(String taskId, String description) throws Exception {
		getTask(taskId).setDescription(description);
	}
	
	
	// Returns tasks list
	protected List<Task> getTasksList() {return tasks;}
	
	
	// Deletes task
	protected void deleteTask(String taskId) throws Exception {
		tasks.remove(getTask(taskId));
	}
}