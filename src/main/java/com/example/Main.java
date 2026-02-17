package com.example;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final TaskManager taskManager = new TaskManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        logger.info("Application started");
        System.out.println("Welcome to Task Manager");
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    markTaskComplete();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    updateTask();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    logger.info("Application stopped");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n========================");
        System.out.println("      TASK MANAGER      ");
        System.out.println("========================");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task Complete");
        System.out.println("4. Delete Task");
        System.out.println("5. Update Task");
        System.out.println("0. Exit");
        System.out.println("------------------------");
        System.out.print("Enter choice: ");
    }

    private static void createTask() {
        System.out.print("Enter Task Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Description (optional): ");
        String description = scanner.nextLine();

        System.out.print("Enter Priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        try {
            Task task = taskManager.addTask(title, description, priority);
            System.out.println("Task added successfully! ID: " + task.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewTasks() {
        List<Task> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n--- Task List ---");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void markTaskComplete() {
        System.out.print("Enter Task ID (or first few chars): ");
        String id = scanner.nextLine();

        if (taskManager.markTaskComplete(id)) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter Task ID (or first few chars): ");
        String id = scanner.nextLine();
        System.out.print("Are you sure? (y/n): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            if (taskManager.deleteTask(id)) {
                System.out.println("Task deleted.");
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private static void updateTask() {
        System.out.print("Enter Task ID (or first few chars): ");
        String id = scanner.nextLine();

        System.out.print("Enter New Title (leave empty to keep current): ");
        String title = scanner.nextLine();

        System.out.print("Enter New Description (leave empty to keep current): ");
        String description = scanner.nextLine();

        System.out.print("Enter New Priority (leave empty to keep current): ");
        String priority = scanner.nextLine();

        if (taskManager.updateTask(id, title, description, priority)) {
            System.out.println("Task updated.");
        } else {
            System.out.println("Task not found.");
        }
    }
}
