package com.ds.microservices.userservice;

import com.ds.microservices.userservice.bean.UserBean;
import com.ds.microservices.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @PostConstruct
    private void createInitialDepartment() {
        Random rand = new Random();
        List<UserBean> list = new ArrayList<>();

        for (int x = 1; x < 101; x++) {
            list.add(new UserBean(0, "User Name " + x, rand.nextInt(10) + 1));
        }
        userRepository.saveAll(list);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
