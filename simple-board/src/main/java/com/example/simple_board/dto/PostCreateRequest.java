package com.example.simple_board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class PostCreateRequest {
    @NotBlank
    @Size(max = 50)
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String author;
}