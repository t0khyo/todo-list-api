package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.repository.TodoListRepository;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoListServiceImpl implements TodoListService {
    private TodoListRepository repository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TodoList> findAll() {
        return null;
    }

    @Override
    public TodoList findById(Long aLong) {
        return null;
    }

    @Override
    public void save(TodoList entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
