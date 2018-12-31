package com.example.futuresocks.cinemaservice.repositories.ScreeningRepository;

import com.example.futuresocks.cinemaservice.models.Screening;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepositoryCustom {

    List<Screening> getScreeningsByDate(LocalDateTime dateTime);
}
