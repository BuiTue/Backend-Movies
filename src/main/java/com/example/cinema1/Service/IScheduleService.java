package com.example.cinema1.Service;


import com.example.cinema1.Modal.Dto.ScheduleDTO;
import com.example.cinema1.Modal.Entity.Schedule;
import com.example.cinema1.Modal.Form.ScheduleCreateOrUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IScheduleService {

    Page<ScheduleDTO> findAll(Pageable pageable);


    void createOrUpdate(ScheduleCreateOrUpdateForm form);

    void deleteById(int id);

    ScheduleDTO findById(int id);
    List<ScheduleDTO> searchSchedule(int movieId, int cinemaId);

    void createList(List<ScheduleCreateOrUpdateForm> scheduleForms);
}
