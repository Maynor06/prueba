package com.noticiero.demo.Controllers;

import com.noticiero.demo.DTOS.FavNewsDTO;
import com.noticiero.demo.DTOS.FavNewsDetailDTO;
import com.noticiero.demo.Service.FavNewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fav")
public class FavNewsController {

    private FavNewsService favNewsService;

    public FavNewsController(FavNewsService favNewsService) {
        this.favNewsService = favNewsService;
    }

    @PostMapping("/newFav")
    public ResponseEntity<FavNewsDetailDTO> newFav(@RequestBody FavNewsDTO favNewsDTO) {
        FavNewsDetailDTO favNewsDTO1 = favNewsService.addFavNews(favNewsDTO);
        return ResponseEntity.ok(favNewsDTO1);
    }

    @DeleteMapping("/removeFav")
    public ResponseEntity<String> removeFav(@RequestParam Long userId, @RequestParam Long newsId) {
        favNewsService.deleteFavNews(userId, newsId);

        return ResponseEntity.ok("Se ha eliminado el registro");
    }

    @GetMapping("/myFavs/{id}")
    public ResponseEntity<List<FavNewsDTO>> getMyFavs(@PathVariable String id) {
        List<FavNewsDTO> dtoList = favNewsService.getAllFavByUserId(Long.valueOf(id));
        return ResponseEntity.ok(dtoList);
    }

}
