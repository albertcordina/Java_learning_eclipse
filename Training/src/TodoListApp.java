import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface TaskPredicate {
	boolean test(Task task);
}

class Task {

	private int taskId;
	private String description;
	private int priority;
	private boolean completed;

	public Task(int taskId, String description, int priority) {
		this.taskId = taskId;
		this.description = description;
		this.priority = priority;
		this.completed = false;
	}

	public int getTaskId() {
		return taskId;
	}

	public String getDescription() {
		return description;
	}

	public int getPriority() {
		return priority;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void markAsCompleted() {
		this.completed = true;
	}
}




class TodoListManager {

	List <Task> tasks;

	public TodoListManager() {
		this.tasks = new ArrayList<>();
	}

	/*
	 * public void addTask(Task task) { tasks.add(task); }
	 */

	public void addTask(Task task) {

		tasks = Stream.concat(tasks.stream(), Stream.of(task)).collect(Collectors.toList());
	}

	/*
	 * public void displayTasks() { System.out.println("Task List:"); for (Task task
	 * : tasks) { System.out.println("Task ID: " + task.getTaskId() +
	 * " - Description: " + task.getDescription() + " - Priority: " +
	 * task.getPriority() + " - Completed: " + task.isCompleted()); } }
	 */

	public void displayTasks() {

		tasks.forEach(
				task -> System.out.println("Task ID: " + task.getTaskId() + " - Description: " + task.getDescription()
						+ " - Priority: " + task.getPriority() + " - Completed: " + task.isCompleted()));
	}

	/*
	 * public List<Task> findTasksByPriority (int priority) { List<Task> result =
	 * new ArrayList<>();
	 * 
	 * for (Task task : tasks) { if (task.getPriority() == priority) {
	 * result.add(task); } } return result; }
	 */

	public List<Task> findTasksByPriority(int priority) {

		return filterTasks(task -> task.getPriority() == priority);
	}

	/*
	 * public void markTaskAsCompleted(int taskId) {
	 * 
	 * for (Task task : tasks) { if (task.getTaskId() == taskId) {
	 * task.markAsCompleted(); break; } } }
	 */

	public void markTaskAsCompleted(int taskId) {
		tasks = tasks.stream().peek(task -> {
			if (task.getTaskId() == taskId) {
				task.markAsCompleted();
			}
		}).collect(Collectors.toList());
	}

	public List<Task> filterTasks(TaskPredicate predicate) {

		return tasks.stream().filter(predicate::test).collect(Collectors.toList());
	}
}



public class TodoListApp {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		TodoListManager todoListManager = new TodoListManager();
		todoListManager.addTask(new Task(1, "Complete assignment", 2));
		todoListManager.addTask(new Task(2, "Read a book", 1));
		todoListManager.addTask(new Task(3, "Exercise", 3));

		// Code for testing basic implementation
		System.out.println("Initial Task List:");
		todoListManager.displayTasks();

		// Adding a new task
		System.out.print("\nEnter task description: ");
		String newDescription = scanner.nextLine();

		System.out.print("Enter task priority. ");
		// int newPriority = scanner.nextInt();
		int newPriority = 0;
		getNumber(newPriority); // we call the method to collect the number

		Task newTask = new Task(todoListManager.tasks.size() + 1, newDescription, newPriority);
		todoListManager.addTask(newTask);

		// Displaying tasks after adding a new task
		System.out.println("\nUpdated Task List:");
		todoListManager.displayTasks();

		// Finding and displaying tasks by priority
		System.out.print("\nEnter priority to find tasks. ");
		// int priorityToFind = scanner.nextInt();
		int priorityToFind = 0;
		getNumber(priorityToFind); // we call the method to collect the number

		List<Task> tasksByPriority = todoListManager.findTasksByPriority(priorityToFind);
		System.out.println("Tasks with Priority " + priorityToFind + ":");
		for (Task task : tasksByPriority) {
			System.out.println("Task ID: " + task.getTaskId() + " - Description: " + task.getDescription()
					+ " - Priority: " + task.getPriority() + " - Completed: " + task.isCompleted());
		}

		// Marking a task as completed
		System.out.print("\nEnter task ID to mark as completed. ");
		// int taskIdToComplete = scanner.nextInt();
		int taskIdToComplete = 0;
		getNumber(taskIdToComplete); // we call the method to collect the number

		todoListManager.markTaskAsCompleted(taskIdToComplete);

		// Displaying tasks after marking a task as completed
		System.out.println("\nUpdated Task List after marking a task as completed:");
		todoListManager.displayTasks();

		scanner.close();
	}

	private static int getNumber(int number) {

		do {
			try {
				System.out.print("Enter the number: ");
				number = scanner.nextInt();
			} // in case of entering String instead of int;
			catch (InputMismatchException e) {
				System.out.println("There should be a positive number, not any other character(s).");
				scanner.nextLine();
			}
		} while (number < 1); // condition of a positive number to enter
		return number;
	}
}
