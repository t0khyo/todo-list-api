package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.repository.TodoListRepository;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoListServiceImpl implements TodoListService {
    private TodoListRepository repository;


    // constructor
    @Autowired
    public TodoListServiceImpl(TodoListRepository repository) {
        this.repository = repository;
    }
}
