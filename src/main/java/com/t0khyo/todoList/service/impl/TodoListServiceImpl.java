package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.dto.TodoListDTO;
import com.t0khyo.todoList.entity.TodoList;
import com.t0khyo.todoList.exception.TodoListNotFoundException;
import com.t0khyo.todoList.repository.TodoListRepository;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findAll();
    }

    @Override
    public TodoList findById(Long todoListId) {
        return repository.findById(todoListId)
                .orElseThrow(() -> new TodoListNotFoundException(todoListId));
    }

    @Override
    public TodoList save(TodoListDTO todoListDTO) {
        TodoList newTodoList = new TodoList(todoListDTO.getName());
        return repository.save(newTodoList);
    }

    @Override
    public TodoList update(Long todoListId, TodoListDTO todoListDTO) {
        // Find todoList to update by its ID
        TodoList existingTodoList = repository.findById(todoListId)
                .orElseThrow(() -> new TodoListNotFoundException(todoListId));

        // update  the todoList with data form the DTO
        existingTodoList.setName(todoListDTO.getName());

        // save the updated todoList
        return repository.save(existingTodoList);
    }

    @Override
    public void deleteById(Long todoListId) {
        if (!repository.existsById(todoListId)) {
            throw new TodoListNotFoundException(todoListId);
        }
        repository.deleteById(todoListId);
    }
}
