package com.example.cinema1.Service;


import com.example.cinema1.Modal.Dto.CinemaDTO;
import com.example.cinema1.Modal.Form.CinemaCreateOrUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICinemaService {

   Page<CinemaDTO> findAll(Pageable pageable);

    void createOrUpdate(CinemaCreateOrUpdateForm form);

    void deleteById(int id);
}
