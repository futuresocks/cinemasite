package com.example.futuresocks.cinemaservice.controllers;

import com.example.futuresocks.cinemaservice.components.DataMapper;
import com.example.futuresocks.cinemaservice.models.Room;
import com.example.futuresocks.cinemaservice.models.Screening;
import com.example.futuresocks.cinemaservice.models.Seat;
import com.example.futuresocks.cinemaservice.repositories.ScreeningRepository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;

@RestController
    @RequestMapping(value = "api/screenings")
    public class ScreeningController {

    @Autowired
    ScreeningRepository screeningRepository;

    @GetMapping("/{id}/seating")
    public HashMap<String, List<Seat>> getSeatMapFor(@PathVariable Long id){
        Screening screening = screeningRepository.findById(id).get();

        Room room = screening.getRoom();
        List<Seat> seats = room.getSeats();
        return DataMapper.mapSeats(seats);
    }

    @GetMapping("datesearch/{month}/{day}/{year}")
    public HashMap<String, List<Screening>> getScreeningsByDate(@PathVariable int year, @PathVariable int month, @PathVariable int day){
        LocalDateTime searchDate = LocalDateTime.of(year, Month.of(month), day, 00, 00);
        List<Screening> screeningData = screeningRepository.getScreeningsByDate(searchDate);
        return DataMapper.mapScreenings(screeningData);
    }

    }

