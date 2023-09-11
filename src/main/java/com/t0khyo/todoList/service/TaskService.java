package com.t0khyo.todoList.service;

import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TaskStatus;

import java.time.LocalDate;
import java.util.List;

public interface TaskService extends BaseService<Task, Long> {

    // Updates task status by ID, returning 'success', 'invalid_status' for invalid status values, and 'not_found'.

    String updateTaskStatusById(Long theId, TaskStatus theStatus);

    String updateTaskDueDateById(Long taskId, LocalDate newDueDate);

    List<Task> findAllByTodoListId(Long TodoListId);
}