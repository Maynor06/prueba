package com.noticiero.demo.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "url_img", nullable = false)
    private String ImageUrl;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    public News(String title, String imageUrl, String content, Users user, Category category) {
        this.title = title;
        this.ImageUrl = imageUrl;
        this.content = content;
        this.user = user;
        this.category = category;
        this.date = LocalDateTime.now();
    }

    public News(Long id, String title, String ImageUrl, String content, Users user, LocalDateTime date, Category category) {
        this.id = id;
        this.title = title;
        this.ImageUrl = ImageUrl;
        this.content = content;
        this.user = user;
        this.date = date;
        this.category = category;
    }

    public News() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImageUrl() {
        return this.ImageUrl;
    }

    public String getContent() {
        return this.content;
    }

    public Users getUser() {
        return this.user;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
