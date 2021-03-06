package com.example.futuresocks.cinemaservice;

import com.example.futuresocks.cinemaservice.models.*;
import com.example.futuresocks.cinemaservice.repositories.*;
import com.example.futuresocks.cinemaservice.repositories.MovieRepository;
import com.example.futuresocks.cinemaservice.repositories.ScreeningRepository.ScreeningRepository;
import com.example.futuresocks.cinemaservice.repositories.SeatRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaserviceApplicationTests {

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

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateMovie(){
		Movie movie = new Movie("Robocop", "In a dystopic and crime-ridden Detroit, a terminally wounded cop returns to the force as a powerful cyborg haunted by submerged memories.", "https://m.media-amazon.com/images/M/MV5BZWVlYzU2ZjQtZmNkMi00OTc3LTkwZmYtZDVjNmY4OWFmZGJlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,644,1000_AL_.jpg", 103, 1987);
		movieRepository.save(movie);
	}

	@Test
	public void canCreateRoom(){
		Room room = new Room("Screen One");
		roomRepository.save(room);
	}

	@Test
	public void canCreateScreening(){
		Movie movie = new Movie("Robocop", "In a dystopic and crime-ridden Detroit, a terminally wounded cop returns to the force as a powerful cyborg haunted by submerged memories.", "https://m.media-amazon.com/images/M/MV5BZWVlYzU2ZjQtZmNkMi00OTc3LTkwZmYtZDVjNmY4OWFmZGJlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,644,1000_AL_.jpg", 103, 1987);
		movieRepository.save(movie);

		Room room = new Room("Screen One");
		roomRepository.save(room);

		LocalDateTime dateTime = LocalDateTime.of(2018, Month.DECEMBER, 28, 12, 00);

		Screening screening = new Screening(movie, room, dateTime);
		screeningRepository.save(screening);
	}

	@Test
	public void canCreateSeats(){
		Room room = new Room("Screen One");
		roomRepository.save(room);

		Seat seat = new Seat("A1", room);
		seatRepository.save(seat);
	}

	@Test
	public void canCreateTickets(){
		Movie movie = new Movie("Robocop", "In a dystopic and crime-ridden Detroit, a terminally wounded cop returns to the force as a powerful cyborg haunted by submerged memories.", "https://m.media-amazon.com/images/M/MV5BZWVlYzU2ZjQtZmNkMi00OTc3LTkwZmYtZDVjNmY4OWFmZGJlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,644,1000_AL_.jpg", 103, 1987);
		movieRepository.save(movie);

		Room room = new Room("Screen One");
		roomRepository.save(room);

		LocalDateTime dateTime = LocalDateTime.of(2018, Month.DECEMBER, 28, 12, 00);

		Screening screening = new Screening(movie, room, dateTime);
		screeningRepository.save(screening);

		Seat seat = new Seat("A1", room);
		seatRepository.save(seat);

		Ticket ticket = new Ticket(screening, seat);
		ticketRepository.save(ticket);
	}

}
