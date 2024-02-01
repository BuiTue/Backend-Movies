package com.example.cinema1.Service;

import com.example.cinema1.Modal.Dto.SearchUserRequest;
import com.example.cinema1.Modal.Dto.UserCreateDto;
import com.example.cinema1.Modal.Dto.UserUpdateDto;
import com.example.cinema1.Modal.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    Page<User> search(SearchUserRequest request);

    List<User> getAll();

    User getById(int id);

    User findByUsername(String username);

    User create(UserCreateDto dto);
    List<User> getAllByAdmin();

    void delete(int id);

    User update(UserUpdateDto dto);
}
