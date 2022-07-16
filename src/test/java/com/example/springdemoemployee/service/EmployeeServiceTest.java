package com.example.springdemoemployee.service;

import com.example.springdemoemployee.model.Employee;
import com.example.springdemoemployee.model.mapper.EmployeeMapper;
import com.example.springdemoemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

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

}
