package com.t0khyo.todoList.handler;

import com.t0khyo.todoList.dto.CustomErrorResponse;
import com.t0khyo.todoList.exception.TaskNotBelongingToTodoListException;
import com.t0khyo.todoList.exception.TaskNotFoundException;
import com.t0khyo.todoList.exception.TodoListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler({TodoListNotFoundException.class, TaskNotFoundException.class})
    public ResponseEntity<CustomErrorResponse> handleEntityNotFoundException(RuntimeException e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInValidArgumentException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();

        e.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

    @ExceptionHandler(TaskNotBelongingToTodoListException.class)
    public ResponseEntity<CustomErrorResponse> handleTaskNotBelongingTodoListException(TaskNotBelongingToTodoListException e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
