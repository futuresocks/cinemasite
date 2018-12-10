package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Room;
import com.example.futuresocks.cinemaservice.projections.EmbedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedRoom.class)
public interface RoomRepository extends JpaRepository<Room, Long> {
}
