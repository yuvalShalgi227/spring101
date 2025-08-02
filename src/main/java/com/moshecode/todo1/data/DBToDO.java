package com.moshecode.todo1.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBToDO {
    private final ToDoRepository toDoRepository;

    @Autowired
    public DBToDO(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo saveOrUpdate(ToDo todo) {
        return toDoRepository.save(todo);
    }
}
