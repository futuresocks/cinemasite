package com.example.futuresocks.cinemaservice.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "screenings")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @OneToMany(mappedBy = "screening")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    public Screening(Movie movie, Room room, LocalDateTime dateTime) {
        this.movie = movie;
        this.tickets = new ArrayList<Ticket>();
        this.room = room;
        this.dateTime = dateTime;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setSeats(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void addSeat(Ticket ticket){
        this.tickets.add(ticket);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
