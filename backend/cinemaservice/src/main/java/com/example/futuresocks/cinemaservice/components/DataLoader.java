package com.example.futuresocks.cinemaservice.components;

import com.example.futuresocks.cinemaservice.models.*;
import com.example.futuresocks.cinemaservice.repositories.*;
import com.example.futuresocks.cinemaservice.repositories.MovieRepository;
import com.example.futuresocks.cinemaservice.repositories.ScreeningRepository.ScreeningRepository;
import com.example.futuresocks.cinemaservice.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

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

        Movie darkman = new Movie("Darkman", "A brilliant scientist left for dead returns to exact revenge on the people who burned him alive.", "https://i.pinimg.com/originals/11/d3/89/11d38940af933f409ac48391d74a9663.jpg", 96, 1990);
        movieRepository.save(darkman);

        Room room = new Room("Screen One");
        roomRepository.save(room);

        String[] letters = new String[]{"A", "B", "C", "D"};

        for(int i = 1; i <= 10; i++){
            for(String letter: letters){
                String seatNo = letter + String.valueOf(i);
            Seat seat = new Seat(seatNo, room);
            seatRepository.save(seat);
        }
        }

        LocalDateTime[] showTimes = new LocalDateTime[]{LocalDateTime.of(2018, Month.DECEMBER, 28, 11, 00), LocalDateTime.of(2018, Month.DECEMBER, 28, 13, 00)};

        for(LocalDateTime showTime: showTimes){
            Screening screening = new Screening(robocop, room, showTime);
            screeningRepository.save(screening);
        }

        LocalDateTime darkmanTime = LocalDateTime.of(2018, Month.DECEMBER, 29, 16, 00);

        Screening darkmanScreening = new Screening(darkman, room, darkmanTime);
        screeningRepository.save(darkmanScreening);

        for(int i = 1; i <= 40; i ++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                Screening screening = screeningRepository.findById(Long.valueOf(1)).get();
                Seat seat = seatRepository.findById(Long.valueOf(i)).get();
                Ticket ticket = new Ticket(screening, seat);
                ticketRepository.save(ticket);
            }
        }

    }
}
