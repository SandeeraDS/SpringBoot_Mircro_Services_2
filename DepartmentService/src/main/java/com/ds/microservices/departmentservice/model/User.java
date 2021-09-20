package com.ds.microservices.departmentservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private long userId;
    private String userName;
    private long userDepartmentId;
}
