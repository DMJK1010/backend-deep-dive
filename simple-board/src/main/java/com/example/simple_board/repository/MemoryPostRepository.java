package com.example.simple_board.repository;

import com.example.simple_board.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryPostRepository implements PostRepository {

    private final Map<Long, Post> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Post save(Post post) {
        long newID = sequence.getAndIncrement();
        post.assignId(newID);
        store.put(newID, post);
        return post;
    }

    @Override
    public Optional<Post> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Post> findAll(){
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id){
        store.remove(id);
    }
}
