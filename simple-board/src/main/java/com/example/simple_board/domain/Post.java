package com.example.simple_board.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public void assignId(Long id){
        this.id = id;
    }

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        createdAt = LocalDateTime.now();
    }
}
