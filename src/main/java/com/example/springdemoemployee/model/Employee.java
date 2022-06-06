package com.example.springdemoemployee.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {

    @Id
    String id;
    String fullName;
    String gender;
    String phoneNumber;
    String email;

}
