package com.example.demo.service;

import com.example.demo.dto.RecettesDto;
import com.example.demo.entity.Ingredients;
import com.example.demo.entity.Recettes;

import java.util.List;

public interface RecettesService {
    List<RecettesDto> findAll();

}
