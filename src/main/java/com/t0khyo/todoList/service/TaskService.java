package com.t0khyo.todoList.service;

import com.t0khyo.todoList.dto.TaskDTO;
import com.t0khyo.todoList.entity.Task;

import java.util.List;

public interface TaskService extends BaseService<Task, Long, TaskDTO> {
    List<Task> findAllByTodoListId(long todoListId);

    Task save(long todoListId, TaskDTO taskDTO);

    void verifyTaskBelongsToTodoList(Long taskId, Long todoListId);
}