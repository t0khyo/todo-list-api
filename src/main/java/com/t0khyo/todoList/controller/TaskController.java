package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.dto.CustomErrorResponse;
import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.service.TaskService;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-lists/{todoListId}/tasks")
public class TaskController {
    TaskService taskService;
    TodoListService todoListService;

    @Autowired
    public TaskController(TaskService taskService, TodoListService todoListService) {
        this.taskService = taskService;
        this.todoListService = todoListService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTasks(@PathVariable("todoListId") Long todoListId) {
        if (todoListService.existsById(todoListId)) {
            List<Task> tasks = taskService.findAllByTodoListId(todoListId);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorResponse("Couldn't find todo list with id: " + todoListId));
        }
    }
}
