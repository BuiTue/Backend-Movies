package com.example.cinema1.Modal.Form;

import lombok.Data;

@Data
public class MovieCreateOrUpdateForm {
    private int id;
    private String title;
    private String content;
    private String genre;
    private String director;
    private String cast;
    private String releaseDate;
    private int duaration;
    private String imageSrc;

}
