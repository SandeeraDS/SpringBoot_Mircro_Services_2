package com.ds.microservices.userservice.model;

import com.ds.microservices.userservice.bean.UserBean;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetails {

    private UserBean userBean;
    private Department department;

}
