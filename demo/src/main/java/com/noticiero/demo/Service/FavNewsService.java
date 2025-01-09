package com.noticiero.demo.Service;

import com.noticiero.demo.DTOS.FavNewsDTO;
import com.noticiero.demo.DTOS.FavNewsDetailDTO;
import com.noticiero.demo.Models.FavNews;
import com.noticiero.demo.Models.FavNewsId;
import com.noticiero.demo.Models.News;
import com.noticiero.demo.Models.Users;
import com.noticiero.demo.Repository.FavNewsRepository;
import com.noticiero.demo.Repository.NewsRepository;
import com.noticiero.demo.Repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavNewsService {

    private FavNewsRepository favNewsRepository;
    private UsersRepository usersRepository;
    private NewsRepository newsRepository;

    public FavNewsService(FavNewsRepository favNewsRepository, UsersRepository usersRepository, NewsRepository newsRepository) {
        this.favNewsRepository = favNewsRepository;
        this.usersRepository = usersRepository;
        this.newsRepository = newsRepository;
    }

    public FavNewsDetailDTO addFavNews(FavNewsDTO favNews) {
        if (favNews.getUserId() == null || favNews.getNewsId() == null) {
            throw new IllegalArgumentException("UserId and NewsId cannot be null");
        }

        Users user = usersRepository.findById(favNews.getUserId()).orElseThrow(() -> new RuntimeException("User not found") );
        News news = newsRepository.findById(favNews.getNewsId()).orElseThrow(() -> new RuntimeException("News not found") );

        FavNewsId favNewsId = new FavNewsId(user.getId(), news.getId());
        FavNews favNews1 = new FavNews();
        favNews1.setId(favNewsId);
        favNews1.setUser(user);
        favNews1.setNews(news);

        favNewsRepository.save(favNews1);
         return new FavNewsDetailDTO(
                favNews.getUserId(),
                favNews.getNewsId(),
                user.getUsername(),
                news.getTitle(),
                news.getContent()
        );
    }

    @Transactional
    public void deleteFavNews(Long userId, Long newsId) {
        FavNewsId favNewsId = new FavNewsId(userId, newsId);

        if (favNewsRepository.existsById(favNewsId)) {
            favNewsRepository.deleteById(favNewsId);
        } else {
            throw new EntityNotFoundException("No se encontró la noticia favorita para el usuario ID "
                    + userId + " y noticia ID " + newsId);
        }
    }


    public List<FavNewsDTO> getAllFavByUserId(Long userId) {
        List<FavNews> favNewsList = favNewsRepository.findAllByUserId(userId);
        List<FavNewsDTO> favNewsDTOList = new ArrayList<>();

        favNewsList.forEach(favNews -> {
            FavNewsDTO favNewsDTO = new FavNewsDTO();
            favNewsDTO.setUserId(favNews.getId().getUserId());
            favNewsDTO.setNewsId(favNews.getId().getNewsId());
            favNewsDTOList.add(favNewsDTO);
        });

        return favNewsDTOList;
    }

}
