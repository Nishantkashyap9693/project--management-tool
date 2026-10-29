package com.nishant.pmt;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProjectController {
    private final AtomicLong projectIds = new AtomicLong(4);
    private final AtomicLong taskIds = new AtomicLong(5);

    private final List<Project> projects = new ArrayList<>(List.of(
        new Project(1, "Website Redesign", "Refresh the company website", "In Progress", "2026-11-10"),
        new Project(2, "Product Launch", "Prepare the product launch", "Planning", "2026-11-18"),
        new Project(3, "Marketing Campaign", "Plan campaign content", "In Progress", "2026-11-24")
    ));
    private final List<Task> tasks = new ArrayList<>(List.of(
        new Task(1, 1, "Define project scope", "Nishant", "Done", "High"),
        new Task(2, 1, "Design user interface", "Design Team", "In Progress", "High"),
        new Task(3, 2, "Prepare launch checklist", "Marketing", "To Do", "Medium"),
        new Task(4, 3, "Draft campaign content", "Content Team", "To Do", "Medium")
    ));

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projects;
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody ProjectInput input) {
        Project project = new Project(projectIds.getAndIncrement(), input.name(), input.description(),
                "Planning", input.dueDate());
        projects.add(project);
        return project;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody TaskInput input) {
        Task task = new Task(taskIds.getAndIncrement(), input.projectId(), input.title(),
                input.assignee(), "To Do", input.priority());
        tasks.add(task);
        return task;
    }

    @PatchMapping("/tasks/{id}/status")
    public Task updateStatus(@PathVariable long id, @RequestBody StatusInput input) {
        return tasks.stream()
            .filter(task -> task.id() == id)
            .findFirst()
            .map(task -> {
                Task updated = new Task(task.id(), task.projectId(), task.title(),
                    task.assignee(), input.status(), task.priority());
                tasks.set(tasks.indexOf(task), updated);
                return updated;
            })
            .orElseThrow(() -> new NoSuchElementException("Task not found: " + id));
    }

    public record Project(long id, String name, String description, String status, String dueDate) {}
    public record Task(long id, long projectId, String title, String assignee, String status, String priority) {}
    public record ProjectInput(String name, String description, String dueDate) {}
    public record TaskInput(long projectId, String title, String assignee, String priority) {}
    public record StatusInput(String status) {}
}
