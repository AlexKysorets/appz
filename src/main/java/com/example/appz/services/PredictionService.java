package com.example.appz.services;

import com.example.appz.models.Prediction;
import com.example.appz.repositories.PredictionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PredictionService {
    private final PredictionRepository predictionRepository;

    public List<Prediction> getAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var predictions = predictionRepository.findAll(paging);
        return predictions.toList();
    }

    public Optional<Prediction> getById(int id) {
        return predictionRepository.findById(id);
    }

    public Prediction save(Prediction prediction) {
        return predictionRepository.save(prediction);
    }

    public Optional<Prediction> delete(int id) {
        var prediction = this.getById(id);
        predictionRepository.deleteById(id);
        return prediction;
    }
}
