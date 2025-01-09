package com.noticiero.demo.Service;

import com.noticiero.demo.DTOS.NewsDTORequest;
import com.noticiero.demo.DTOS.NewsDTOResponse;
import com.noticiero.demo.Models.Category;
import com.noticiero.demo.Models.News;
import com.noticiero.demo.Models.Users;
import com.noticiero.demo.Repository.CategoryRepository;
import com.noticiero.demo.Repository.NewsRepository;
import com.noticiero.demo.Repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    private NewsRepository newsRepository;
    private UsersRepository usersRepository;
    private CategoryRepository categoryRepository;

    public NewsService(NewsRepository newsRepository, UsersRepository usersRepository, CategoryRepository categoryRepository ) {
        this.newsRepository = newsRepository;
        this.usersRepository = usersRepository;
        this.categoryRepository = categoryRepository;
    }

    public NewsDTOResponse addNews(NewsDTORequest newsDTORequest) {
        Users user = usersRepository.findById(newsDTORequest.getUserId()).orElseThrow(() -> new RuntimeException("User Not Found") );
        Category category = categoryRepository.findById(newsDTORequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category Not Found") );

        News news = new News(newsDTORequest.getTitulo(), newsDTORequest.getImageUrl(), newsDTORequest.getContent(), user, category);
        newsRepository.save(news);
        NewsDTOResponse newsDTOResponse = new NewsDTOResponse();
        newsDTOResponse.setId(news.getId());
        newsDTOResponse.setTitulo(news.getTitle());
        newsDTOResponse.setImageUrl(news.getImageUrl());
        newsDTOResponse.setContent(news.getContent());
        newsDTOResponse.setUserId(user.getId());
        newsDTOResponse.setCategoryId(category.getId());
        return newsDTOResponse;
    }

    public NewsDTOResponse updateNews(Long id, NewsDTORequest newsDTORequest) {
        NewsDTOResponse newsDTOResponse = new NewsDTOResponse();
        News news = newsRepository.getNewsById(id);
        news.setTitle(newsDTORequest.getTitulo());
        news.setImageUrl(newsDTORequest.getImageUrl());
        news.setContent(newsDTORequest.getContent());
        newsRepository.save(news);

        newsDTOResponse.setTitulo(news.getTitle());
        newsDTOResponse.setImageUrl(news.getImageUrl());
        newsDTOResponse.setContent(news.getContent());
        newsDTOResponse.setUserId(id);
        newsDTOResponse.setCategoryId(news.getCategory().getId());
        return newsDTOResponse;
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    public List<NewsDTOResponse> getNewsByUserId(Long userId) {
        List<News> newsList = newsRepository.findByUser_id(userId);
        List<NewsDTOResponse> newsDTOResponseList = new ArrayList<>();

        for (News news : newsList) {
            NewsDTOResponse newsDTOResponse = new NewsDTOResponse();
            newsDTOResponse.setId(news.getId());
            newsDTOResponse.setTitulo(news.getTitle());
            newsDTOResponse.setImageUrl(news.getImageUrl());
            newsDTOResponse.setContent(news.getContent());
            newsDTOResponseList.add(newsDTOResponse);
        }
        return newsDTOResponseList;
    }

    public List<NewsDTOResponse> getNewsByCategoryId(Long categoryId) {
        List<News> newsList = newsRepository.findByCategory_id(categoryId);
        List<NewsDTOResponse> newsDTOResponseList = new ArrayList<>();
        for (News news : newsList) {
            NewsDTOResponse newsDTOResponse = new NewsDTOResponse();
            newsDTOResponse.setId(news.getId());
            newsDTOResponse.setTitulo(news.getTitle());
            newsDTOResponse.setImageUrl(news.getImageUrl());
            newsDTOResponse.setContent(news.getContent());
            newsDTOResponseList.add(newsDTOResponse);
        }
        return newsDTOResponseList;
    }


}
