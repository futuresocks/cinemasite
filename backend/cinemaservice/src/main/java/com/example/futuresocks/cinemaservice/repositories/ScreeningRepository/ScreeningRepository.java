package com.example.futuresocks.cinemaservice.repositories.ScreeningRepository;

import com.example.futuresocks.cinemaservice.models.Screening;
import com.example.futuresocks.cinemaservice.projections.EmbedScreening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedScreening.class)
public interface ScreeningRepository extends JpaRepository<Screening, Long>, ScreeningRepositoryCustom {
}
