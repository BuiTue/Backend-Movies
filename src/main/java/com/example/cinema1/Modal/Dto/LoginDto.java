package com.example.cinema1.Modal.Dto;


import com.example.cinema1.Modal.Entity.Role;
import lombok.Data;

@Data
public class LoginDto {

    private int id;
    private String username;
    private Role role;
    private String fullName;
    private String userAgent; // Thông tin trình duyệt đang sử dụng
    private String token;


}
