package com.example.simple_board.service;

import com.example.simple_board.domain.Post;
import com.example.simple_board.dto.PostCreateRequest;
import com.example.simple_board.dto.PostResponse;
import com.example.simple_board.dto.PostUpdateRequest;
import com.example.simple_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponse createPost(PostCreateRequest request) {
        Post post = postRepository.save(new Post(request.getTitle(), request.getContent(), request.getAuthor()));
        return PostResponse.from(post);
    }

    public PostResponse getPost(Long id){
        Post post = findPostById(id);
        return PostResponse.from(post);
    }

    public List<PostResponse> getPosts(){
        List<Post> posts = postRepository.findAll();

        List<PostResponse> responseList = new ArrayList<>();

        for (Post post : posts){
            responseList.add(PostResponse.from(post));
        }

        return responseList;
    }

    public PostResponse updatePost(Long id, PostUpdateRequest request) {
        Post post = findPostById(id);
        post.update(request.getTitle(), request.getContent());
        return PostResponse.from(post);
    }

    public void deletePost(Long id){
        Post post = findPostById(id);
        postRepository.delete(post.getId());
    }

    private Post findPostById(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다. id=" + id));
    }

}
