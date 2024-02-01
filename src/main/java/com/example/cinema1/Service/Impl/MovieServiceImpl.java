package com.example.cinema1.Service.Impl;


import com.example.cinema1.Modal.Dto.MovieDTO;
import com.example.cinema1.Modal.Dto.ScheduleDTO;
import com.example.cinema1.Modal.Entity.Movie;
import com.example.cinema1.Modal.Entity.Schedule;
import com.example.cinema1.Modal.Form.MovieCreateOrUpdateForm;
import com.example.cinema1.Responsitory.IMovieRepository;
import com.example.cinema1.Responsitory.IScheduleRepository;
import com.example.cinema1.Service.IMovieService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IScheduleRepository scheduleRepository;


    @Override
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> pageMovie = movieRepository.findAll(pageable);
        // chuyen tu page movie -> page dto
        Page<MovieDTO> pageDTO = pageMovie.map(new Function<Movie, MovieDTO>() {
            @Override
            public MovieDTO apply(Movie movie) {
                return modelMapper.map(movie, MovieDTO.class);
            }
        });
        return pageDTO;
    }

    @Override
    public void createOrUpdateMovie(MovieCreateOrUpdateForm form) {
        if (form.getId() == 0) {
            // chuyen tu form -> entity
            Movie movie = modelMapper.map(form, Movie.class);


            movieRepository.save(movie);
        }else {
            Optional<Movie> optional = movieRepository.findById(form.getId());
            if (!optional.isPresent())
                throw new RuntimeException("Id ko dung");

            Movie movie = optional.get();// 1  abc xyz a,   1 abc1 xyz null
            movie.setCast(form.getCast());
            movie.setDirector(form.getDirector());
            movie.setGenre(form.getGenre());
            movie.setContent(form.getContent());
            movie.setDuaration(form.getDuaration());
            movie.setReleaseDate(form.getReleaseDate());
            movie.setTitle(form.getTitle());

            movieRepository.save(movie);

        }

    }

    @Override
    public void deleteById(int id) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        movieRepository.deleteById(id);

    }

    @Override
    public MovieDTO findById(int id) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        Movie movie = optional.get();
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);

        // ds lịch chieu theo id phim
        List<Schedule> schedules = scheduleRepository.findByMovieId(id);
        List<ScheduleDTO> scheduleDTOS = modelMapper.map(schedules, new TypeToken<List<ScheduleDTO>>(){}.getType());
        movieDTO.setScheduleDTOS(scheduleDTOS);

        return movieDTO;
    }

    @Override
    public void createList(List<MovieCreateOrUpdateForm> movieForms) {
        for(MovieCreateOrUpdateForm form: movieForms){
            createOrUpdateMovie(form);
        }
    }
}
