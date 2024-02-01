package com.example.cinema1.Controller;


import com.example.cinema1.Modal.Dto.MovieDTO;
import com.example.cinema1.Modal.Form.MovieCreateOrUpdateForm;
import com.example.cinema1.Service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/movie")
@CrossOrigin(value = "*")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    // get all movie
    @GetMapping("/get-all")
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<MovieDTO> movies = movieService.findAll(pageable);
        return movies;
    }

    @GetMapping("/findById")
    public MovieDTO findById(@RequestParam int id) {
        MovieDTO movie = movieService.findById(id);
        return movie;
    }

    @PostMapping("/createList")
    public void createMovies(@RequestBody List<MovieCreateOrUpdateForm> movieForms) {
        movieService.createList(movieForms);
    }

    @PostMapping("/create")
    public void createMovie(@RequestBody MovieCreateOrUpdateForm form){
        movieService.createOrUpdateMovie(form);
    }

    @PutMapping("/update")
    public void updateMovie(@RequestBody MovieCreateOrUpdateForm form){
        movieService.createOrUpdateMovie(form);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int id){
        movieService.deleteById(id);
    }
}
