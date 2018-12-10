package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Seat;
import com.example.futuresocks.cinemaservice.projections.EmbedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedSeat.class)
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
