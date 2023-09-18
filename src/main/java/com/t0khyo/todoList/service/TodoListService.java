package com.t0khyo.todoList.service;

import com.t0khyo.todoList.dto.TodoListDTO;
import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TodoList;

import java.util.List;

public interface TodoListService extends BaseService<TodoList, Long, TodoListDTO> {
    List<TodoList> findAll();
    List<Task> findAllTasksByTodoListId(Long todoListId);

    TodoList save(TodoListDTO todoListDTO);
}