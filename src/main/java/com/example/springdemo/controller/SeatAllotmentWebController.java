package com.example.springdemo.controller;

import com.example.springdemo.business.domain.SeatAllotment;
import com.example.springdemo.business.service.SeatAllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/seatAllotments")
public class SeatAllotmentWebController {
    private final SeatAllotmentService seatAllotmentService;

    @Autowired
    public SeatAllotmentWebController(SeatAllotmentService seatAllotmentService) {
        this.seatAllotmentService = seatAllotmentService;
    }

    @GetMapping
    public String getSeatAllotments(Model model){
        List<SeatAllotment> seatAllotments=this.seatAllotmentService.getSeatAllotments();
        model.addAttribute("seatAllotments", seatAllotments);
        return "seat_allotments";
    }
}
