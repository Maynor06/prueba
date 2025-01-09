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

    private NewsDTOResponse ModelToDTO(News news) {
        NewsDTOResponse newsDTOResponse = new NewsDTOResponse();
        newsDTOResponse.setId(news.getId());
        newsDTOResponse.setTitulo(news.getTitle());
        newsDTOResponse.setImageUrl(news.getImageUrl());
        newsDTOResponse.setContent(news.getContent());
        newsDTOResponse.setUserId(news.getUser().getId());
        newsDTOResponse.setCategoryId(news.getCategory().getId());
        return newsDTOResponse;
    }

    public NewsDTOResponse addNews(NewsDTORequest newsDTORequest) {
        Users user = usersRepository.findById(newsDTORequest.getUserId()).orElseThrow(() -> new RuntimeException("User Not Found") );
        Category category = categoryRepository.findById(newsDTORequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category Not Found") );

        News news = new News(newsDTORequest.getTitulo(), newsDTORequest.getImageUrl(), newsDTORequest.getContent(), user, category);
        news = newsRepository.save(news);

        return ModelToDTO(news);
    }

    public NewsDTOResponse updateNews(Long id, NewsDTORequest newsDTORequest) {

        News news = newsRepository.getNewsById(id);
        news.setTitle(newsDTORequest.getTitulo());
        news.setImageUrl(newsDTORequest.getImageUrl());
        news.setContent(newsDTORequest.getContent());
        newsRepository.save(news);


        return ModelToDTO(news);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    public List<NewsDTOResponse> getNewsByUserId(Long userId) {
        List<News> newsList = newsRepository.findByUser_id(userId);
        return getNewsDTOResponses(newsList);
    }

    private List<NewsDTOResponse> getNewsDTOResponses(List<News> newsList) {
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
        return getNewsDTOResponses(newsList);
    }


}
