package com.moshecode.todo1.data;

public class ToDo {
    private String title;
    private String description;
    private boolean completed;
    private Long id;

    public ToDo(String title, String description) {
        //create a random ID for the ToDo item
        this.id = System.currentTimeMillis(); // Simple way to generate a unique ID
        this.title = title;
        this.description = description;
        this.completed = false; // Default to
}
