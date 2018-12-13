package com.example.futuresocks.cinemaservice.components;

import com.example.futuresocks.cinemaservice.models.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeatMapper {

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
}
