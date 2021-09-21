package com.example.springdemo.data.repository;

import com.example.springdemo.data.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {
}
