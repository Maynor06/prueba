package com.noticiero.demo.Service;

import com.noticiero.demo.DTOS.CategoryRequest;
import com.noticiero.demo.DTOS.CategoryResponse;
import com.noticiero.demo.Models.Category;
import com.noticiero.demo.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private CategoryResponse CategoryToDTO(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }

    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getNombre());
        category = categoryRepository.save(category);

        return CategoryToDTO(category);
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("not found exception"));
        category.setName(categoryRequest.getNombre());
        category = categoryRepository.save(category);

        return CategoryToDTO(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
