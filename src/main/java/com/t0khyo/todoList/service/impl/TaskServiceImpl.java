package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TaskStatus;
import com.t0khyo.todoList.repository.TaskRepository;
import com.t0khyo.todoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Optional<Task> findById(Long taskId) {
        return repository.findById(taskId);
    }

    @Override
    public Task save(Task theTask) {
        return repository.save(theTask);
    }

    @Override
    public Optional<Task> update(Task providedTask) {
        Optional<Task> existingTask = repository.findById(providedTask.getId());

        if (existingTask.isPresent()) {
            Task updatedTask = existingTask.get();
            updatedTask.setTitle(providedTask.getTitle());
            updatedTask.setDueDate(providedTask.getDueDate());
            updatedTask.setStatus(providedTask.getStatus());

            return Optional.of(repository.save(updatedTask));
        }
        return Optional.empty();
    }

    @Override
    public String deleteById(Long taskId) {
        if (repository.existsById(taskId)) {
            repository.deleteById(taskId);
            return "success";
        } else {
            return "not_found";
        }
    }


    @Override
    public String updateTaskStatusById(Long taskId, TaskStatus theStatus) {
        Optional<Task> optionalTask = repository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task theTask = optionalTask.get();

            try {
                theTask.setStatus(theStatus);
                repository.save(theTask);
                return "success";
            } catch (IllegalArgumentException e) {
                return "invalid_status";
            }
        } else {
            return "not_found";
        }
    }

    @Override
    public String updateTaskDueDateById(Long taskId, LocalDate newDueDate) {
        Optional<Task> optionalTask = repository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task theTask = optionalTask.get();
            theTask.setDueDate(newDueDate);
            repository.save(theTask);
            return "success";
        } else {
            return "not_found";
        }
    }
}