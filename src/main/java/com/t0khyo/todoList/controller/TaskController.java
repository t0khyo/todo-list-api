package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.service.TaskService;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 *  ToDo: after refactor the service layer and handle exceptions do the following
 *   - keep on mind to refactor parameters and return values
 *   - implement getTaskByID()
 *   - implement createTask() with TaskDTO
 *   - implement updateTask() with TaskDTO
 *   - implement deleteTask()
 */


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
        return null;
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable("taskId") long taskId) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<?> createTask(@PathVariable("todoListId") long todoListId, @RequestBody Task theTask) {
        return null;
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable("todoListId") long todoListId,
                                        @PathVariable("taskId") long taskId,
                                        @RequestBody Task providedTask
    ) {
        return null;
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("todoListId") long todoListId,
                                        @PathVariable("taskId") long taskId
    ) {
       return null;
    }
}
