package com.example.springdemoemployee.service;

import com.example.springdemoemployee.model.Employee;
import com.example.springdemoemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeList() throws Exception {
        List<Employee> employeeList;
        try {
            employeeList = employeeRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Some error occurred while retrieving the employee", e);
        }
        return employeeList;
    }

    public Employee getEmployee(String employeeId) throws Exception {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Employee not found by this id : " + employeeId));
    }

    public Employee addEmployee(Employee dataRequest) throws Exception {
        try {
            return employeeRepository.save(dataRequest);
        } catch (Exception e) {
            throw new Exception("Error while add employee");
        }
    }

    public Employee updateInfoEmployee(String employeeId, Employee dataRequest) throws Exception {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Not found id to update"));
    }

    public Employee deleteEmployee(String employeeId) throws Exception {
        employeeRepository.deleteById(employeeId);
        return null;
    }
}
