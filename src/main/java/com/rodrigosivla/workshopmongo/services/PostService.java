package com.rodrigosivla.workshopmongo.services;

import com.rodrigosivla.workshopmongo.domain.Post;
import com.rodrigosivla.workshopmongo.repository.PostRepository;
import com.rodrigosivla.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado " + id));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
}
