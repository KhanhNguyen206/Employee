package com.khanhnn.employee;

import com.khanhnn.employee.service.EmployeeService;
import com.khanhnn.employee.service.TypeService;
import com.khanhnn.employee.service.impl.EmployeeServiceImpl;
import com.khanhnn.employee.service.impl.TypeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImpl();
	}

	@Bean
	public TypeService typeService() {
		return new TypeServiceImpl();
	}

}
