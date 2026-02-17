package com.example;

import java.util.UUID;

/**
 * Represents a task in the task management system.
 * Each task has a unique ID, title, description, priority, and status.
 */
public class Task {
    private String id;
    private String title;
    private String description;
    private String priority;
    private String dueDate;
    private String status;

    public Task(String title, String description, String priority) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = "Pending";
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // Updated format for better log readability in Sprint 2
        return String.format("Task [ID=%s] %s | Priority: %s | Status: %s | %s",
                id.substring(0, 8), title, priority, status, description);
    }
}
