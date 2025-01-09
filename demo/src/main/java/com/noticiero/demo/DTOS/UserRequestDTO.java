package com.noticiero.demo.DTOS;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequestDTO {

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String username;

    @Email(message = "El correo debe tener un formato Valido")
    @NotBlank(message = "el correo no puede estar vacío")
    private String email;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{}|;:'\",.<>?/]).{8,}$", message = "La contraseña debe tener al menos 8 caracteres, incluir letras, números y caracteres especiales")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    public UserRequestDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserRequestDTO() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
