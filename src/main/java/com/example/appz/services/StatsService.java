package com.example.appz.services;

import com.example.appz.models.Stats;
import com.example.appz.models.User;
import com.example.appz.repositories.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatsService {
    private final StatsRepository statsRepository;

    public List<Stats> getAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var stats = statsRepository.findAll(paging);
        return stats.toList();
    }

    public Optional<Stats> getById(int id) {
        return statsRepository.findById(id);
    }

    public Stats save(Stats stats) {
        return statsRepository.save(stats);
    }

    public Optional<Stats> delete(int id) {
        var stats = this.getById(id);
        statsRepository.deleteById(id);
        return stats;
    }
}
