# Sprint 2 Review

**Date:** February 16, 2026
**Sprint Goal:** Implement Delete and Update functionality, and improve code with logging.

## Deliverables

### 1. New Features
-   **Delete Task:** Implemented `deleteTask` in `TaskManager` and added menu option.
-   **Update Task:** Implemented `updateTask` to modify title, description, and priority.
-   **Logging:** Integrated SLF4J. Replaced `System.err` with `logger.error` and added `logger.info` for key actions.

### 2. Code Quality & Testing
-   Updated `TaskManagerTest` to include unit tests for Delete and Update operations.
-   Refactored `Task` class to include setters for updates.

### 3. CI/CD
-   Pipeline continues to run on every push, ensuring no regression.

## Status of User Stories
| ID | Story | Status | Points |
|----|-------|--------|--------|
| US-4 | Delete Task | **Done** | 1 |
| US-5 | Update Task | **Done** | 2 |
| Feat | Logging | **Done** | - |

## Evidence
-   [ ] GitHub Actions passing.
-   [ ] Logs showing "Task added", "Task deleted" etc.
