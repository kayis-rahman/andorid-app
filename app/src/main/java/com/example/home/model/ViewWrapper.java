package com.example.home.model;

import com.example.home.model.enums.ViewType;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewWrapper {
    String title;
    List<ItemView> data;
    ViewType viewType;
}
