package com.example.cinema1.Service;


import com.example.cinema1.Modal.Dto.TicketDTO;
import com.example.cinema1.Modal.Entity.Ticket;
import com.example.cinema1.Modal.Form.TicketCreateOrUpdateForm;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAll();

    void createList(List<TicketCreateOrUpdateForm> forms);

    void createOrUpdateTicket(TicketCreateOrUpdateForm form);

    void deleteById(int id);

    TicketDTO findById(int id);
}
