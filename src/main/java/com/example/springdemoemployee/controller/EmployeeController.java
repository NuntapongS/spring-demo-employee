package com.example.springdemoemployee.controller;

import com.example.springdemoemployee.model.Employee;
import com.example.springdemoemployee.model.dto.EmployeeDto;
import com.example.springdemoemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/odds-api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployeeList() throws Exception{
        return new ResponseEntity<>(employeeService.getEmployeeList(), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable (value = "employeeId")String employeeId) throws Exception {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto dataRequest) {
        return new ResponseEntity<>(employeeService.addEmployee(dataRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateInfoEmployee(@PathVariable (value = "employeeId")String employeeId, EmployeeDto dataRequest) throws Exception {
        return new ResponseEntity<>(employeeService.updateInfoEmployee(employeeId, dataRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable (value = "employeeId")String employeeId) {
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
    }
}
