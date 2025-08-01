package com.moshecode.todo1.Service;

import org.springframework.stereotype.Service;


public interface ToDo {
    String getToDoList();
    void addToDoItem(String item);
    void removeToDoItem(String item);
}
