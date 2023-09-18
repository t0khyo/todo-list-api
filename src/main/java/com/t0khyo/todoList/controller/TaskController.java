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


@RestController
@RequestMapping("/api/v1/todo-lists/{todoListId}/tasks")
public class TaskController {
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasksByListId(@PathVariable("todoListId") long todoListId) {
        return new ResponseEntity<>(taskService.findAllByTodoListId(todoListId), HttpStatus.FOUND);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable("todoListId") long todoListId, @PathVariable("taskId") long taskId) {
        taskService.verifyTaskBelongsToTodoList(taskId, todoListId);
        Task theTask = taskService.findById(taskId);
        return new ResponseEntity<>(theTask, HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@PathVariable("todoListId") long todoListId, @RequestBody TaskDTO taskDTO) {
        Task savedTask = taskService.save(todoListId, taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable("todoListId") long todoListId,
            @PathVariable("taskId") long taskId,
            @RequestBody TaskDTO taskDTO
    ) {
        taskService.verifyTaskBelongsToTodoList(taskId, todoListId);
        Task updatedTask = taskService.update(taskId, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("todoListId") long todoListId,
                                        @PathVariable("taskId") long taskId
    ) {
        taskService.verifyTaskBelongsToTodoList(taskId, todoListId);
        taskService.deleteById(taskId);
        return ResponseEntity.noContent().build();
    }
}
