package com.t0khyo.todoList.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(long taskId) {
        super("Task not found with ID: " + taskId);
    }
}
