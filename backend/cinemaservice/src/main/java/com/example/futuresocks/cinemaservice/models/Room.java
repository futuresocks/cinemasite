package com.example.futuresocks.cinemaservice.models;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private Long id;
    private String name;
    private List<Seat> seats;
    private List<Screening> screenings;

    public Room(String name) {
        this.name = name;
        this.seats = new ArrayList<>();
        this.screenings = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public void addScreening(Screening screening){
        this.screenings.add(screening);
    }
}
