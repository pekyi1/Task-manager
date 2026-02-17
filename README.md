# Task Manager

## Description
A simple, robust command-line task management tool that helps individuals organize their daily work. It allows users to create, view, update, delete, and mark tasks as complete. The application persists data using a simple CSV file and includes logging for key actions.

This project was developed over 3 sprints (Sprint 0, 1, 2) following Agile and DevOps practices.

## Tech Stack
-   **Language:** Java 25
-   **Build Tool:** Maven (optional for running)
-   **Testing:** JUnit 5
-   **Version Control:** Git & GitHub
-   **CI/CD:** GitHub Actions

## How to Run the Project

### Option 1: Zero-Dependency Script (Recommended)
We have optimized the project to run without external dependencies (like Maven installed globally).
1.  Open a terminal in the project folder.
2.  Run the batch script:
    ```powershell
    .\run_app.bat
    ```

### Option 2: Using Maven
If you have Maven installed:
1.  Build the project:
    ```bash
    mvn clean package
    ```
2.  Run the JAR:
    ```bash
    java -cp target/classes com.example.Main
    ```

## Sprint Documentation
-   [Sprint 0: Planning](SPRINT_0_PLANNING.md)
-   [Sprint 1: Review](SPRINT_1_REVIEW.md)
-   [Sprint 1: Retrospective](SPRINT_1_RETROSPECTIVE.md)
-   [Sprint 2: Review](SPRINT_2_REVIEW.md)
-   [Sprint 2: Retrospective](SPRINT_2_RETROSPECTIVE.md)

## Author
This project was implemented by Fred Pekyi as part of the Agile & DevOps module.
