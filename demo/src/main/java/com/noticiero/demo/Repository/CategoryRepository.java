package com.noticiero.demo.Repository;

import com.noticiero.demo.Models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
