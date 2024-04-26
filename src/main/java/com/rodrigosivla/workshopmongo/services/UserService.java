package com.rodrigosivla.workshopmongo.services;

import com.rodrigosivla.workshopmongo.domain.User;
import com.rodrigosivla.workshopmongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }
}
