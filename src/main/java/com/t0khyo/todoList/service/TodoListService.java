package com.t0khyo.todoList.service;

import com.t0khyo.todoList.dto.TodoListDTO;
import com.t0khyo.todoList.entity.TodoList;

import java.util.List;

public interface TodoListService {
    List<TodoList> findAll();

    TodoList findById(Long todoListId);

    TodoList save(TodoListDTO todoListDTO);

    TodoList update(Long todoListId, TodoListDTO todoListDTO);

    void deleteById(Long todoListId);
}