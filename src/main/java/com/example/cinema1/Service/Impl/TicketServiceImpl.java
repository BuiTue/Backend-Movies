package com.example.cinema1.Service.Impl;


import com.example.cinema1.Modal.Dto.ScheduleDTO;
import com.example.cinema1.Modal.Dto.TicketDTO;
import com.example.cinema1.Modal.Entity.Schedule;
import com.example.cinema1.Modal.Entity.Ticket;
import com.example.cinema1.Modal.Form.TicketCreateOrUpdateForm;
import com.example.cinema1.Responsitory.IScheduleRepository;
import com.example.cinema1.Responsitory.ITicketRepository;
import com.example.cinema1.Service.ITicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IScheduleRepository scheduleRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
    @Override
    public void createList(List<TicketCreateOrUpdateForm> forms) {
        for (TicketCreateOrUpdateForm form : forms) {
            createOrUpdateTicket(form);
        }
    }

//    private void createList(TicketCreateOrUpdateForm form) {
//        if (form.getId() == 0) {
//            // chuyen tu form -> entity
//            Ticket ticket = modelMapper.map(form, Ticket.class);
//
//            // tu scheduId tim ra Schedu
//            Optional<Schedule> optional = scheduleRepository.findById(form.getScheduleId());
//
//            if (!optional.isPresent())
//                throw new RuntimeException("Id schedu ko dung");
//
//            // set schedu vao ticket
//            ticket.setSchedule(optional.get());
//            ticketRepository.save(ticket);
//        } else {
//
//            Optional<Ticket> optionalTicket = ticketRepository.findById(form.getId());
//            if (!optionalTicket.isPresent())
//                throw new RuntimeException("Id ko dung");
//            Ticket ticket = optionalTicket.get();
//            //set may thuoc tinsh id,,,,
//            ticket.setId(form.getId());
//            ticket.setPrice(form.getPrice());
//            ticket.setSeatNumber(form.getSeatNumber());
//            ticket.setStatus(true);
//
//            // tu scheduId tim ra Schedu
//            Optional<Schedule> optional = scheduleRepository.findById(form.getScheduleId());
//
//            if (!optional.isPresent())
//                throw new RuntimeException("Id schedu ko dung");
//
//            // set schedu vao ticket
//            ticket.setSchedule(optional.get());
//            ticketRepository.save(ticket);
//
//        }
//    }



    @Override
    public void createOrUpdateTicket(TicketCreateOrUpdateForm form) {
        if (form.getId() == 0) {
            // chuyen tu form -> entity
            Ticket ticket = modelMapper.map(form, Ticket.class);

            // tu scheduId tim ra Schedu
            Optional<Schedule> optional = scheduleRepository.findById(form.getScheduleId());

            if (!optional.isPresent())
                throw new RuntimeException("Id schedu ko dung");

            // set schedu vao ticket
            ticket.setSchedule(optional.get());
            ticketRepository.save(ticket);
        }else {

            Optional<Ticket> optionalTicket = ticketRepository.findById(form.getId());
            if (!optionalTicket.isPresent())
                throw new RuntimeException("Id ko dung");
            Ticket ticket = optionalTicket.get();
            //set may thuoc tinsh id,,,,
            ticket.setId(form.getId());
            ticket.setPrice(form.getPrice());
            ticket.setSeatNumber(form.getSeatNumber());
            ticket.setStatus(form.isStatus());

            // tu scheduId tim ra Schedu
            Optional<Schedule> optional = scheduleRepository.findById(form.getScheduleId());

            if (!optional.isPresent())
                throw new RuntimeException("Id schedu ko dung");

            // set schedu vao ticket
            ticket.setSchedule(optional.get());
            ticketRepository.save(ticket);

        }

    }

    @Override
    public void deleteById(int id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDTO findById(int id) {
        Optional<Ticket> optional = ticketRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        Ticket ticket = optional.get();
        TicketDTO ticketDTO = modelMapper.map(ticket, TicketDTO.class);//
        // lay schedu tu ticket
        Schedule schedule = ticket.getSchedule();
        // chueyn thanh dto
        ScheduleDTO  scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
        ticketDTO.setScheduleDTO(scheduleDTO);

        return ticketDTO;
    }
}
