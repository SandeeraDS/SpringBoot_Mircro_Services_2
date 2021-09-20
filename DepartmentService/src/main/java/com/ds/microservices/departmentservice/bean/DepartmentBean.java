package com.ds.microservices.departmentservice.bean;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPARTMENT_ID")
    private long departmentId;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "DEPARTMENT_ADDRESS")
    private String departmentAddress;
    @Column(name = "DEPARTMENT_CODE")
    private String departmentCode;
}
