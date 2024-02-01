package com.example.cinema1.Controller;



import com.example.cinema1.Modal.Dto.TicketDTO;
import com.example.cinema1.Modal.Entity.Ticket;
import com.example.cinema1.Modal.Form.TicketCreateOrUpdateForm;
import com.example.cinema1.Service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/ticket")
@CrossOrigin(value = "*")
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping("/get-all")
    public List<Ticket> findAll() {
        List<Ticket> tickets = ticketService.findAll();
        return tickets;
    }

    @GetMapping("/findById")
    public TicketDTO findById(int id){
        return ticketService.findById(id);
    }

    @PostMapping("/create")

    public void createTicket(@RequestBody TicketCreateOrUpdateForm form){
        ticketService.createOrUpdateTicket(form);
    }
    @PostMapping("/createList")

    public void createTickets(@RequestBody List<TicketCreateOrUpdateForm> ticketForms) {
        ticketService.createList(ticketForms);
    }

    @PutMapping("/update")
    public void updateTicket(@RequestBody TicketCreateOrUpdateForm form){
        ticketService.createOrUpdateTicket(form);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int id){
        ticketService.deleteById(id);
    }
}
