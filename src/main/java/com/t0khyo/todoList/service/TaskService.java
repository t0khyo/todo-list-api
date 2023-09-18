package com.t0khyo.todoList.service;

import com.t0khyo.todoList.dto.TaskDTO;
import com.t0khyo.todoList.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllByTodoListId(long todoListId);

    Task findById(Long taskId);

    Task save(long todoListId, TaskDTO taskDTO);

    Task update(Long taskId, TaskDTO taskDTO);

    void deleteById(Long taskId);

    boolean existsById(Long taskId);

    void verifyTaskBelongsToTodoList(Long taskId, Long todoListId);
}