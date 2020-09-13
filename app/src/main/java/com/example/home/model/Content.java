package com.example.home.model;

import com.example.home.model.enums.ContentType;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Content {
    private int id;
    private String title;
    private String imageUrl;
    private LocalDateTime createdTime;
    private String body;
    private boolean isFavourites;
    private ContentType contentType;
}
