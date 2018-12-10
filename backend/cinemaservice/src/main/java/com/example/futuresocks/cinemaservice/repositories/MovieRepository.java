package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Movie;
import com.example.futuresocks.cinemaservice.projections.EmbedMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedMovie.class)
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
