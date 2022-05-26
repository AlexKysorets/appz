package com.example.appz.services;

import com.example.appz.models.User;
import com.example.appz.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var users = userRepository.findAll(paging);
        return users.toList();
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getByRole(String role, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        var users = userRepository.findByRole(role, paging);
        return users.toList();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> delete(int id) {
        var user = this.getById(id);
        userRepository.deleteById(id);
        return user;
    }
}
