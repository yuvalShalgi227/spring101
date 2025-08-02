package com.moshecode.todo1.Service;

import com.moshecode.todo1.data.ToDo;
import com.moshecode.todo1.data.ToDoRepository;
import com.moshecode.todo1.data.User;
import com.moshecode.todo1.data.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class TodoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    @Autowired
    public TodoServiceImpl(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ToDo> getTodosForUser(String username) {
        return toDoRepository.findByOwnerUsername(username);
    }

    public ToDo addToDoItem(String username, ToDo todo) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        todo.setOwner(user);
        return toDoRepository.save(todo);
    }


    @Override
    public ToDo markAsCompleted(String username, Long id) {
        ToDo todo = toDoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setCompleted(true);
            return toDoRepository.save(todo);
        }
        return null;
    }

    @Override
    public void removeToDoItem(String username, Long id) {
        toDoRepository.deleteById(id);
    }
}
