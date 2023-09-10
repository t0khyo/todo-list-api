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
    private final TodoListRepository TodoRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository TodoRepository) {
        this.TodoRepository = TodoRepository;
    }

    @Override
    public List<TodoList> findAll() {
        return TodoRepository.findAll();
    }

    @Override
    public Optional<TodoList> findById(Long todoId) {
        return TodoRepository.findById(todoId);
    }

    @Override
    public TodoList save(TodoList theTodoList) {
        return TodoRepository.save(theTodoList);
    }

    @Override
    public Optional<TodoList> update(TodoList providedTodo) {
        if (TodoRepository.existsById(providedTodo.getId())) {
            TodoList updatedTodoList = TodoRepository.save(providedTodo);
            return Optional.of(updatedTodoList);
        }
        return Optional.empty();
    }

    @Override
    public String deleteById(Long theId) {
        if (TodoRepository.existsById(theId)) {
            TodoRepository.deleteById(theId);
            return "success";
        } else {
            return "failed";
        }
    }
}
