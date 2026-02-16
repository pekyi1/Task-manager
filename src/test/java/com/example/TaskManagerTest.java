package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        // Clear existing tasks.json for clean test
        File file = new File("tasks.json");
        if (file.exists()) {
            file.delete();
        }
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        Task task = taskManager.addTask("Read Book", "Read 10 pages", "Medium");

        assertNotNull(task);
        assertEquals("Read Book", task.getTitle());
        assertEquals(1, taskManager.getAllTasks().size());
    }

    @Test
    public void testAddEmptyTitle() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskManager.addTask("", "Description", "High");
        });
        assertEquals("Title cannot be empty", exception.getMessage());
    }

    @Test
    public void testMarkTaskComplete() {
        Task task = taskManager.addTask("Code", "Write Java", "High");
        boolean result = taskManager.markTaskComplete(task.getId());

        assertTrue(result);
        assertEquals("Completed", taskManager.getAllTasks().get(0).getStatus());
    }

    @Test
    public void testMarkNonExistentTaskComplete() {
        boolean result = taskManager.markTaskComplete("non-existent-id");
        assertFalse(result);
    }

    @Test
    public void testDeleteTask() {
        Task task = taskManager.addTask("Delete Me", "To be deleted", "Low");
        int initialSize = taskManager.getAllTasks().size();

        boolean result = taskManager.deleteTask(task.getId());

        assertTrue(result);
        assertEquals(initialSize - 1, taskManager.getAllTasks().size());
    }

    @Test
    public void testUpdateTask() {
        Task task = taskManager.addTask("Original", "Original Desc", "Low");

        boolean result = taskManager.updateTask(task.getId(), "Updated Title", "Updated Desc", "High");

        assertTrue(result);
        Task updatedTask = taskManager.getAllTasks().get(0);
        assertEquals("Updated Title", updatedTask.getTitle());
        assertEquals("Updated Desc", updatedTask.getDescription());
        assertEquals("High", updatedTask.getPriority());
    }
}
