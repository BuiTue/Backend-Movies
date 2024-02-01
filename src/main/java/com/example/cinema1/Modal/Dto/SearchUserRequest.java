package com.example.cinema1.Modal.Dto;

import com.example.cinema1.Modal.Entity.Role;
import lombok.Data;

@Data
public class SearchUserRequest extends BaseRequest {

    private String username;
    private Role role;
    private String phoneNumber;
    private String fullname;
    private String email;
    private String address;
}
