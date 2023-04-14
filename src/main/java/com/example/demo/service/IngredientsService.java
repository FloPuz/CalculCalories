package com.example.demo.service;

import com.example.demo.dto.IngredientsDto;
import com.example.demo.entity.Ingredients;

import java.util.List;

public interface IngredientsService {
    List<IngredientsDto> findAll();
}
