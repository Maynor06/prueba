package com.noticiero.demo.Service;

import com.noticiero.demo.DTOS.FavNewsDTO;
import com.noticiero.demo.Models.FavNews;
import com.noticiero.demo.Models.FavNewsId;
import com.noticiero.demo.Models.News;
import com.noticiero.demo.Models.Users;
import com.noticiero.demo.Repository.FavNewsRepository;
import com.noticiero.demo.Repository.NewsRepository;
import com.noticiero.demo.Repository.UsersRepository;
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

    public FavNewsDTO addFavNews(FavNewsDTO favNews) {
        Users user = usersRepository.findById(favNews.getUserId()).orElseThrow(() -> new RuntimeException("User not found") );
        News news = newsRepository.findById(favNews.getNewsId()).orElseThrow(() -> new RuntimeException("News not found") );

        FavNewsId favNewsId = new FavNewsId(favNews.getUserId(), favNews.getNewsId());
        FavNews favNews1 = new FavNews();
        favNews1.setUser(user);
        favNews1.setNews(news);

        favNewsRepository.save(favNews1);
        return favNews;
    }

    public String removeFavNew(FavNewsDTO favNews) {
        FavNewsId favNewsId = new FavNewsId(favNews.getUserId(), favNews.getNewsId());

        if (!favNewsRepository.existsById(favNewsId) ) {
            throw new IllegalArgumentException("La noticia favorita no existe");
        }

        if (favNewsRepository.deleteById(favNewsId)){
            return "Se elimino con exito!!";
        }

        return "";
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
