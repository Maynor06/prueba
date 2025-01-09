package com.noticiero.demo.Repository;

import com.noticiero.demo.Models.FavNews;
import com.noticiero.demo.Models.FavNewsId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FavNewsRepository extends CrudRepository<FavNews, Long> {

    List<FavNews> findAllByUserId(long userId);
    Boolean existsById(FavNewsId favNewsId);
    Boolean deleteById(FavNewsId favNewsId);
}
