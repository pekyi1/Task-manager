# Sprint 2 Retrospective

**Date:** February 16, 2026

## What Went Well?
-   Building on the existing structure was straightforward.
-   **Adaptability:** Switched from SLF4J to `java.util.logging` to resolve Maven dependency issues in the environment.
-   Tests were easy to extend for the new features.

## What Could Be Improved?
-   **User Experience:** The CLI is still very basic. Inputting "High/Medium/Low" manually is prone to typos.
-   **Dependency Injection:** TaskManager is hardcoded in Main. We could use dependency injection for better testability of Main (though Main is hard to test automatically).

## Key Lessons
-   **Refactoring:** Adding setters to `Task` was necessary for the Update feature. It's good we didn't add them until needed (YAGNI).
-   **Logging:** Seeing logs instead of just print statements makes debugging much more professional.

## Final Thoughts
The project is complete according to the lab requirements. We have a working task manager with CRUD capabilities, persistence, logging, testing, and CI/CD.
