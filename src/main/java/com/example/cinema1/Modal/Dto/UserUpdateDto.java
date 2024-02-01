package com.example.cinema1.Modal.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private int id;
    private String username;
    private String phoneNumber;
    private String fullName;
    private String email;
    private Date dateOfBirth;
    private String address;
}
