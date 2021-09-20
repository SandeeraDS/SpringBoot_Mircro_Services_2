package com.ds.microservices.departmentservice.controller;

import com.ds.microservices.departmentservice.bean.DepartmentBean;
import com.ds.microservices.departmentservice.model.DepartmentDetails;
import com.ds.microservices.departmentservice.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private static final Logger logger = LogManager.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/AddDepartment")
    public DepartmentBean addNewDepartment(@RequestBody DepartmentBean departmentBean) {
        logger.info("[DepartmentController.java:23] adding new department : {}", departmentBean);
        return departmentService.addNewDepartment(departmentBean);
    }

    @GetMapping("/GetByDepartmentId/{id}")
    public DepartmentBean getDepartmentById(@PathVariable long id) {
        logger.info("[DepartmentController.java:29] get department info by id: {}", id);
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/GetAllDepartments")
    public List<DepartmentBean> getAllDepartmentList() {
        logger.info("[DepartmentController.java:35] get all department list");
        return departmentService.getAllDepartment();
    }

    @GetMapping("/GetDepartmentWithUsersById/{departmentId}")
    public DepartmentDetails getDepartmentWithUsersById(@PathVariable  long departmentId){
        logger.info("[DepartmentController.java:41] get department details with respective users for deparment id: {}", departmentId);
        return departmentService.getDepartmentWithUsersById(departmentId);
    }

}
