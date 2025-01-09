package com.noticiero.demo.DTOS;

public class FavNewsDTO {

    private Long userId;
    private Long newsId;

    public FavNewsDTO(Long userId, Long newsId) {
        this.userId = userId;
        this.newsId = newsId;
    }

    public FavNewsDTO() {
    }


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
}
