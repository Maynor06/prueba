package com.noticiero.demo.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserIniciarSesion {

    private String email;
    private String password;
}
