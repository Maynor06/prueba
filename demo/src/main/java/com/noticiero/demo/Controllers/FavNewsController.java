package com.noticiero.demo.Controllers;

import com.noticiero.demo.DTOS.FavNewsDTO;
import com.noticiero.demo.Service.FavNewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/Fav")
public class FavNewsController {

    private FavNewsService favNewsService;

    public FavNewsController(FavNewsService favNewsService) {
        this.favNewsService = favNewsService;
    }

    @PostMapping("/newFav")
    public ResponseEntity<FavNewsDTO> newFav(@RequestBody FavNewsDTO favNewsDTO) {
        favNewsService.addFavNews(favNewsDTO);
        return ResponseEntity.ok(favNewsDTO);
    }

    @DeleteMapping("/removeFav")
    public ResponseEntity<String> removeFav(@RequestBody FavNewsDTO favNewsDTO) {
        favNewsService.removeFavNew(favNewsDTO);
        return ResponseEntity.ok(favNewsDTO.toString());
    }

    @GetMapping("/myFavs/{id}")
    public ResponseEntity<List<FavNewsDTO>> getMyFavs(@PathVariable Long userId) {
        List<FavNewsDTO> dtoList = favNewsService.getAllFavByUserId(userId);
        return ResponseEntity.ok(dtoList);
    }

}
