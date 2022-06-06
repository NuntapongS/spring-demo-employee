package com.example.springdemoemployee.controller;

import com.example.springdemoemployee.model.Employee;
import com.example.springdemoemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employee")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployeeList() throws Exception{
        return new ResponseEntity<>(employeeService.getEmployeeList(), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable (value = "employeeId")String employeeId) throws Exception {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee dataRequest) throws Exception {
        return new ResponseEntity<>(employeeService.addEmployee(dataRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateInfoEmployee(@PathVariable (value = "employeeId")String employeeId, Employee dataRequest) throws Exception {
        return new ResponseEntity<>(employeeService.updateInfoEmployee(employeeId, dataRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable (value = "employeeId")String employeeId) throws Exception {
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
    }




}
