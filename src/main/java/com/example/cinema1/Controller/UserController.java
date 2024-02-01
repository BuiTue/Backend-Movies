package com.example.cinema1.Controller;

import com.example.cinema1.Modal.Dto.SearchUserRequest;
import com.example.cinema1.Modal.Dto.UserCreateDto;
import com.example.cinema1.Modal.Dto.UserUpdateDto;
import com.example.cinema1.Modal.Entity.User;
import com.example.cinema1.Service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin(value = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/get-by-role")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<User> getAllByAdmin() {
        return userService.getAllByAdmin();
    }

    @PostMapping("/search")
    public Page<User> search(@RequestBody SearchUserRequest request) {
        return userService.search(request);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @GetMapping("/find-by-username")
    public User findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/create") //api: localhost: 8888/api/v1/account/create
    public User create(@RequestBody @Valid UserCreateDto userCreateDto) {
        return userService.create(userCreateDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        try {
            userService.delete(id);
            return "Xóa thành công";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/update")
    public User update(@RequestBody UserUpdateDto dto) {
        return userService.update(dto);
    }
}
