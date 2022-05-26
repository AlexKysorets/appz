package com.example.appz.controllers;

import com.example.appz.models.Prediction;
import com.example.appz.models.User;
import com.example.appz.services.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/predictions")
@RequiredArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;

    @GetMapping("")
    public ResponseEntity<List<Prediction>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                   @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(predictionService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Prediction>> getById(@PathVariable int id) {
        return ResponseEntity.ok(predictionService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Prediction> create(@RequestBody Prediction prediction) {
        return ResponseEntity.ok(predictionService.save(prediction));
    }

    @PutMapping("/update")
    public ResponseEntity<Prediction> update(@RequestBody Prediction prediction) {
        return ResponseEntity.ok(predictionService.save(prediction));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Prediction>> delete(@PathVariable int id) {
        return ResponseEntity.ok(predictionService.delete(id));
    }
}
