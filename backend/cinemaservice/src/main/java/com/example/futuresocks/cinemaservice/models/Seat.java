package com.example.futuresocks.cinemaservice.models;

import java.util.ArrayList;
import java.util.List;

public class Seat {

    private Long id;
    private int number;
    private List<Screening> screenings;

    public Seat(int number) {
        this.number = number;
        this.screenings = new ArrayList<>();
    }

    public Seat(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
