package com.noticiero.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_Favoritas")
public class FavNews {

    @EmbeddedId
    private FavNewsId Id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @MapsId("newsId")
    @JoinColumn(name = "news_id")
    private News news;

    public FavNews(FavNewsId Id, Users user, News news) {
        this.Id = Id;
        this.user = user;
        this.news = news;
    }

    public FavNews() {
    }

    public FavNewsId getId() {
        return this.Id;
    }

    public Users getUser() {
        return this.user;
    }

    public News getNews() {
        return this.news;
    }

    public void setId(FavNewsId Id) {
        this.Id = Id;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setNews(News news) {
        this.news = news;
    }
}

