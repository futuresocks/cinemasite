package com.example.futuresocks.cinemaservice.components;

import com.example.futuresocks.cinemaservice.models.Screening;
import com.example.futuresocks.cinemaservice.models.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataMapper {

    public static HashMap<String, List<Seat>> mapSeats(List<Seat> seats){
        HashMap<String, List<Seat>> result = new HashMap<String, List<Seat>>();
        for(Seat seat : seats){
            String key = seat.getNumber().split("")[0];
            if(result.get(key) == null){
                List<Seat> orderedSeats = new ArrayList<>();
                orderedSeats.add(seat);
                result.put(key, orderedSeats);
            } else {
                List<Seat> orderedSeats = result.get(key);
                orderedSeats.add(seat);
                result.put(key, orderedSeats);
            }
        }
        return result;
    }

    public static HashMap<String, List<Screening>> mapScreenings(List<Screening> screeningData) {
        HashMap<String, List<Screening>> result = new HashMap<>();
        for(Screening screening: screeningData){
            String key = screening.getMovie().getTitle();
            if(result.get(key) == null){
                List<Screening> sortedScreenings = new ArrayList<>();
                sortedScreenings.add(screening);
                result.put(key, sortedScreenings);
            } else {
                List<Screening> sortedScreenings = result.get(key);
                sortedScreenings.add(screening);
                result.put(key, sortedScreenings);
            }
        }
        return result;
    }
}
