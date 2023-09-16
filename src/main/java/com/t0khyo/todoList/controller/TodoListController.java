package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.dto.TodoListDTO;
import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.service.TodoListService;
import jakarta.validation.Valid;
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

    // Create a new todoList
    @PostMapping("/")
    public ResponseEntity<TodoList> createTodoList(@RequestBody @Valid TodoListDTO todoListDTO) {
        TodoList newTodList = todoListService.save(todoListDTO);
        return new ResponseEntity<>(newTodList, HttpStatus.CREATED);
    }

    // Update a todoList by its ID
    @PutMapping("/{todoListId}")
    public ResponseEntity<TodoList> updateTodoList(
            @PathVariable("todoListId") Long todoListId,
            @RequestBody @Valid TodoListDTO todoListDTO
    ) {
        TodoList updatedTodoList = todoListService.update(todoListId, todoListDTO);
        return ResponseEntity.ok(updatedTodoList);
    }

    // Delete a todoList by its ID
    @DeleteMapping("/{todoListId}")
    public ResponseEntity<String> deleteTodoList(@PathVariable("todoListId") long todoListId) {
        todoListService.deleteById(todoListId);
        return ResponseEntity.noContent().build();
    }
}
