package ru.randomplay.musicshop.dto;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
