package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
