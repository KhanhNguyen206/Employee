package com.khanhnn.employee.repository;

import com.khanhnn.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository <Employee, Integer> {
    Page <Employee> findAllByNameContainingOrEmployeeCodeContaining(String name, String code, Pageable pageable);
}
