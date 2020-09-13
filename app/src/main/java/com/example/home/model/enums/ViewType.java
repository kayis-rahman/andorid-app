package com.example.home.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ViewType {
    CAROUSEL(0),
    NESTED_RECYCLER(1);

    private int id;
}
