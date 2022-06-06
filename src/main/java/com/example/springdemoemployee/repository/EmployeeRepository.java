package com.example.springdemoemployee.repository;

import com.example.springdemoemployee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
