package com.example.appz.controllers;

import com.example.appz.models.ContactUs;
import com.example.appz.models.User;
import com.example.appz.services.ContactUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactUsController {
    private final ContactUsService contactUsService;

    @GetMapping("")
    public ResponseEntity<List<ContactUs>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                  @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(contactUsService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ContactUs>> getById(@PathVariable int id) {
        return ResponseEntity.ok(contactUsService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ContactUs> create(@RequestBody ContactUs contactUs) {
        return ResponseEntity.ok(contactUsService.save(contactUs));
    }

    @PutMapping("/update")
    public ResponseEntity<ContactUs> update(@RequestBody ContactUs contactUs) {
        return ResponseEntity.ok(contactUsService.save(contactUs));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<ContactUs>> delete(@PathVariable int id) {
        return ResponseEntity.ok(contactUsService.delete(id));
    }
}
