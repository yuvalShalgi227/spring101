package com.moshecode.todo1.Service;

import org.springframework.stereotype.Component;

@Component
public class TodoServiceImpl implements ToDoService {

    public String getToDoList() {
        // This method should return the to-do list data
        // For now, returning a placeholder string
        return "To-Do List Placeholder";
    }
    public void addToDoItem(String item) {
        // This method should add an item to the to-do list
        // For now, just printing the item
        System.out.println("Adding item: " + item);
    }
    public void removeToDoItem(String item) {
        // This method should remove an item from the to-do list
        // For now, just printing the item
        System.out.println("Removing item: " + item);
    }
}
