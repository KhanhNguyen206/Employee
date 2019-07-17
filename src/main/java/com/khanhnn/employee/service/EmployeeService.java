package com.khanhnn.employee.service;

import com.khanhnn.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page <Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

    Page <Employee> findAllByNameContainingOrEmployeeCodeContaining(String name, String code, Pageable pageable);
}