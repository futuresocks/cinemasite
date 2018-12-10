package com.example.futuresocks.cinemaservice.repositories;

import com.example.futuresocks.cinemaservice.models.Ticket;
import com.example.futuresocks.cinemaservice.projections.EmbedTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(excerptProjection = EmbedTicket.class)
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
