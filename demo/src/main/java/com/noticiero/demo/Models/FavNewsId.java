package com.noticiero.demo.Models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavNewsId implements Serializable {

    private Long userId;

    private Long newsId;

    public FavNewsId(Long userId, Long newsId) {
        this.userId = userId;
        this.newsId = newsId;
    }

    public FavNewsId() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavNewsId that = (FavNewsId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(newsId, that.newsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, newsId);
    }

    public Long getUserId() {

        return this.userId;
    }

    public Long getNewsId() {

        return this.newsId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public void setNewsId(Long newsId) {

        this.newsId = newsId;
    }
}
