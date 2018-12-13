package com.example.futuresocks.cinemaservice;

import com.example.futuresocks.cinemaservice.components.SeatMapper;
import com.example.futuresocks.cinemaservice.models.Room;
import com.example.futuresocks.cinemaservice.models.Seat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSeatMapper {

    @Test
    public void canMapSeats(){
        List<Seat> seats = new ArrayList<Seat>();

        Room room = new Room("Screen One");

        Seat seat1 = new Seat("A1", room);
        Seat seat2 = new Seat("B2", room);

        seats.add(seat1);
        seats.add(seat2);

        SeatMapper seatMapper = new SeatMapper();

        HashMap<String, List<Seat>> expected = new HashMap<>();
        expected.put("A", new ArrayList<Seat>(Arrays.asList(seat1)));
        expected.put("B", new ArrayList<Seat>(Arrays.asList(seat2)));

        assertEquals(expected, seatMapper.mapSeats(seats));
    }
}
