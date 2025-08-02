package com.moshecode.todo1.controller;

import com.moshecode.todo1.Service.ToDoService;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController //question -> why did controller not work?
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping("/todo")
    public String getToDoList() {
        //todo replace string with todo list object
        return  toDoService.getToDoList();
    }
}
