# Project Management Tool (ProjectFlow)

A starter Java-based web application aligned with the presentation's core ideas: project planning, task assignment, task status tracking, and a dashboard.

## Technology
- Java 17
- Spring Boot 3.4.5
- Maven
- HTML, CSS, JavaScript
- In-memory sample data (no database yet)

## Current features
- Dashboard counts for projects and tasks
- List sample projects and tasks
- Create projects
- Create tasks and assign them to a project
- Assign a team/person label and priority to tasks
- Update task status: To Do, In Progress, Done
- Responsive layout for desktop and mobile browsers

## Requirements
- JDK 17 or newer
- Maven 3.6+ (or use an IDE with Maven support)
- Internet access on first build so Maven can download dependencies

Check Java:
```bash
java -version
```
Check Maven:
```bash
mvn -version
```

## Run locally
From this folder, run:
```bash
mvn spring-boot:run
```
Then open http://localhost:8080

## API endpoints
- `GET /api/projects`
- `POST /api/projects`
- `GET /api/tasks`
- `POST /api/tasks`
- `PATCH /api/tasks/{id}/status`

## Important limitations
This is a starter/demo version. Data is held in memory and resets when the server restarts. Database persistence, user authentication, real-time chat, file uploads, calendar integration, and production deployment are not implemented. Do not describe these as completed features unless you build and test them.

## GitHub upload
1. Create a public repository named `project-management-tool`.
2. Upload the files and folders from this project (upload the contents, not just the ZIP file).
3. Commit the upload.
4. Open the repository page and copy its URL.
5. Confirm that `README.md`, `pom.xml`, and `src/` are visible to visitors.

## Presentation note
The accompanying presentation describes a broader planned tool. Update the slides or explain clearly which features are implemented in this starter and which are future work.
