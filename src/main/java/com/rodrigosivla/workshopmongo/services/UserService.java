package com.rodrigosivla.workshopmongo.services;

import com.rodrigosivla.workshopmongo.domain.User;
import com.rodrigosivla.workshopmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public void update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        repo.save(newObj);
    }

    public void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
    
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
