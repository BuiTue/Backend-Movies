package com.example.cinema1.Modal.Dto;

import com.example.cinema1.Validation.UsernameExists;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    @UsernameExists(message = "{account.create.username_existed}")
    private String username;

    private String password;
    private String phoneNumber;
    private String fullName;

    @NotBlank
    private String email;
    private Date dateOfBirth;
    private String address;
}
