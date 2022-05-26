package com.example.appz.services;

import com.example.appz.models.News;
import com.example.appz.models.User;
import com.example.appz.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public List<News> getAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var news = newsRepository.findAll(paging);
        return news.toList();
    }

    public Optional<News> getById(int id) {
        return newsRepository.findById(id);
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public Optional<News> delete(int id) {
        var news = this.getById(id);
        newsRepository.deleteById(id);
        return news;
    }
}
