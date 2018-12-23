package com.example.futuresocks.cinemaservice.controllers;

import com.example.futuresocks.cinemaservice.models.Screening;
import com.example.futuresocks.cinemaservice.models.Seat;
import com.example.futuresocks.cinemaservice.models.Ticket;
import com.example.futuresocks.cinemaservice.repositories.ScreeningRepository;
import com.example.futuresocks.cinemaservice.repositories.SeatRepository;
import com.example.futuresocks.cinemaservice.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "api/tickets")
public class TicketController {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    SeatRepository seatRepository;

    @RequestMapping(value = "/new", headers = "Accept=application/json", method = RequestMethod.POST)
    public void createTickets(@RequestBody HashMap<Long, List<Long>> requestData) {
        Long screeningId = (Long) requestData.keySet().toArray()[0];
        Screening screening = screeningRepository.findById(screeningId).get();
        List<Long> seatIDs = requestData.get(screeningId);
        for(Long seatID : seatIDs){
            Seat seat = seatRepository.findById(seatID).get();
            Ticket ticket = new Ticket(screening, seat);
            ticketRepository.save(ticket);
        }
    }
}
