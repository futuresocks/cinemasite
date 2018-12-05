package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
