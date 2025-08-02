package com.moshecode.todo1.Service;

import com.moshecode.todo1.data.ToDo;
import java.util.List;

public interface ToDoService {
    List<ToDo> getTodosForUser(String username);
    ToDo addToDoItem(String username, ToDo todo);
    ToDo markAsCompleted(String username, Long id);
    void removeToDoItem(String username, Long id);
}
