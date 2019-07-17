package com.khanhnn.employee.service.impl;

import com.khanhnn.employee.model.Type;
import com.khanhnn.employee.repository.TypeRepository;
import com.khanhnn.employee.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Page <Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type findById(Integer id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void remove(Integer id) {
        typeRepository.deleteById(id);
    }
}
