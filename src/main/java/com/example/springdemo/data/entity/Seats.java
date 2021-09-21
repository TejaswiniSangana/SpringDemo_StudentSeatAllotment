package com.example.springdemo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "SEATS")
public class Seats {
    @Id
    @Column(name = "SEAT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seatId;



    @Column(name="STUDENT_ID")
    private int studentId;

    @Column(name="DEPARTMENT_ID")
    private int departmentId;


    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


}
