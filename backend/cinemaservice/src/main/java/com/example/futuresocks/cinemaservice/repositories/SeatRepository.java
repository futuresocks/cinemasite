package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
