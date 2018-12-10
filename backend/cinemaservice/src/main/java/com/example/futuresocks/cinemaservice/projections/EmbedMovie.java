package com.example.futuresocks.cinemaservice.projections;

import com.example.futuresocks.cinemaservice.models.Movie;
import com.example.futuresocks.cinemaservice.models.Screening;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedMovie", types = Movie.class)
public interface EmbedMovie {
    long getId();
    String getTitle();
    String getDescription();
    String getImg();
    int getRuntime();
    int getYear();
    List<Screening> getScreenings();
}
