package com.noticiero.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_Favoritas")
public class FavNews {

    @EmbeddedId
    private FavNewsId Id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @MapsId("news_id")
    @JoinColumn(name = "news_id")
    private News news;

}

