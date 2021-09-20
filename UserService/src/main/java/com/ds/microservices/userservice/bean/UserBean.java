package com.ds.microservices.userservice.bean;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_DEPARTMENT_ID")
    private long userDepartmentId;
}
