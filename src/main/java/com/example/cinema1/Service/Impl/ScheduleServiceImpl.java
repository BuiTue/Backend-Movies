package com.example.cinema1.Service.Impl;


import com.example.cinema1.Modal.Dto.ScheduleDTO;
import com.example.cinema1.Modal.Entity.Cinema;
import com.example.cinema1.Modal.Entity.Movie;
import com.example.cinema1.Modal.Entity.Schedule;
import com.example.cinema1.Modal.Form.ScheduleCreateOrUpdateForm;
import com.example.cinema1.Responsitory.ICinemaRepository;
import com.example.cinema1.Responsitory.IMovieRepository;
import com.example.cinema1.Responsitory.IScheduleRepository;
import com.example.cinema1.Service.IScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ICinemaRepository cinemaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<ScheduleDTO> findAll(Pageable pageable) {
        Page<Schedule> pageSchedule = scheduleRepository.findAll(pageable);
        // chuyen tu page movie -> page dto
        Page<ScheduleDTO> pageDTO = pageSchedule.map(new Function<Schedule, ScheduleDTO>() {
            @Override
            public ScheduleDTO apply(Schedule schedule) {
                return modelMapper.map(schedule, ScheduleDTO.class);
            }
        });
        return pageDTO;
    }

    @Override
    public void createOrUpdate(ScheduleCreateOrUpdateForm form) {

        if (form.getId() == 0) {
            // chuyen tu form -> entity
            Schedule schedule = modelMapper.map(form, Schedule.class);
            //tim movie theo id phim
            Optional<Movie> movieOptional= movieRepository.findById(form.getMovieId());
            if (!movieOptional.isPresent())
                throw new RuntimeException("Id phim ko dung");

            schedule.setMovie(movieOptional.get());
            //tim rap theo id rap
            Optional<Cinema> cinameOptional= cinemaRepository.findById(form.getCinemaId());
            if (!cinameOptional.isPresent())
                throw new RuntimeException("Id rap ko dung");

            schedule.setCinema(cinameOptional.get());

            scheduleRepository.save(schedule);
        }else {
            Optional<Schedule> optional = scheduleRepository.findById(form.getId());
            if (!optional.isPresent())
                throw new RuntimeException("Id ko dung");

            Schedule schedule = optional.get();// 1  abc xyz a,   1 abc1 xyz null
            schedule.setShowtime(form.getShowtime());
            //tim movie theo id phim
            Optional<Movie> movieOptional= movieRepository.findById(form.getMovieId());
            if (!movieOptional.isPresent())
                throw new RuntimeException("Id phim ko dung");

            schedule.setMovie(movieOptional.get());
            //tim rap theo id rap
            Optional<Cinema> cinameOptional= cinemaRepository.findById(form.getCinemaId());
            if (!cinameOptional.isPresent())
                throw new RuntimeException("Id rap ko dung");

            schedule.setCinema(cinameOptional.get());

            scheduleRepository.save(schedule);

        }
    }

    @Override
    public void deleteById(int id) {
        Optional<Schedule> optional = scheduleRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        scheduleRepository.deleteById(id);

    }

    @Override
    public ScheduleDTO findById(int id) {
        Optional<Schedule> optional = scheduleRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        Schedule schedule = optional.get();
        ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
        return scheduleDTO;
    }

    @Override
    public List<ScheduleDTO> searchSchedule(int movieId, int cinemaId) {
        List<Schedule> schedules = scheduleRepository.findByMovieIdAndCinemaId(movieId, cinemaId);
        if (schedules == null || schedules.isEmpty()) {
            // Trả về danh sách trống hoặc có thể xử lý theo ý muốn của bạn (trả về null, empty list, etc.)
            return Collections.emptyList(); // Trả về danh sách rỗng
        }

        // Chuyển đổi danh sách Schedule thành danh sách ScheduleDTO
        List<ScheduleDTO> scheduleDTOs = schedules.stream()
                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class))
                .collect(Collectors.toList());

        return scheduleDTOs;

    }

    @Override
    public void createList(List<ScheduleCreateOrUpdateForm> scheduleForms) {
        for (ScheduleCreateOrUpdateForm form : scheduleForms){
            createOrUpdate(form);
        }
    }


}
