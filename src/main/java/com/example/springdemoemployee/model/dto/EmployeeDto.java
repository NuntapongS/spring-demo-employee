package com.example.springdemoemployee.model.dto;

import lombok.*;

import org.springframework.data.annotation.Id;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
}
