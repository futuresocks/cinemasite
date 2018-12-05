package com.example.futuresocks.cinemaservice.models;

import javax.persistence.*;
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

    @Column
    private String time;

    @OneToMany(mappedBy = "screening")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Screening(Movie movie, String time, Room room) {
        this.time = time;
        this.movie = movie;
        this.tickets = new ArrayList<Ticket>();
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void addSeat(Ticket ticket){
        this.tickets.add(ticket);
    }
}
