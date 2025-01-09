package com.noticiero.demo.Repository;

import com.noticiero.demo.Models.FavNews;
import com.noticiero.demo.Models.FavNewsId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavNewsRepository extends CrudRepository<FavNews, FavNewsId> {

    List<FavNews> findAllByUserId(long userId);
    boolean existsById(FavNewsId favNewsId);
    void deleteById(FavNewsId favNewsId);
}
