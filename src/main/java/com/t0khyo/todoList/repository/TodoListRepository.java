package com.t0khyo.todoList.repository;

import com.t0khyo.todoList.entity.Task;
import com.t0khyo.todoList.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    @Query("SELECT t FROM Task t WHERE t.todoList.id = :todoListId")
    List<Task> findAllTasksByTodoListId(@Param("todoListId") Long todoListId);
}