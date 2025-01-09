package com.noticiero.demo.DTOS;

public class UserIniciarSesion {

    private String email;
    private String password;

    public UserIniciarSesion(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserIniciarSesion() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {

        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String toString() {
        return "UserIniciarSesion(email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }
}
