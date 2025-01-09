package com.noticiero.demo.DTOS;

public class NewsDTORequest {

    private String titulo;
    private String imageUrl;
    private String content;
    private Long userId;
    private Long categoryId;

    public NewsDTORequest(String titulo, String imageUrl, String content, Long userId, Long categoryId) {
        this.titulo = titulo;
        this.imageUrl = imageUrl;
        this.content = content;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public NewsDTORequest() {
    }

    public String getTitulo() {

        return this.titulo;
    }

    public String getImageUrl() {

        return this.imageUrl;
    }

    public String getContent() {

        return this.content;
    }

    public Long getUserId() {

        return this.userId;
    }

    public Long getCategoryId() {

        return this.categoryId;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public void setCategoryId(Long categoryId) {

        this.categoryId = categoryId;
    }

}
