package com.t0khyo.todoList.service;

import java.util.List;

public interface BaseService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    void save(T entity);

    void deleteById(ID id);
}
