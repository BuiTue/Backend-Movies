package com.example.cinema1.Modal.Form;

import lombok.Data;

@Data
public class ScheduleCreateOrUpdateForm {
    private int id;
    private String showtime;
    private int movieId;
    private int cinemaId;
}
