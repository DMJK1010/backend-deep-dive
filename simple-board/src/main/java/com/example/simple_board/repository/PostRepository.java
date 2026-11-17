package com.example.simple_board.repository;

import com.example.simple_board.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
    List<Post> findAll();
    void delete(Long id);
}
