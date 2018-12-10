package com.example.futuresocks.cinemaservice.projections;

import com.example.futuresocks.cinemaservice.models.Seat;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedSeat", types = Seat.class)
public interface EmbedSeat {
    Long getId();
    int getNumber();
}

