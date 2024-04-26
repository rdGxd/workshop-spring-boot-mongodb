package com.rodrigosivla.workshopmongo.services;

import com.rodrigosivla.workshopmongo.domain.User;
import com.rodrigosivla.workshopmongo.repository.UserRepository;
import com.rodrigosivla.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
