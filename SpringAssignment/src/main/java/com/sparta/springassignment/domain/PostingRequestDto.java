package com.sparta.springassignment.domain;

import lombok.Getter;

@Getter
public class PostingRequestDto {
    private Long id;
    private String title;
    private String username;
    private String password;
    private String contents;
}
