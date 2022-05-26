package com.example.appz.controllers;

import com.example.appz.models.User;
import com.example.appz.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                             @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(userService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<User>> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @GetMapping("/role")
    public ResponseEntity<List<User>> getByRole(@RequestParam String role,
                                                @RequestParam(required = false, defaultValue = "10") Integer size,
                                                @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(userService.getByRole(role, page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<User>> delete(@PathVariable int id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
