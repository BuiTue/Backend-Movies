package com.example.cinema1.Controller;


import com.example.cinema1.Modal.Dto.ScheduleDTO;
import com.example.cinema1.Modal.Entity.Schedule;
import com.example.cinema1.Modal.Form.ScheduleCreateOrUpdateForm;
import com.example.cinema1.Service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/schedule")
@CrossOrigin(value = "*")
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("/get-all")
    public Page<ScheduleDTO> findAll(Pageable pageable){
        Page<ScheduleDTO> scheduleDTOS = scheduleService.findAll(pageable);
        return scheduleDTOS;
    }

    @GetMapping("/findById")
    public ScheduleDTO findAll(@RequestParam int id){
        ScheduleDTO scheduleDTOS = scheduleService.findById(id);
        return scheduleDTOS;
    }
    @GetMapping("/search")
    public ResponseEntity<List<ScheduleDTO>> searchSchedules(
            @RequestParam("movieId") int movieId,
            @RequestParam("cinemaId") int cinemaId
    ) {
        List<ScheduleDTO> schedules = scheduleService.searchSchedule(movieId, cinemaId);

        if (schedules.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PostMapping("/createList")
    public void createSchedules(@RequestBody List<ScheduleCreateOrUpdateForm> scheduleForms){
        scheduleService.createList(scheduleForms);
    }
    @PostMapping("/create")
    public void createSchedule(@RequestBody ScheduleCreateOrUpdateForm form){
        scheduleService.createOrUpdate(form);
    }

    @PutMapping("/update")
    public void updateSchedule(@RequestBody ScheduleCreateOrUpdateForm form){
        scheduleService.createOrUpdate(form);
    }

    @DeleteMapping("/delete")
    private void deleteById(@RequestParam int id){
        scheduleService.deleteById(id);
    }

}
