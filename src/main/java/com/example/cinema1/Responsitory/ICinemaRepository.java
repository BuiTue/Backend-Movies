package com.example.cinema1.Responsitory;


import com.example.cinema1.Modal.Entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICinemaRepository extends JpaRepository<Cinema,Integer> {
}
