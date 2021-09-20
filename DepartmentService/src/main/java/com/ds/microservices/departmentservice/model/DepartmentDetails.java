package com.ds.microservices.departmentservice.model;

import com.ds.microservices.departmentservice.bean.DepartmentBean;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDetails {
    private DepartmentBean departmentInfo;
    private List<User> listOfUsers;
}
