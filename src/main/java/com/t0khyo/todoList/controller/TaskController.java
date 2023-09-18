package com.t0khyo.todoList.controller;

import com.t0khyo.todoList.dto.TaskDTO;
import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  ToDo: after refactor the service layer and handle exceptions do the following
 *   - keep on mind to refactor parameters and return values
 *   - implement getTaskByID()
 *   - implement createTask() with TaskDTO
 *   - implement updateTask() with TaskDTO
 *   - implement deleteTask()
 */

// todo: remove todoList id
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable("taskId") long taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(taskId));
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestParam("todoListId") long todoListId, @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(todoListId, taskDTO));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable("taskId") long taskId,
            @RequestBody TaskDTO taskDTO
    ) {
        return ResponseEntity.ok(taskService.update(taskId, taskDTO));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(
            @PathVariable("taskId") long taskId
    ) {
        taskService.deleteById(taskId);
        return ResponseEntity.ok().build();
    }
}
