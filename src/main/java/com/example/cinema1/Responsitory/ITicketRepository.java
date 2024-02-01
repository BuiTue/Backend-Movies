package com.example.cinema1.Responsitory;

import com.example.cinema1.Modal.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Integer> {
}
