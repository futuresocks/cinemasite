package com.example.futuresocks.cinemaservice.models;

import java.util.ArrayList;
import java.util.List;

public class Screening {

    private Long id;
    private Movie movie;
    private String time;
    private List<Ticket> tickets;

    public Screening(Movie movie, String time) {
        this.time = time;
        this.movie = movie;
        this.tickets = new ArrayList<Ticket>();
    }

    public Screening() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setSeats(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addSeat(Ticket ticket){
        this.tickets.add(ticket);
    }
}
