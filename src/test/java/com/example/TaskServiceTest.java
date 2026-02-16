package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for TaskService class.
 * Tests cover all core functionality including creating, viewing, completing, and deleting tasks.
 */
public class TaskServiceTest {
    private TaskService taskService;
    private TaskRepository repository;

    @BeforeEach
    public void setUp() {
        // Use an in-memory repository for testing (doesn't persist to file)
        repository = new TaskRepository();
        taskService = new TaskService(repository);
    }

    /**
     * Test US-1: Create a New Task
     */
    @Test
    public void testCreateTask() {
        Task task = taskService.createTask("Buy groceries", "Milk, eggs, bread", Task.Priority.HIGH, LocalDate.of(2026, 02, 20));

        assertNotNull(task);
        assertEquals("Buy groceries", task.getTitle());
        assertEquals("Milk, eggs, bread", task.getDescription());
        assertEquals(Task.Priority.HIGH, task.getPriority());
        assertFalse(task.isCompleted());
    }

    /**
     * Test that creating a task with empty title throws exception
     */
    @Test
    public void testCreateTaskWithEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask("", "Description", Task.Priority.MEDIUM, LocalDate.now());
        });
    }

    /**
     * Test that creating a task with null title throws exception
     */
    @Test
    public void testCreateTaskWithNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(null, "Description", Task.Priority.MEDIUM, LocalDate.now());
        });
    }

    /**
     * Test US-2: View All Tasks - sorted by priority
     */
    @Test
    public void testGetAllTasksSortedByPriority() {
        taskService.createTask("Task 1", "Desc", Task.Priority.LOW, null);
        taskService.createTask("Task 2", "Desc", Task.Priority.HIGH, null);
        taskService.createTask("Task 3", "Desc", Task.Priority.MEDIUM, null);

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(3, tasks.size());
        assertEquals(Task.Priority.HIGH, tasks.get(0).getPriority());
        assertEquals(Task.Priority.MEDIUM, tasks.get(1).getPriority());
        assertEquals(Task.Priority.LOW, tasks.get(2).getPriority());
    }

    /**
     * Test that getting all tasks from empty list returns empty list
     */
    @Test
    public void testGetAllTasksEmpty() {
        List<Task> tasks = taskService.getAllTasks();
        assertEquals(0, tasks.size());
    }

    /**
     * Test US-3: Mark Task as Complete
     */
    @Test
    public void testMarkTaskComplete() {
        Task task = taskService.createTask("Buy milk", "From grocery store", Task.Priority.HIGH, LocalDate.of(2026, 02, 18));
        int taskId = task.getId();

        assertFalse(task.isCompleted());
        boolean result = taskService.markTaskComplete(taskId);

        assertTrue(result);
        assertTrue(taskService.getTaskById(taskId).isCompleted());
    }

    /**
     * Test marking non-existent task as complete
     */
    @Test
    public void testMarkNonExistentTaskComplete() {
        boolean result = taskService.markTaskComplete(999);
        assertFalse(result);
    }

    /**
     * Test US-4: Delete a Task
     */
    @Test
    public void testDeleteTask() {
        Task task = taskService.createTask("Temporary task", "Will be deleted", Task.Priority.LOW, null);
        int taskId = task.getId();

        List<Task> tasksBeforeDelete = taskService.getAllTasks();
        assertEquals(1, tasksBeforeDelete.size());

        boolean result = taskService.deleteTask(taskId);

        assertTrue(result);
        List<Task> tasksAfterDelete = taskService.getAllTasks();
        assertEquals(0, tasksAfterDelete.size());
    }

    /**
     * Test deleting non-existent task
     */
    @Test
    public void testDeleteNonExistentTask() {
        boolean result = taskService.deleteTask(999);
        assertFalse(result);
    }

    /**
     * Test US-5: Update Task Due Date
     */
    @Test
    public void testUpdateTaskDueDate() {
        LocalDate originalDate = LocalDate.of(2026, 02, 20);
        LocalDate newDate = LocalDate.of(2026, 03, 01);

        Task task = taskService.createTask("Task with deadline", "Description", Task.Priority.MEDIUM, originalDate);
        int taskId = task.getId();

        boolean result = taskService.updateTaskDueDate(taskId, newDate);

        assertTrue(result);
        assertEquals(newDate, taskService.getTaskById(taskId).getDueDate());
    }

    /**
     * Test updating due date of non-existent task
     */
    @Test
    public void testUpdateNonExistentTaskDueDate() {
        boolean result = taskService.updateTaskDueDate(999, LocalDate.now());
        assertFalse(result);
    }

    /**
     * Test US-6: Search Tasks by Keyword
     */
    @Test
    public void testSearchTasksByKeyword() {
        taskService.createTask("Buy groceries", "Milk and bread", Task.Priority.HIGH, null);
        taskService.createTask("Clean house", "Living room and kitchen", Task.Priority.MEDIUM, null);
        taskService.createTask("Buy milk for breakfast", "Get fresh milk", Task.Priority.LOW, null);

        List<Task> results = taskService.searchTasks("milk");

        assertEquals(2, results.size());
        assertTrue(results.stream().anyMatch(t -> t.getTitle().contains("Buy groceries")));
        assertTrue(results.stream().anyMatch(t -> t.getTitle().contains("Buy milk")));
    }

    /**
     * Test case-insensitive search
     */
    @Test
    public void testSearchTasksCaseInsensitive() {
        taskService.createTask("Buy Groceries", "Food items", Task.Priority.HIGH, null);

        List<Task> results = taskService.searchTasks("GROCERIES");

        assertEquals(1, results.size());
        assertEquals("Buy Groceries", results.get(0).getTitle());
    }

    /**
     * Test search with no results
     */
    @Test
    public void testSearchTasksNoResults() {
        taskService.createTask("Task 1", "Description 1", Task.Priority.HIGH, null);

        List<Task> results = taskService.searchTasks("nonexistent");

        assertEquals(0, results.size());
    }

    /**
     * Test get completed count
     */
    @Test
    public void testGetCompletedCount() {
        Task task1 = taskService.createTask("Task 1", "Desc", Task.Priority.HIGH, null);
        Task task2 = taskService.createTask("Task 2", "Desc", Task.Priority.MEDIUM, null);
        Task task3 = taskService.createTask("Task 3", "Desc", Task.Priority.LOW, null);

        assertEquals(0, taskService.getCompletedCount());

        taskService.markTaskComplete(task1.getId());
        taskService.markTaskComplete(task2.getId());

        assertEquals(2, taskService.getCompletedCount());
        assertEquals(1, taskService.getPendingCount());
    }

    /**
     * Test get task by ID
     */
    @Test
    public void testGetTaskById() {
        Task createdTask = taskService.createTask("Find me", "Test task", Task.Priority.MEDIUM, null);

        Task foundTask = taskService.getTaskById(createdTask.getId());

        assertNotNull(foundTask);
        assertEquals(createdTask.getId(), foundTask.getId());
        assertEquals("Find me", foundTask.getTitle());
    }

    /**
     * Test get non-existent task by ID
     */
    @Test
    public void testGetNonExistentTaskById() {
        Task task = taskService.getTaskById(999);
        assertNull(task);
    }
}

