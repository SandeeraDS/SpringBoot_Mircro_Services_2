package com.ds.microservices.userservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

    private long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
