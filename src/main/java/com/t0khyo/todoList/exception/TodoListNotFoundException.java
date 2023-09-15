package com.t0khyo.todoList.exception;

public class TodoListNotFoundException extends RuntimeException {
    public TodoListNotFoundException(long todoListId) {
        super("TodoList not found with ID: " + todoListId);
    }
}
