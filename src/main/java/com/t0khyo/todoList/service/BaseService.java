package com.t0khyo.todoList.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID, DTO> {
    T findById(ID id);

    //T save(DTO dto);

    T update(ID id,DTO dto);

    void deleteById(ID id);

    boolean existsById(ID id);
}
