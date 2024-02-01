package com.example.cinema1.Responsitory;

import com.example.cinema1.Modal.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule,Integer> {

    List<Schedule> findByMovieId(int id);
    List<Schedule> findByMovieIdAndCinemaId(int movieId,int cinemaId);

}
