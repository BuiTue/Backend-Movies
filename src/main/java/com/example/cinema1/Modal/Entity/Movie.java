package com.example.cinema1.Modal.Entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title",nullable = false,length = 100)
    private String title;

    @Column(name="content",nullable = false,length = 500)
    private String content;

    @Column(name="genre",length = 50)
    private String genre;

    @Column(name="director",nullable = false,length = 50)
    private String director;

    @Column(name="cast",nullable = false,length = 50)
    private String cast;

    @Column(name="releaseDate",nullable = false)
    private String releaseDate;

    @Column(name="duaration",nullable = false)
    private int duaration ;
    @Column(name="imageSrc",length = 200)
    private String imageSrc;

//    @OneToMany(mappedBy = "Movie")
//    private List<Schedule> schedules;

}
