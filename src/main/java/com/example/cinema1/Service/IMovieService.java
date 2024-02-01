package com.example.cinema1.Service;


import com.example.cinema1.Modal.Dto.MovieDTO;
import com.example.cinema1.Modal.Form.MovieCreateOrUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService {


    Page<MovieDTO> findAll(Pageable pageable);

    void createOrUpdateMovie(MovieCreateOrUpdateForm form);

    void deleteById(int id);

    MovieDTO findById(int id);

    void createList(List<MovieCreateOrUpdateForm> movieForms);
}
