package com.ds.microservices.userservice.repository;

import com.ds.microservices.userservice.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Long> {

    UserBean findByUserId(long id);

    List<UserBean> findByUserDepartmentId(long departmentId);
}
