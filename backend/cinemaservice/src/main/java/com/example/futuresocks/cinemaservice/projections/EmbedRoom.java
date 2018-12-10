package com.example.futuresocks.cinemaservice.projections;

import com.example.futuresocks.cinemaservice.models.Room;
import com.example.futuresocks.cinemaservice.models.Seat;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedRoom", types = Room.class)
public interface EmbedRoom {
    Long getId();
    String getName();
    List<Seat> getSeats();
}
