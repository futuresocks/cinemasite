package com.example.futuresocks.cinemaservice.projections;

import com.example.futuresocks.cinemaservice.models.Movie;
import com.example.futuresocks.cinemaservice.models.Room;
import com.example.futuresocks.cinemaservice.models.Screening;
import com.example.futuresocks.cinemaservice.models.Ticket;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;

@Projection(name = "embedScreening", types = Screening.class)
public interface EmbedScreening {
    long getId();
    LocalDateTime getDateTime();
    List<Ticket> getTickets();
    Room getRoom();
    Movie getMovie();
}