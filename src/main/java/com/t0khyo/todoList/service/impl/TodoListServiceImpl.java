package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.dto.TodoListDTO;
import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.repository.TodoListRepository;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* ToDo:
 *   * implement the methods and add clear exceptions from 'com.t0khyo.todoList.exception' package
 *   * keep in mind to review the return types and the parameters and refactor if needed amigos
 */

@Service
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository repository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TodoList> findAll() {
        return null;
    }

    @Override
    public TodoList findById(Long todoId) {
        return null;
    }

    @Override
    public TodoList save(TodoListDTO todoListDTO) {
        return null;
    }

    @Override
    public Optional<TodoList> update(Long providedId, TodoListDTO todoListDTO) {
        return null;
    }

    @Override
    public String deleteById(Long theId) {
        return null;
    }

    @Override
    public boolean existsById(Long theId) {
        return repository.existsById(theId);
    }
}
