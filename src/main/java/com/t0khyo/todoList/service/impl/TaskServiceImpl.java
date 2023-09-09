package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TaskStatus;
import com.t0khyo.todoList.repository.TaskRepository;
import com.t0khyo.todoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public Optional<Task> findById(Long theId) {
        return repository.findById(theId);
    }

    @Override
    public Task save(Task theTask) {
        return repository.save(theTask);
    }

    @Override
    public Optional<Task> update(Task entity) {
        if (repository.existsById(entity.getId())) {
            Task updatedTask = repository.save(entity);
            return Optional.of(updatedTask);
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

    @Override
    public String updateTaskStatusById(Long theId, String theStatus) {
        Optional<Task> optionalTask = repository.findById(theId);
        if (optionalTask.isPresent()) {
            Task theTask = optionalTask.get();

            try {
                TaskStatus newStatus = TaskStatus.valueOf(theStatus);
                theTask.setStatus(newStatus);
                repository.save(theTask);
                return "success";
            } catch (IllegalArgumentException e) {
                return "invalid_status";
            }
        } else {
            return "not_found";
        }
    }
}