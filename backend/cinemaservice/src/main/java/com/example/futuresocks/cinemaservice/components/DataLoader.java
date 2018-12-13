package com.example.futuresocks.cinemaservice.components;

import com.example.futuresocks.cinemaservice.models.*;
import com.example.futuresocks.cinemaservice.repositories.*;
import com.example.futuresocks.cinemaservice.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    TicketRepository ticketRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){
        Movie robocop = new Movie("Robocop", "In a dystopic and crime-ridden Detroit, a terminally wounded cop returns to the force as a powerful cyborg haunted by submerged memories.", "https://m.media-amazon.com/images/M/MV5BZWVlYzU2ZjQtZmNkMi00OTc3LTkwZmYtZDVjNmY4OWFmZGJlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,644,1000_AL_.jpg", 103, 1987);
        movieRepository.save(robocop);

        Room room = new Room("Screen One");
        roomRepository.save(room);

        String[] letters = new String[]{"a", "b", "c", "d"};

        for(int i = 1; i <= 10; i++){
            for(String letter: letters){
                String seatNo = letter + String.valueOf(i);
            Seat seat = new Seat(seatNo, room);
            seatRepository.save(seat);
        }
        }

        String[] showTimes = new String[]{"11:00", "13:00"};

        for(String showTime: showTimes){
            Screening screening = new Screening(robocop, showTime, room);
            screeningRepository.save(screening);
        }

        for(int i = 1; i <= 40; i ++) {
            if (i % 4 == 0) {
                Screening screening = screeningRepository.findById(Long.valueOf(1)).get();
                Seat seat = seatRepository.findById(Long.valueOf(i)).get();
                Ticket ticket = new Ticket(screening, seat);
                ticketRepository.save(ticket);
            }
        }

    }
}
