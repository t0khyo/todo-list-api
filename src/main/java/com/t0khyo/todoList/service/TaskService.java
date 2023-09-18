package com.t0khyo.todoList.service;

import com.t0khyo.todoList.dto.TaskDTO;
import com.t0khyo.todoList.entity.Task;

import java.util.List;

public interface TaskService {
    Task findById(Long taskId);

    Task save(long todoListId, TaskDTO taskDTO);

    Task update(Long taskId, TaskDTO taskDTO);

    void deleteById(Long taskId);
}