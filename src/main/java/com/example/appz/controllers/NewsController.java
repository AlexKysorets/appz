package com.example.appz.controllers;

import com.example.appz.models.News;
import com.example.appz.models.User;
import com.example.appz.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping("")
    public ResponseEntity<List<News>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                             @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(newsService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<News>> getById(@PathVariable int id) {
        return ResponseEntity.ok(newsService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<News> create(@RequestBody News news) {
        return ResponseEntity.ok(newsService.save(news));
    }

    @PutMapping("/update")
    public ResponseEntity<News> update(@RequestBody News news) {
        return ResponseEntity.ok(newsService.save(news));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<News>> delete(@PathVariable int id) {
        return ResponseEntity.ok(newsService.delete(id));
    }
}
