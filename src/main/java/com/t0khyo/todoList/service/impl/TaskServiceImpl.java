package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.repository.TaskRepository;
import com.t0khyo.todoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//ToDo: implement those methods
public class TaskServiceImpl implements TaskService {
    private TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Task entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
