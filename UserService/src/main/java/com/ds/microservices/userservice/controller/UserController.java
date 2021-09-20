package com.ds.microservices.userservice.controller;

import com.ds.microservices.userservice.bean.UserBean;
import com.ds.microservices.userservice.model.UserDetails;
import com.ds.microservices.userservice.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/AddUser")
    public UserBean addNewUser(@RequestBody UserBean userBean) {
        logger.info("[UserController.java:24] adding new user : {}", userBean);
        return userService.addNewUser(userBean);
    }

    @GetMapping("/GetByUserId/{id}")
    public UserBean getUserById(@PathVariable long id) {
        logger.info("[UserController.java:30] get user info by id: {}", id);
        return userService.getUserById(id);
    }

    @GetMapping("/GetAllUsers")
    public List<UserBean> getAllUserList() {
        logger.info("[UserController.java:36] get all user list");
        return userService.getAllUsers();
    }

    @GetMapping("/getByDepartmentId/{departmentId}")
    public List<UserBean> getUsersByDepartmentId(@PathVariable long departmentId) {
        logger.info("[UserController.java:42] get list of users by department id: {}", departmentId);
        return userService.getUsersByDepartmentId(departmentId);
    }

    @GetMapping("/getUserWithDepartmentInfo/{userId}")
    public UserDetails getUserWithDepartmentInfo(@PathVariable long userId) {
        logger.info("[UserController.java:48] get list of user details with department info by user id: {}", userId);
        return userService.getUserWithDepartmentInfo(userId);
    }
}
