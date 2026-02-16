# Sprint 0: Planning & Setup

**Project Name:** Task Manager  
**Date:** February 16, 2026  
**Team:** Individual

---

## 1. Product Vision

**Vision Statement:**
A command-line task management application that allows users to create, view, update, and delete tasks with priority levels and due dates. The application will help individuals stay organized by providing a simple, efficient way to manage their daily workload with persistent data storage.

---

## 2. Product Backlog

### User Story Format:
"As a [user role], I want [feature], so that [benefit]"

---

### **US-1: Create a New Task**
**Priority:** HIGH  
**Story Points:** 3  
**Description:** As a user, I want to add a new task with a title, description, and priority level, so that I can keep track of what I need to accomplish.

**Acceptance Criteria:**
- Given I'm in the main menu, when I select "Add Task", I should be able to enter a task title
- When I enter a task description and priority level (High/Medium/Low), the system should save the task
- When the task is saved, the application should display a confirmation message with the task ID
- The task should persist to a file or data structure so it's available after the application closes
- The application should not allow saving a task without a title

---

### **US-2: View All Tasks**
**Priority:** HIGH  
**Story Points:** 2  
**Description:** As a user, I want to view a list of all my tasks, so that I can see what I need to accomplish at a glance.

**Acceptance Criteria:**
- Given I select "View Tasks" from the menu, I should see a formatted list of all tasks
- Each task should display its ID, title, priority, and due date
- The list should be sorted by priority (High first, then Medium, then Low)
- If no tasks exist, the system should display "No tasks found"
- The list should be easily readable and well-formatted

---

### **US-3: Mark Task as Complete**
**Priority:** HIGH  
**Story Points:** 2  
**Description:** As a user, I want to mark a task as complete, so that I can track my progress and keep my task list current.

**Acceptance Criteria:**
- Given I select "Mark Complete" and provide a task ID, the task status should change to "Complete"
- When a task is marked complete, it should display a confirmation message
- Completed tasks should still be visible in the task list but marked with a status indicator (e.g., [✓])
- The system should not allow marking a non-existent task as complete
- Completing a task should persist immediately to storage

---

### **US-4: Delete a Task**
**Priority:** MEDIUM  
**Story Points:** 1  
**Description:** As a user, I want to delete a task, so that I can remove tasks that are no longer relevant.

**Acceptance Criteria:**
- Given I select "Delete Task" and provide a task ID, the task should be removed from the list
- The system should ask for confirmation before deleting (e.g., "Are you sure? Y/N")
- When a task is deleted, a confirmation message should be displayed
- The system should not allow deleting a non-existent task
- The deletion should persist immediately to storage

---

### **US-5: Update Task Due Date**
**Priority:** MEDIUM  
**Story Points:** 2  
**Description:** As a user, I want to update a task's due date, so that I can adjust deadlines when plans change.

**Acceptance Criteria:**
- Given I select "Update Task" and provide a task ID, I should be able to modify the due date
- The system should validate that the due date is in a valid format (e.g., YYYY-MM-DD)
- When the due date is updated, the system should display a confirmation message
- The updated due date should persist immediately to storage
- The system should not allow updating a non-existent task

---

### **US-6: Search Tasks by Keyword**
**Priority:** LOW  
**Story Points:** 3  
**Description:** As a user, I want to search tasks by keyword, so that I can quickly find specific tasks.

**Acceptance Criteria:**
- Given I select "Search" and enter a keyword, the system should filter tasks by title or description
- The search should be case-insensitive
- The search results should display all matching tasks in the same format as the full list
- If no matches are found, the system should display "No tasks match your search"
- The search should not modify any data, only display results

---

## 3. Definition of Done (DoD)

A user story is considered complete when **ALL** of the following criteria are met:

1. **Code Written:** All code is written following Java best practices and style guidelines
2. **Unit Tests:** Unit tests are written and achieve at least 80% code coverage for the feature
3. **Tests Pass:** All unit tests pass locally and in the CI/CD pipeline
4. **Git Commit:** Code is committed to Git with a clear, descriptive commit message
5. **Code Review:** Code has been reviewed (self-reviewed at minimum) and no critical issues remain
6. **Manual Testing:** The feature has been manually tested and works as specified in acceptance criteria
7. **No Blocking Bugs:** There are no critical or high-severity bugs preventing the feature from working
8. **Documentation:** Code is documented with comments where necessary, and acceptance criteria are verified

---

## 4. Sprint 1 Planning

**Sprint Goal:** Deliver a working task manager application with core functionality for creating, viewing, and managing tasks.

**Selected User Stories for Sprint 1:**
1. **US-1: Create a New Task** (3 story points) - HIGH priority, core functionality
2. **US-2: View All Tasks** (2 story points) - HIGH priority, core functionality
3. **US-3: Mark Task as Complete** (2 story points) - HIGH priority, complements US-1 and US-2

**Total Sprint 1 Effort:** 7 story points

**Sprint 1 Timeline:** 
- Duration: 1 week (simulated)
- Goal: Have a working prototype with basic task management

**Sprint 1 Deliverables:**
- Working command-line application for creating, viewing, and completing tasks
- Unit tests for all business logic
- CI/CD pipeline configured and running
- Git commit history showing iterative development
- Sprint Review document with demo or screenshots
- Sprint 1 Retrospective with identified improvements

---

## 5. Development Environment Setup

**Language:** Java 25  
**Build Tool:** Maven  
**Testing Framework:** JUnit 5  
**Data Storage:** JSON file (tasks.json)  
**CI/CD:** GitHub Actions  
**Version Control:** Git + GitHub  

---

## 6. Technology Stack

- **Java 25** for application development
- **Maven** for dependency management and building
- **JUnit 5** for unit testing
- **Gson** for JSON serialization/deserialization
- **SLF4J** for logging (Sprint 2)
- **GitHub Actions** for CI/CD

---

## Notes

- Keep the first sprint focused on core functionality (create, view, complete)
- Use file-based storage initially (JSON) to keep it simple
- Prioritize working software over perfection
- Plan for incremental commits throughout the sprint

