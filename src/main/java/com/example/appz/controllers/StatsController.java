package com.example.appz.controllers;

import com.example.appz.models.Stats;
import com.example.appz.models.User;
import com.example.appz.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatsController {
    private final StatsService statsService;

    @GetMapping("")
    public ResponseEntity<List<Stats>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                              @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(statsService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Stats>> getById(@PathVariable int id) {
        return ResponseEntity.ok(statsService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Stats> create(@RequestBody Stats stats) {
        return ResponseEntity.ok(statsService.save(stats));
    }

    @PutMapping("/update")
    public ResponseEntity<Stats> update(@RequestBody Stats stats) {
        return ResponseEntity.ok(statsService.save(stats));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Stats>> delete(@PathVariable int id) {
        return ResponseEntity.ok(statsService.delete(id));
    }
}
