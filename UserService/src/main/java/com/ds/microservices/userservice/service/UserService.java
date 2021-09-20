package com.ds.microservices.userservice.service;

import com.ds.microservices.userservice.bean.UserBean;
import com.ds.microservices.userservice.model.Department;
import com.ds.microservices.userservice.model.UserDetails;
import com.ds.microservices.userservice.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserBean addNewUser(UserBean userBean) {
        logger.info("[UserService.java:29] addNewUser");
        userRepository.save(userBean);
        return userBean;
    }

    public UserBean getUserById(long id) {
        logger.info("[UserService.java:35] getUserById");
        return userRepository.findByUserId(id);
    }

    public List<UserBean> getAllUsers() {
        logger.info("[UserService.java:40] getAllUsers");
        return userRepository.findAll();
    }

    public List<UserBean> getUsersByDepartmentId(long departmentId) {
        logger.info("[UserService.java:45] getUsersByDepartmentId");
        return userRepository.findByUserDepartmentId(departmentId);
    }

    public UserDetails getUserWithDepartmentInfo(long userId) {
        logger.info("[UserService.java:50] getUserWithDepartmentInfo");

        UserDetails userDetails = new UserDetails();
        logger.info("[UserService.java:53] get user info");
        UserBean userBean = userRepository.findByUserId(userId);
        logger.info("[UserService.java:55] user info: {}", userBean);
        userDetails.setUserBean(userBean);
        logger.info("[UserService.java:57] get department info");
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/GetByDepartmentId/" + userBean.getUserDepartmentId(), Department.class);
        logger.info("[UserService.java:59] department indo :{}", department);
        userDetails.setDepartment(department);

        return userDetails;
    }
}
