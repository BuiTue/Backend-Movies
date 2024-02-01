package com.example.cinema1.Modal.Entity;

import javax.persistence.*;
import lombok.Data;

//import javax.persistence.*;
@Entity
@Data
@Table(name="ticket")
public class Ticket {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "id")
    private int id;


    @Column(name = "seatNumber",nullable = false, unique = true, length = 100)
    private String seatNumber;

    @Column(name = "status",nullable = false, length = 100)
    private boolean status;

    @Column(name = "price", length = 200)
    private String price;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

//    @ManyToOne
//    @JoinColumn(name = "movie_id", nullable = false)
//    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user ;
}
