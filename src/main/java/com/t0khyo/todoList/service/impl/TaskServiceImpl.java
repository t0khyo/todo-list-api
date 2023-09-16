package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.dto.TaskDTO;
import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.repository.TaskRepository;
import com.t0khyo.todoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// ToDo: implement the methods and add clear exceptions from 'com.t0khyo.todoList.exception' package
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public Task findById(Long taskId) {
        return null;
    }

    @Override
    public Task save(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public Task update(Long providedId, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void deleteById(Long taskId) {

    }

    @Override
    public boolean existsById(Long theId) {
        return repository.existsById(theId);
    }
}
