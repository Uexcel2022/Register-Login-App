package com.uexcel.registerloginapp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String fullName;
    private String email;
    private String password1;
    private String password2;
}
