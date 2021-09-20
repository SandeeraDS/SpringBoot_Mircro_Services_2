package com.ds.microservices.departmentservice.service;

import com.ds.microservices.departmentservice.bean.DepartmentBean;
import com.ds.microservices.departmentservice.model.DepartmentDetails;
import com.ds.microservices.departmentservice.model.User;
import com.ds.microservices.departmentservice.repository.DepartmentRepository;
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
public class DepartmentService {
    private static final Logger logger = LogManager.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public DepartmentBean addNewDepartment(DepartmentBean departmentBean) {
        logger.info("[DepartmentService.java:29] addNewDepartment");
        departmentRepository.save(departmentBean);
        return departmentBean;
    }

    public DepartmentBean getDepartmentById(long id) {
        logger.info("[DepartmentService.java:35] getDepartmentById");
        return departmentRepository.findByDepartmentId(id);
    }

    public List<DepartmentBean> getAllDepartment() {
        logger.info("[DepartmentService.java:40] getAllDepartment");
        return departmentRepository.findAll();
    }

    public DepartmentDetails getDepartmentWithUsersById(long departmentId) {
        logger.info("[DepartmentService.java:45] getDepartmentWithUsersById");
        DepartmentDetails departmentDetails = new DepartmentDetails();
        logger.info("[DepartmentService.java:47] get department info");
        DepartmentBean departmentBean = departmentRepository.findByDepartmentId(departmentId);
        logger.info("[DepartmentService.java:49] department info: {}", departmentBean);
        departmentDetails.setDepartmentInfo(departmentBean);

        logger.info("[DepartmentService.java:52] get users from user service");
        List<User> listOfUsers = restTemplate.getForObject("http://USER-SERVICE/users/getByDepartmentId/" + departmentId, List.class);
        logger.info("[DepartmentService.java:54] list of users :{}", listOfUsers);
        departmentDetails.setListOfUsers(listOfUsers);
        return departmentDetails;
    }
}
