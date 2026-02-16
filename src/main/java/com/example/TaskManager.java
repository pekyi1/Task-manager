package com.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskManager {
    private static final Logger logger = Logger.getLogger(TaskManager.class.getName());
    private List<Task> tasks;
    private final String filePath;

    public TaskManager() {
        this("tasks.csv");
    }

    public TaskManager(String filePath) {
        this.filePath = filePath;
        this.tasks = new ArrayList<>();
        loadTasks();
    }

    public Task addTask(String title, String description, String priority) {
        if (title == null || title.trim().isEmpty()) {
            logger.warning("Attempted to add task with empty title");
            throw new IllegalArgumentException("Title cannot be empty");
        }
        Task task = new Task(title, description, priority);
        tasks.add(task);
        saveTasks();
        logger.info("Task added: " + task.getId());
        return task;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public boolean markTaskComplete(String id) {
        Optional<Task> taskOpt = findTask(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setStatus("Completed");
            saveTasks();
            logger.info("Task marked as completed: " + task.getId());
            return true;
        }
        logger.warning("Failed to mark task complete. ID not found: " + id);
        return false;
    }

    public boolean deleteTask(String id) {
        Optional<Task> taskOpt = findTask(id);
        if (taskOpt.isPresent()) {
            tasks.remove(taskOpt.get());
            saveTasks();
            logger.info("Task deleted: " + id);
            return true;
        }
        logger.warning("Failed to delete task. ID not found: " + id);
        return false;
    }

    public boolean updateTask(String id, String newTitle, String newDescription, String newPriority) {
        Optional<Task> taskOpt = findTask(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            if (newTitle != null && !newTitle.isEmpty())
                task.setTitle(newTitle);
            if (newDescription != null && !newDescription.isEmpty())
                task.setDescription(newDescription);
            if (newPriority != null && !newPriority.isEmpty())
                task.setPriority(newPriority);

            saveTasks();
            logger.info("Task updated: " + id);
            return true;
        }
        logger.warning("Failed to update task. ID not found: " + id);
        return false;
    }

    private Optional<Task> findTask(String id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id) || t.getId().startsWith(id))
                .findFirst();
    }

    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                // simple pipe-delimited persistence: id|title|desc|priority|status
                String line = String.format("%s|%s|%s|%s|%s",
                        task.getId(),
                        escape(task.getTitle()),
                        escape(task.getDescription()),
                        task.getPriority(),
                        task.getStatus());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error saving tasks", e);
        }
    }

    private void loadTasks() {
        if (!Files.exists(Paths.get(filePath))) {
            return;
        }
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 5) {
                    Task task = new Task(unescape(parts[1]), unescape(parts[2]), parts[3]);
                    task.setId(parts[0]);
                    task.setStatus(parts[4]);
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading tasks", e);
        }
    }

    private String escape(String input) {
        return input == null ? "" : input.replace("|", "%7C").replace("\n", "%0A");
    }

    private String unescape(String input) {
        return input == null ? "" : input.replace("%7C", "|").replace("%0A", "\n");
    }
}
