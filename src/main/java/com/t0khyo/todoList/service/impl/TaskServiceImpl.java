package com.t0khyo.todoList.service.impl;

import com.t0khyo.todoList.dto.TaskDTO;
import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.exception.TaskNotBelongingToTodoListException;
import com.t0khyo.todoList.exception.TaskNotFoundException;
import com.t0khyo.todoList.repository.TaskRepository;
import com.t0khyo.todoList.service.TaskService;
import com.t0khyo.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// ToDo: implement the methods and add clear exceptions from 'com.t0khyo.todoList.exception' package
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TodoListService todoListService;

    @Autowired
    public TaskServiceImpl(TaskRepository repository, TodoListService todoListService) {
        this.repository = repository;
        this.todoListService = todoListService;
    }

    @Override
    public List<Task> findAllByTodoListId(long todoListId) {
        return repository.findAllByTodoListId(todoListId);
    }

    @Override
    public Task findById(Long taskId) {
        return repository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    @Override
    public Task save(long todoListId, TaskDTO taskDTO) {
        Task newTask = new Task(taskDTO.getTitle(), taskDTO.getDueDate());
        newTask.setTodoList(todoListService.findById(todoListId));
        return repository.save(newTask);
    }

    @Override
    public Task update(Long taskId, TaskDTO taskDTO) {
        Task theTask = repository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        theTask.setTitle(taskDTO.getTitle());
        theTask.setDueDate(taskDTO.getDueDate());

        return repository.save(theTask);
    }

    @Override
    public void deleteById(Long taskId) {
        if (!repository.existsById(taskId)) {
            throw new TaskNotFoundException(taskId);
        }
        repository.deleteById(taskId);
    }

    @Override
    public boolean existsById(Long taskId) {
        return repository.existsById(taskId);
    }

    @Override
    public void verifyTaskBelongsToTodoList(Long taskId, Long todoListId) {
        boolean belongsToTodoList = repository.countByTaskIdAndTodoListId(taskId, todoListId) > 0;
        if (!belongsToTodoList) {
            throw new TaskNotBelongingToTodoListException(taskId, todoListId);
        }
    }
}
