package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  ToDo:   after refactor the service layer and handle exceptions do the following
 *   - implement getTodoLists()
 *   - implement getTodoListByID()
 *   - implement createTodoList() with TodoListDTO
 *   - implement updateTodoList() with TodoListDTO
 *   - implement deleteTodoList()
 */

@RestController
@RequestMapping("/api/v1/todo-lists")
public class TodoListController {
    private final TodoListService todoService;

    @Autowired
    public TodoListController(TodoListService todoService) {
        this.todoService = todoService;
    }

    // Get all todoLists
    @GetMapping("/")
    public ResponseEntity<List<TodoList>> getAllTodoLists() {
        return null;
    }

    // Get a todoList by its ID
    @GetMapping("/{todoListId}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable("todoListId") Long todoListId) {
        return null;
    }

    // Create a new todoList
    @PostMapping("/")
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList) {
        return null;
    }

    // Update a todoList by its ID
    @PutMapping("/{todoListId}")
    public ResponseEntity<TodoList> updateTodoList(
            @PathVariable("todoListId") Long todoListId,
            @RequestBody TodoList providedTodo
    ) {
        return null;
    }

    // Delete a todoList by its ID
    @DeleteMapping("/{todoListId}")
    public ResponseEntity<String> deleteTodoList(@PathVariable("todoListId") long todoListId) {
        return null;
    }
}
