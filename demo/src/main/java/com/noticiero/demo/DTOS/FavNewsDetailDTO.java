package com.noticiero.demo.DTOS;

public class FavNewsDetailDTO {

    private Long userId;
    private Long newsId;
    private String userName;
    private String newsTitle;
    private String newsContent;

    // Constructor con los campos básicos
    public FavNewsDetailDTO(Long userId, Long newsId) {
        this.userId = userId;
        this.newsId = newsId;
    }

    // Constructor completo con más detalles
    public FavNewsDetailDTO(Long userId, Long newsId, String userName, String newsTitle, String newsContent) {
        this.userId = userId;
        this.newsId = newsId;
        this.userName = userName;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    // Getters y Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}

