# Sprint 1 Retrospective

**Date:** February 16, 2026

## What Went Well?
-   The core logic was simple to implement using standard Java libraries.
-   JSON serialization with Gson made persistence easy.
-   Setting up the project structure early helped keep things organized.

## What Could Be Improved?
-   **Error Handling:** The current error handling is basic. We could add more robust input validation in the UI.
-   **Testing:** We need to ensure local environment has Maven configured correctly to run tests easily before pushing.
-   **UI:** The CLI interface is functional but could be made more user-friendly with clearer prompts or a loop that doesn't require hitting enter as often.

## Action Items for Sprint 2
1.  **Improve Error Handling**: Add better validation for user inputs (e.g., priority levels).
2.  **Add Logging**: Implement SLF4J to replace `System.out` for debugging/errors.
3.  **UI Enhancements**: Make the menu usage smoother.
