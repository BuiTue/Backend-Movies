package com.example.cinema1.Responsitory;

import com.example.cinema1.Modal.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Integer> {
}
