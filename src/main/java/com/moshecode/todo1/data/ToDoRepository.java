package com.moshecode.todo1.data;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}

