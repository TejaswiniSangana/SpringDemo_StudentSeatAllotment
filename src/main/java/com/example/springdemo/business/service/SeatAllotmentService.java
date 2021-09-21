package com.example.springdemo.business.service;

import com.example.springdemo.business.domain.SeatAllotment;
import com.example.springdemo.data.entity.Department;
import com.example.springdemo.data.entity.Seats;
import com.example.springdemo.data.entity.Student;
import com.example.springdemo.data.repository.DepartmentRepository;
import com.example.springdemo.data.repository.SeatRepository;
import com.example.springdemo.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeatAllotmentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public SeatAllotmentService(StudentRepository studentRepository, DepartmentRepository departmentRepository, SeatRepository seatRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.seatRepository = seatRepository;
    }

    public List<SeatAllotment> getSeatAllotments(){
        Iterable<Student> students = this.studentRepository.findAll();
        Map<Integer,SeatAllotment> seatAllotmentMap= new HashMap<>();
        students.forEach(student ->{
            SeatAllotment seatAllotment= new SeatAllotment();
            seatAllotment.setStudentId(student.getStudentId());
            seatAllotment.setStudentName(student.getName());
            seatAllotment.setDepartmentId(student.getDepartmentId());
            seatAllotmentMap.put(student.getStudentId(),seatAllotment);
        });
        Iterable<Seats> seats = this.seatRepository.findAll();
        seats.forEach(seat ->{
            SeatAllotment seatAllotment=seatAllotmentMap.get(seat.getStudentId());
            Department department = this.departmentRepository.findById(seat.getDepartmentId()).get();
            seatAllotment.setDepartmentName(department.getDepartmentName());
            seatAllotment.setSeatId(seat.getSeatId());
        });
        List<SeatAllotment> seatAllotmentList= new ArrayList<>();
        for(Integer id:seatAllotmentMap.keySet()){
            seatAllotmentList.add(seatAllotmentMap.get(id));
        }
        return seatAllotmentList;
    }
}
