package com.moshecode.todo1.controller;

import com.moshecode.todo1.data.ToDo;
import com.moshecode.todo1.Service.ToDoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ToDoController.class)
@Import(ToDoController.class)
class ToDoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    void getAllTodos_returnsList() throws Exception {
        ToDo todo1 = new ToDo("Title1", "Desc1");
        ToDo todo2 = new ToDo("Title2", "Desc2");
        Mockito.when(toDoService.getToDoList()).thenReturn(Arrays.asList(todo1, todo2));
        mockMvc.perform(get("/todo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title1"))
                .andExpect(jsonPath("$[1].title").value("Title2"));
    }

    @Test
    void createTodo_savesAndReturnsTodo() throws Exception {
        ToDo todo = new ToDo("Title", "Desc");
        Mockito.when(toDoService.addToDoItem(Mockito.any(ToDo.class))).thenReturn(todo);
        mockMvc.perform(post("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Title\",\"description\":\"Desc\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.description").value("Desc"));
    }
}
