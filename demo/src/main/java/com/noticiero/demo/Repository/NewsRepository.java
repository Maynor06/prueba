package com.noticiero.demo.Repository;

import com.noticiero.demo.Models.Category;
import com.noticiero.demo.Models.News;
import com.noticiero.demo.Models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

    List<News> findByTitle(String title);
    List<News> findByCategory_id(Long category_id);
    List<News> findByUser_id(Long user_id);

    News  getNewsById(Long id);

}
