package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<TodoList> todoLists = todoService.findAll();
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    // Get a todoList by its ID
    @GetMapping("/{todoListId}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable("todoListId") Long todoListId) {
        Optional<TodoList> todoList = todoService.findById(todoListId);
        return todoList.map(theTodolist -> new ResponseEntity<>(theTodolist, HttpStatus.FOUND))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new todoList
    @PostMapping("/")
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList) {
        TodoList savedTodo = todoService.save(todoList);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Update a todoList by its ID
    @PutMapping("/{todoListId}")
    public ResponseEntity<TodoList> updateTodoList(
            @PathVariable("todoListId") Long todoListId,
            @RequestBody TodoList providedTodo
    ) {
        Optional<TodoList> updatedTodoList = todoService.update(todoListId, providedTodo);
        return updatedTodoList
                .map(theTodoList -> new ResponseEntity<>(theTodoList, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a todoList by its ID
    @DeleteMapping("/{todoListId}")
    public ResponseEntity<String> deleteTodoList(@PathVariable("todoListId") long todoListId) {
        String result = todoService.deleteById(todoListId);
        if ("success".equals(result)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
