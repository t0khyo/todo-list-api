package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.repository.TodoListRepository;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository repository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TodoList> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TodoList> findById(Long todoId) {
        return repository.findById(todoId);
    }

    @Override
    public TodoList save(TodoList theTodoList) {
        return repository.save(theTodoList);
    }

    @Override
    public Optional<TodoList> update(Long providedId,TodoList providedTodo) {
        if (repository.existsById(providedId)) {
            providedTodo.setId(providedId);
            TodoList updatedTodoList = repository.save(providedTodo);
            return Optional.of(updatedTodoList);
        }
        return Optional.empty();
    }

    @Override
    public String deleteById(Long theId) {
        if (repository.existsById(theId)) {
            repository.deleteById(theId);
            return "success";
        } else {
            return "failed";
        }
    }
}
