package com.example.futuresocks.cinemaservice;

import com.example.futuresocks.cinemaservice.models.Movie;
import com.example.futuresocks.cinemaservice.models.Room;
import com.example.futuresocks.cinemaservice.repositories.MovieRepository;
import com.example.futuresocks.cinemaservice.repositories.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaserviceApplicationTests {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	RoomRepository roomRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateMovie(){
		Movie movie = new Movie("Robocop");
		movieRepository.save(movie);
	}

	@Test
	public void canCreateRoom(){
		Room room = new Room("Screen One");
		roomRepository.save(room);
	}

}
