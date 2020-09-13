package com.example.home.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ContentType {
    NEWS(0),
    SHOWS(1),
    MUSIC(2);

    private int id;
}
