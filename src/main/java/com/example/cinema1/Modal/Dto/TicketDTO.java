package com.example.cinema1.Modal.Dto;

import lombok.Data;

@Data
public class TicketDTO {
    private int id;
    private String seatNumber;
    private boolean status;
    private String price;
    private ScheduleDTO scheduleDTO;
}
