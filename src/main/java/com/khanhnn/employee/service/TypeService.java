package com.khanhnn.employee.service;

import com.khanhnn.employee.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    Page <Type> findAll(Pageable pageable);

    Type findById(Integer id);

    void save(Type type);

    void remove(Integer id);
}