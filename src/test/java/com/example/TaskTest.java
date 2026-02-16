package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Buy Milk", "Go to the store", "High");

        assertNotNull(task.getId());
        assertEquals("Buy Milk", task.getTitle());
        assertEquals("Go to the store", task.getDescription());
        assertEquals("High", task.getPriority());
        assertEquals("Pending", task.getStatus());
    }

    @Test
    public void testSetStatus() {
        Task task = new Task("Test", "Desc", "Low");
        task.setStatus("Completed");
        assertEquals("Completed", task.getStatus());
    }
}
