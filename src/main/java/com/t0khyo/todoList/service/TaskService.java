package com.t0khyo.todoList.service;

import com.t0khyo.todoList.entity.Task;

public interface TaskService extends BaseService<Task, Long> {

    // Updates task status by ID, returning 'success', 'invalid_status' for invalid status values, and 'not_found'.
    String updateTaskStatusById(Long theId, String theStatus);
}