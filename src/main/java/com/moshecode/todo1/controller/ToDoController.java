package com.moshecode.todo1.controller;

import com.moshecode.todo1.Service.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToDoController {
    private final ToDo toDo;

    @GetMapping("/todo")
    public String getToDoList() {
        //todo replace string with todo list object
        return  toDo.getToDoList();
    }
}
