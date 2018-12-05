package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
