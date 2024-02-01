package com.example.cinema1.Controller;


import com.example.cinema1.Modal.Dto.CinemaDTO;
import com.example.cinema1.Modal.Form.CinemaCreateOrUpdateForm;
import com.example.cinema1.Service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/cinema")
@CrossOrigin(value = "*")
public class CinemaController {
    @Autowired
    private ICinemaService cinemaService;

    @GetMapping("/get-all")
    public Page<CinemaDTO> findAll(Pageable pageable){
        Page<CinemaDTO> cinema = cinemaService.findAll(pageable);
        return cinema;

    }

    @PostMapping("/create")
    public void createCinema (@RequestBody CinemaCreateOrUpdateForm form){
        cinemaService.createOrUpdate(form);
    }

    @PutMapping("/update")
    public void updateCinema(@RequestBody CinemaCreateOrUpdateForm form){
        cinemaService.createOrUpdate(form);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int id){
        cinemaService.deleteById(id);

    }

}
