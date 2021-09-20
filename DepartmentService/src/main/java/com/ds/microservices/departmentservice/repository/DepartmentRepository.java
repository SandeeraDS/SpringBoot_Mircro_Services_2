package com.ds.microservices.departmentservice.repository;

import com.ds.microservices.departmentservice.bean.DepartmentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentBean, Long> {

    DepartmentBean findByDepartmentId(long id);
}
