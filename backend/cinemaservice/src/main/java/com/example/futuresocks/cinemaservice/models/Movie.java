package com.example.futuresocks.cinemaservice.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private Long id;
    private String title;
    private List<Screening> screenings;

    public Movie(String title) {
        this.title = title;
        this.screenings = new ArrayList<Screening>();
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public void addScreening(Screening screening){
        this.screenings.add(screening);
    }

}
