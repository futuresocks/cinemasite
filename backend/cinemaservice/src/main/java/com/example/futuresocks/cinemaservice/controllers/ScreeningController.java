package com.example.futuresocks.cinemaservice.controllers;

import com.example.futuresocks.cinemaservice.components.SeatMapper;
import com.example.futuresocks.cinemaservice.models.Room;
import com.example.futuresocks.cinemaservice.models.Screening;
import com.example.futuresocks.cinemaservice.models.Seat;
import com.example.futuresocks.cinemaservice.repositories.ScreeningRepository;
import com.example.futuresocks.cinemaservice.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
    @RequestMapping(value = "/screenings")
    public class ScreeningController {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    ScreeningRepository screeningRepository;

    @GetMapping("/{id}/seating")
    public HashMap<String, List<Seat>> getSeatMapFor(@PathVariable Long id){
        Screening screening = screeningRepository.findById(id).get();

        Room room = screening.getRoom();
        List<Seat> seats = room.getSeats();
        return SeatMapper.mapSeats(seats);
    }

    }

