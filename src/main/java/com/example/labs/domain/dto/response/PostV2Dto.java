package com.example.labs.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PostV2Dto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class PostDto {
        long id;
        String title;
        String content;
        String author;
    }
}
