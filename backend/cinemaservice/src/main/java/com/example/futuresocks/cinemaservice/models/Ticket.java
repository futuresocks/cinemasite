package com.example.futuresocks.cinemaservice.models;

public class Ticket {

    private Long id;
    private Screening screening;
    private Seat seat;

    public Ticket(Screening screening, Seat seat) {
        this.screening = screening;
        this.seat = seat;
    }

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
