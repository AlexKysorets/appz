package com.example.appz.services;

import com.example.appz.models.Subscription;
import com.example.appz.models.User;
import com.example.appz.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var subscriptions = subscriptionRepository.findAll(paging);
        return subscriptions.toList();
    }

    public Optional<Subscription> getById(int id) {
        return subscriptionRepository.findById(id);
    }

    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Optional<Subscription> delete(int id) {
        var subscription = this.getById(id);
        subscriptionRepository.deleteById(id);
        return subscription;
    }
}
