package com.example.cinema1.Modal.Form;

import lombok.Data;

@Data
public class TicketCreateOrUpdateForm {
    private int id;
    private String seatNumber;
    private boolean status;
    private String price;
    private int scheduleId;
    private int userId;


}
