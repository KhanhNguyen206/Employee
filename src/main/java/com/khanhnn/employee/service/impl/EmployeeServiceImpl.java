package com.khanhnn.employee.service.impl;

import com.khanhnn.employee.model.Employee;
import com.khanhnn.employee.repository.EmployeeRepository;
import com.khanhnn.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page <Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page <Employee> findAllByNameContainingOrEmployeeCodeContaining(String name, String code, Pageable pageable) {
        return employeeRepository.findAllByNameContainingOrEmployeeCodeContaining(name, code, pageable);
    }
}
