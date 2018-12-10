package com.example.futuresocks.cinemaservice.projections;

import com.example.futuresocks.cinemaservice.models.Screening;
import com.example.futuresocks.cinemaservice.models.Seat;
import com.example.futuresocks.cinemaservice.models.Ticket;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedTicket", types = Ticket.class)
public interface EmbedTicket {
    Long getId();
    Screening getScreening();
    Seat getSeat();
}
