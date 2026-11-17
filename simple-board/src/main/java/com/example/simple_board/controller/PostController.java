package com.example.simple_board.controller;

import com.example.simple_board.dto.PostCreateRequest;
import com.example.simple_board.dto.PostResponse;
import com.example.simple_board.dto.PostUpdateRequest;
import com.example.simple_board.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 1. 게시글 등록
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse createPost(@RequestBody @Valid PostCreateRequest request) {
        return postService.createPost(request);
    }

    // 2. 게시글 단건 조회: GET /posts/{id}
    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    // 3. 게시글 목록 조회: GET /posts
    @GetMapping
    public List<PostResponse> getPosts(){
        return postService.getPosts();
    }

    // 4. 게시글 수정: PATCH /posts/{id}
    @PatchMapping("/{id}")
    public PostResponse updatePost(@PathVariable Long id, @RequestBody @Valid PostUpdateRequest request) {
        return postService.updatePost(id, request);
    }

    // 5. 게시글 삭제: DELETE /posts/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}