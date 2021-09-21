package com.example.springdemo.controller;

import com.example.springdemo.business.domain.SeatAllotment;
import com.example.springdemo.business.service.SeatAllotmentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seatAllotments")
public class SeatAllotmentWebServiceController {
    private final SeatAllotmentService seatAllotmentService;

    public SeatAllotmentWebServiceController(SeatAllotmentService seatAllotmentService) {
        this.seatAllotmentService = seatAllotmentService;
    }

    @GetMapping
    public List<SeatAllotment> getSeatAllotments(Model model){
        return this.seatAllotmentService.getSeatAllotments();
    }
}
