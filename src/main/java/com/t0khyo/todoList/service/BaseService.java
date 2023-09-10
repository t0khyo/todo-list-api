package com.t0khyo.todoList.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entity);

    Optional<T> update(ID id,T entity);

    // Deletes a TodoList by ID and returns "success" if found and deleted, or "failed" otherwise.
    String deleteById(ID id);
}
