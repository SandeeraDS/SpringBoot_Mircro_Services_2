package com.ds.microservices.departmentservice;

import com.ds.microservices.departmentservice.bean.DepartmentBean;
import com.ds.microservices.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DepartmentServiceApplication {

    @Autowired
    private DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @PostConstruct
    private void createInitialDepartment() {
        List<DepartmentBean> list = new ArrayList<>();

        for (int x = 1; x < 11; x++) {
            list.add(new DepartmentBean(0, "Department " + x, "address " + x, 100 + x + ""));
        }
        departmentRepository.saveAll(list);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
