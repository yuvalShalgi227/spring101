package com.moshecode.todo1.controller;

import com.moshecode.todo1.data.ToDo;
import com.moshecode.todo1.Service.ToDoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping(path = "/{username}/todo")
    public List<ToDo> getAllTodos(@PathVariable String username) {
        return toDoService.getTodosForUser(username);
    }

    @PostMapping(path = "/{username}/todo")
    public ToDo createTodo(@PathVariable String username, @RequestBody ToDo todo) {
        return toDoService.addToDoItem(username, todo);
    }

    @PatchMapping(path = "/{username}/todo/{id}/complete")
    public ToDo markAsCompleted(@PathVariable String username, @PathVariable Long id) {
        return toDoService.markAsCompleted(username, id);
    }

    @DeleteMapping(path = "/{username}/todo/{id}")
    public void deleteTodo(@PathVariable String username, @PathVariable Long id) {
        toDoService.removeToDoItem(username, id);
    }
}
