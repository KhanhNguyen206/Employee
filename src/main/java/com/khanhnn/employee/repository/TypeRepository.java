package com.khanhnn.employee.repository;

import com.khanhnn.employee.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TypeRepository extends PagingAndSortingRepository <Type, Integer> {
}
