package com.t0khyo.todoList.exception;

public class TaskNotBelongingToTodoListException extends RuntimeException {
    public TaskNotBelongingToTodoListException(long taskId, long todoListId) {
        super("Task with ID " + taskId + " does not belong to Todo List with ID " + todoListId);
    }
}
