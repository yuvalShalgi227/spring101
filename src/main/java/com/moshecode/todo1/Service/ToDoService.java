package com.moshecode.todo1.Service;


public interface ToDoService {
    String getToDoList();
    void addToDoItem(String item);
    void removeToDoItem(String item);
}
