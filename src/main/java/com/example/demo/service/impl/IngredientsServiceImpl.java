package com.example.demo.service.impl;

import com.example.demo.dto.IngredientsDto;
import com.example.demo.entity.Ingredients;
import com.example.demo.repository.IngredientsRepository;
import com.example.demo.service.IngredientsService;
import com.example.demo.service.mapper.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientsRepository _ingredientsRepository;

    @Autowired
    private IngredientMapper _ingredientMapper;
    @Override
    public List<IngredientsDto> findAll() {
        return _ingredientsRepository.findAll().stream().map(x -> _ingredientMapper.ingredientsDto(x)).collect(Collectors.toList());
    }
}
