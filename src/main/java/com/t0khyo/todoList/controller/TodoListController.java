package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.dto.TodoListDTO;
import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.service.TodoListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-lists")
public class TodoListController {
    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    // Get all todoLists
    @GetMapping("/")
    public ResponseEntity<List<TodoList>> getAllTodoLists() {
        return new ResponseEntity<>(todoListService.findAll(), HttpStatus.FOUND);
    }

    // Get a todoList by its ID
    @GetMapping("/{todoListId}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable("todoListId") Long todoListId) {
        TodoList todoList = todoListService.findById(todoListId);
        return new ResponseEntity<>(todoList, HttpStatus.FOUND);
    }

    @GetMapping("/{todoListId}/tasks")
    public ResponseEntity<List<Task>> getTasks(@PathVariable("todoListId") long todoListId) {
        return ResponseEntity.ok(todoListService.findById(todoListId).getTasks());
    }

    // Create a new todoList
    @PostMapping("/")
    public ResponseEntity<TodoList> createTodoList(@RequestBody @Valid TodoListDTO todoListDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoListService.save(todoListDTO));
    }

    // Update a todoList by its ID
    @PutMapping("/{todoListId}")
    public ResponseEntity<TodoList> updateTodoList(
            @PathVariable("todoListId") Long todoListId,
            @RequestBody @Valid TodoListDTO todoListDTO
    ) {
        return ResponseEntity.ok(todoListService.update(todoListId, todoListDTO));
    }

    // Delete a todoList by its ID
    @DeleteMapping("/{todoListId}")
    public ResponseEntity<String> deleteTodoList(@PathVariable("todoListId") long todoListId) {
        todoListService.deleteById(todoListId);
        return ResponseEntity.ok().build();
    }
}
