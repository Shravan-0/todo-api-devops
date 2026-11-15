package com.example.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TodoController {

    private final List<Todo> todos = new CopyOnWriteArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String home() {
        return "Welcome to Todo API - DevOps Assignment";
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return todos.stream()
                .filter(todo -> todo.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody TodoRequest request) {
        if (request.title() == null || request.title().isBlank()) {
            throw new IllegalArgumentException("Todo title cannot be empty");
        }

        Todo todo = new Todo(counter.incrementAndGet(), request.title(), false);
        todos.add(todo);
        return todo;
    }

    public record TodoRequest(String title) {}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class TodoNotFoundException extends RuntimeException {
        public TodoNotFoundException(Long id) {
            super("Todo not found: " + id);
        }
    }
}
