package com.t0khyo.todoList.repository;

import com.t0khyo.todoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT COUNT(t) FROM Task t WHERE t.id = :taskId AND t.todoList.id = :todoListId")
    int countByTaskIdAndTodoListId(@Param("taskId") Long taskId, @Param("todoListId") Long todoListId);
}