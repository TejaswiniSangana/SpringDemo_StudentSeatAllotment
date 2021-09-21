package com.example.springdemo.data.entity;

import javax.persistence.*;

@Entity
@Table(name="DEPARTMENT")
public class Department {
    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentId;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
