package com.noticiero.demo.DTOS;

public class UserResponseDTO {

    private Long id;
    private String usernanme;
    private String email;
    private String password;

    public UserResponseDTO(Long id, String usernanme, String email, String password) {
        this.id = id;
        this.usernanme = usernanme;
        this.email = email;
        this.password = password;
    }

    public UserResponseDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getUsernanme() {
        return this.usernanme;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsernanme(String usernanme) {
        this.usernanme = usernanme;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
