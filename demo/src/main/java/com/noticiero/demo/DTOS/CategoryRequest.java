package com.noticiero.demo.DTOS;

public class CategoryRequest {

    private String nombre;

    public CategoryRequest(String nombre) {
        this.nombre = nombre;
    }

    public CategoryRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
