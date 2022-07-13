package com.example.springdemoemployee.service;

import com.example.springdemoemployee.model.Employee;
import com.example.springdemoemployee.model.dto.EmployeeDto;
import com.example.springdemoemployee.model.mapper.EmployeeMapper;
import com.example.springdemoemployee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<Employee> getEmployeeList() throws Exception {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Some error occurred while retrieving the employee", e);
        }
    }

    public Employee getEmployee(String employeeId) throws Exception {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Employee not found by this id : " + employeeId));
    }

    public Employee addEmployee(EmployeeDto dataRequest) throws Exception {
        var employee = employeeMapper.toEmployee(dataRequest);
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public Employee updateInfoEmployee(String employeeId, EmployeeDto dataRequest) throws Exception {
        Employee employeeById = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Not found id to update"));
        var employee = employeeMapper.toEmployee(dataRequest);
        employee.setId(employeeById.getId());
        employee.setCreatedAt(employeeById.getCreatedAt());
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public Employee deleteEmployee(String employeeId) throws Exception {
        employeeRepository.deleteById(employeeId);
        return null;
    }
}