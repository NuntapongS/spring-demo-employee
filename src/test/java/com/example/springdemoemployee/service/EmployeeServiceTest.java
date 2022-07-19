package com.example.springdemoemployee.service;

import com.example.springdemoemployee.model.Employee;
import com.example.springdemoemployee.model.dto.EmployeeDto;
import com.example.springdemoemployee.model.mapper.EmployeeMapper;
import com.example.springdemoemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    EmployeeMapper employeeMapper = mock(EmployeeMapper.class);
    EmployeeService employeeService = new EmployeeService(employeeRepository, employeeMapper);

    @Test
    void getEmployee() throws Exception {
        // Arrange
        var localDateTimeNow = LocalDateTime.now();
        var employee = new Employee(
                "1234",
                "Nuntapong Siripanyawong",
                "Male",
                "0831757157",
                "nuntapong@odds.team",
                localDateTimeNow,
                localDateTimeNow
        );
        String employeeId = employee.getId();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
        // Act
        var employeeRes = employeeService.getEmployee(employeeId);
        // Assert
        assertThat(employeeRes.getId()).isEqualTo("1234");
        verify(employeeRepository).findById(employeeId);
    }

    @Test
    void addEmployee() {
        // Arrange
        var localDateTimeNow = LocalDateTime.now();
        var employeeReq = new EmployeeDto(
                "Nuntapong",
                "Siripanyawong",
                "Male",
                "nuntapong@odds.team",
                "0831757157"
        );
        var employeeRes = new Employee(
                "1234",
                "Nuntapong Siripanyawong",
                "Male",
                "0831757157",
                "nuntapong@odds.team",
                localDateTimeNow,
                localDateTimeNow
        );
        when(employeeMapper.toEmployee(employeeReq)).thenReturn(employeeRes);
        var employee = employeeMapper.toEmployee(employeeReq);
        when(employeeRepository.save(employee)).thenReturn(employeeRes);
        // Act
        var addedEmployeeRes = employeeService.addEmployee(employeeReq);
        // Assert
        assertThat(addedEmployeeRes.getId()).isEqualTo("1234");
        assertThat(addedEmployeeRes.getCreatedAt()).isNotNull();
        assertThat(addedEmployeeRes.getUpdatedAt()).isNotNull();

        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(captor.capture());
    }

    @Test
    void updateEmployee() throws Exception {
        // Arrange
        var employeeReqId = "1234";
        var localDateTimeNow = LocalDateTime.now();
        var employeeReq = new EmployeeDto(
                "Nuntapong",
                "Siripanyawong",
                "Male",
                "nuntapong.sr@gmail.com",
                "0831757157"
        );
        var employeeRes = new Employee(
                "1234",
                "Nuntapong Siripanyawong",
                "Male",
                "0831757157",
                "nuntapong@odds.team",
                localDateTimeNow,
                localDateTimeNow
        );
        when(employeeRepository.findById(employeeReqId)).thenReturn(Optional.of(employeeRes));
        when(employeeMapper.toEmployee(employeeReq)).thenReturn(employeeRes);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employeeRes);
        // Act
        var addEmployee = employeeService.updateInfoEmployee(employeeReqId, employeeReq);
        // Assert
        assertThat(addEmployee.getId()).isEqualTo("1234");
        verify(employeeRepository).save(any(Employee.class));
    }
}
