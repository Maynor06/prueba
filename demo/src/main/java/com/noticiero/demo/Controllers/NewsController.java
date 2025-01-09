package com.noticiero.demo.Controllers;

import com.noticiero.demo.DTOS.NewsDTORequest;
import com.noticiero.demo.DTOS.NewsDTOResponse;
import com.noticiero.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/createNew")
    public ResponseEntity<NewsDTOResponse> createNew(@RequestBody NewsDTORequest newsDTORequest ) {
        NewsDTOResponse newsDTOResponse = newsService.addNews(newsDTORequest);
        return ResponseEntity.ok(newsDTOResponse);
    }

    @PutMapping("/editNew/{id}")
    public ResponseEntity<NewsDTOResponse> updateNew(@PathVariable Long id, @RequestBody NewsDTORequest newsDTORequest) {
        NewsDTOResponse newsDTOResponse = newsService.updateNews( id,newsDTORequest);
        return ResponseEntity.ok(newsDTOResponse);
    }

    @DeleteMapping("/deleteNew/{id}")
    public ResponseEntity<String> deleteNew(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.ok("Se elimino con exito");
    }

    @GetMapping("/newForCategory")
    public ResponseEntity<List<NewsDTOResponse>> getNewsForCategory(@RequestParam Long id){
        List<NewsDTOResponse> list = newsService.getNewsByCategoryId(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/newsOfAuthor")
    public ResponseEntity<List<NewsDTOResponse>> getNewsByAuthor(@RequestParam Long id){
        List<NewsDTOResponse> list = newsService.getNewsByUserId(id);
        return ResponseEntity.ok(list);
    }

}
