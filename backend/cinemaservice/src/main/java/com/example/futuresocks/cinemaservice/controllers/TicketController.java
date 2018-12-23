package com.example.futuresocks.cinemaservice.controllers;

import com.example.futuresocks.cinemaservice.repositories.ScreeningRepository;
import com.example.futuresocks.cinemaservice.repositories.SeatRepository;
import com.example.futuresocks.cinemaservice.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/tickets")
public class TicketController {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    SeatRepository seatRepository;

    @PostMapping("/new")
    public void createTickets(){
        System.out.println("hello");
    }
}
