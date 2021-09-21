package com.example.springdemo.data.repository;

import com.example.springdemo.data.entity.Seats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends CrudRepository<Seats,Integer> {
}
