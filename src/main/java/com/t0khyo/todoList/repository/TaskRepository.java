package com.t0khyo.todoList.repository;

import com.t0khyo.todoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT COUNT(t) > 0 FROM Task t WHERE t.id = :taskId AND t.todoList.id = :todoListId")
    boolean taskBelongsToTodoList(@Param("taskId") Long taskId, @Param("todoListId") Long todoListId);

    List<Task> findAllByTodoListId(long todoListId);

    @Query("SELECT COUNT(tl) > 0 FROM TodoList tl WHERE tl.id = :todoListId")
    boolean todoListExistsById(@Param("todoListId") Long todoListId);
}