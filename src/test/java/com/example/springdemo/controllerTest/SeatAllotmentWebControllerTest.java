package com.example.springdemo.controllerTest;

import com.example.springdemo.business.domain.SeatAllotment;
import com.example.springdemo.business.service.SeatAllotmentService;
import com.example.springdemo.controller.SeatAllotmentWebController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(SeatAllotmentWebController.class)
public class SeatAllotmentWebControllerTest {
    @MockBean
    private SeatAllotmentService seatAllotmentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSeatAllotments() throws Exception{
        List<SeatAllotment> seatAllotments=new ArrayList<>();
        SeatAllotment seatAllotment = new SeatAllotment();
        seatAllotment.setSeatId(1234);
        seatAllotment.setStudentId(9321);
        seatAllotment.setStudentName("VARSHA");
        seatAllotment.setDepartmentId(12);
        seatAllotment.setDepartmentName("IT");
        seatAllotments.add(seatAllotment);

        given(seatAllotmentService.getSeatAllotments()).willReturn(seatAllotments);

        this.mockMvc.perform(get("/seatAllotments"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("VARSHA")));

    }
}
