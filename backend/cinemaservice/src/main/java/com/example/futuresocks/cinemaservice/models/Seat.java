package com.example.futuresocks.cinemaservice.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int number;

    @OneToMany(mappedBy = "seat")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Seat(int number, Room room) {
        this.number = number;
        this.tickets = new ArrayList<>();
        this.room = room;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }
}
