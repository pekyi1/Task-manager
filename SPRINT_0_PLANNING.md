# Sprint 0: Planning & Setup

**Project:** Task Manager
**Sprint:** 0 (Planning)

## 1. Product Vision
**Vision Statement:**
A simple, robust command-line task management tool that helps individuals organize their daily work by allowing them to create, safe-keep, and track the status of their tasks efficiently.

## 2. Product Backlog (Prioritized)

| ID | User Story | Priority | Est. (Pts) |
|----|------------|----------|------------|
| US-1 | As a user, I want to **create a new task** with a title and description so that I can remember what to do. | High | 3 |
| US-2 | As a user, I want to **view all my tasks** in a list so that I can see my workload. | High | 2 |
| US-3 | As a user, I want to **mark a task as complete** so that I can track my progress. | High | 2 |
| US-4 | As a user, I want to **delete a task** so that I can remove items I no longer need. | Med | 1 |
| US-5 | As a user, I want to **edit a task's details** so that I can correct mistakes or update information. | Med | 2 |

### Acceptance Criteria (Refined)

**US-1: Create Task**
- [ ] User can input Title (required) and Description (optional).
- [ ] System confirms creation with a unique ID.
- [ ] Task is saved to persistent storage (JSON/File).

**US-2: View Tasks**
- [ ] Displays all tasks with ID, Title, Status, and Details.
- [ ] If list is empty, shows "No tasks available".

**US-3: Mark Complete**
- [ ] User selects task by ID.
- [ ] Status updates to "Completed".
- [ ] System confirms the update.

**US-4: Delete Task**
- [ ] User selects task by ID.
- [ ] System prompts for confirmation (Y/N).
- [ ] Task is removed from the list/storage.

**US-5: Edit Task**
- [ ] User selects task by ID.
- [ ] User can update Title or Description.
- [ ] Changes are saved immediately.

## 3. Definition of Done (DoD)
A backlog item is "Done" when:
1.  **Code**: Implemented and follows coding standards (Java).
2.  **Tests**: Unit tests written and passing (80%+ coverage).
3.  **CI/CD**: Builds and tests pass in the CI pipeline.
4.  **Version Control**: Committed with a descriptive message.
5.  **Review**: Self-reviewed and manually verified.

## 4. Sprint 1 Plan

**Goal**: Establish the project skeleton, CI/CD pipeline, and deliver the "Create" and "View" functionality.

**Selected Stories:**
1.  **US-1**: Create a new task (3 pts)
2.  **US-2**: View all tasks (2 pts)

**Total Commitment**: 5 Points

**Deliverables:**
-   Git Repository with initial commit.
-   CI Pipeline (GitHub Actions) configured.
-   Working Application (Main Menu, Add Task, List Tasks).
-   Unit Tests for Task and TaskManager.
