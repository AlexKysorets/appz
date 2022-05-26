package com.example.appz.controllers;

import com.example.appz.models.Subscription;
import com.example.appz.models.User;
import com.example.appz.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping("")
    public ResponseEntity<List<Subscription>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                     @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(subscriptionService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Subscription>> getById(@PathVariable int id) {
        return ResponseEntity.ok(subscriptionService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Subscription> create(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.save(subscription));
    }

    @PutMapping("/update")
    public ResponseEntity<Subscription> update(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.save(subscription));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Subscription>> delete(@PathVariable int id) {
        return ResponseEntity.ok(subscriptionService.delete(id));
    }
}
