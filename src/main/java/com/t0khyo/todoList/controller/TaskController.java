package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.dto.CustomErrorResponse;
import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.service.TaskService;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> getAllTasks(@PathVariable("todoListId") long todoListId) {
        if (todoListService.existsById(todoListId)) {
            List<Task> tasks = taskService.findAllByTodoListId(todoListId);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorResponse("Couldn't find todo list with id: " + todoListId));
        }
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable("taskId") long taskId) {
        Optional<Task> taskOptional = taskService.findById(taskId);

        if (taskOptional.isPresent()) {
            return new ResponseEntity<>(taskOptional.get(), HttpStatus.FOUND);
        } else {
            CustomErrorResponse errorResponse = new CustomErrorResponse("Couldn't find task with id: " + taskId);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createTask(@PathVariable("todoListId") long todoListId, @RequestBody Task theTask) {
        Optional<TodoList> todoList = todoListService.findById(todoListId);

        if (todoList.isPresent()) {
            theTask.setTodoList(todoList.get());
            Task savedTask = taskService.save(theTask);

            // Build the URI for the newly created resource
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{taskId}")
                    .buildAndExpand(savedTask.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorResponse("Couldn't find todo list with id: " + todoListId));
        }
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable("todoListId") long todoListId,
                                        @PathVariable("taskId") long taskId,
                                        @RequestBody Task providedTask
    ) {
        Optional<TodoList> todoList = todoListService.findById(todoListId);
        Optional<Task> task = taskService.findById(taskId);
        if (todoList.isPresent()) {
            if (task.isPresent()) {
                taskService.update(taskId, providedTask);
                return ResponseEntity.ok().build();
            } else {
                CustomErrorResponse errorResponse = new CustomErrorResponse("Couldn't find task with id: " + taskId);
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorResponse("Couldn't find todo list with id: " + todoListId));
        }
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("todoListId") long todoListId,
                                        @PathVariable("taskId") long taskId
    ) {
        Optional<TodoList> todoList = todoListService.findById(todoListId);
        Optional<Task> task = taskService.findById(taskId);

        if (todoList.isPresent()) {
            if (task.isPresent()) {
                taskService.deleteById(taskId);
                return ResponseEntity.noContent().build();
            } else {
                CustomErrorResponse errorResponse = new CustomErrorResponse("Couldn't find task with id: " + taskId);
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorResponse("Couldn't find todo list with id: " + todoListId));
        }
    }
}
