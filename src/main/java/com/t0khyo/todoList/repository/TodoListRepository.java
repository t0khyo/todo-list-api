package com.t0khyo.todoList.repository;

import com.t0khyo.todoList.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}