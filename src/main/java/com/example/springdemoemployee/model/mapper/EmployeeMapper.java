package com.example.springdemoemployee.model.mapper;

import com.example.springdemoemployee.model.Employee;
import com.example.springdemoemployee.model.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    Employee toEmployee(EmployeeDto employeeDto);
}
