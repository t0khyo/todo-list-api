package com.t0khyo.todoList.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID, DTO> {

    List<T> findAll();

    T findById(ID id);

    T save(DTO dto);

    Optional<T> update(ID id,DTO dto);

    String deleteById(ID id);

    boolean existsById(ID id);
}
