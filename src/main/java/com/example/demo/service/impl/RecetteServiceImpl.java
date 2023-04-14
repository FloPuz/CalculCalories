package com.example.demo.service.impl;

import com.example.demo.dto.IngredientsDto;
import com.example.demo.dto.IngredientsRESTDto;
import com.example.demo.dto.RecettesDto;
import com.example.demo.dto.RecettesRESTDto;
import com.example.demo.entity.Ingredients;
import com.example.demo.entity.Recettes;
import com.example.demo.repository.IngredientsRepository;
import com.example.demo.repository.RecettesRepository;
import com.example.demo.service.RecettesService;
import com.example.demo.service.mapper.IngredientMapper;
import com.example.demo.service.mapper.RecetteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class RecetteServiceImpl implements RecettesService {

    @Autowired
    private RecettesRepository _recettesRepository;

    @Autowired
    private IngredientsRepository _ingredientsRepository;

    @Autowired
    private RecetteMapper _recetteMapper;
    @Autowired
    private IngredientMapper _ingredientMapper;

    @Override
    public List<RecettesDto> findAll() {
        return _recettesRepository.findAll().stream().map(x -> _recetteMapper.recettesDto(x)).collect(toList());
    }

    @Override
    @Transactional
    public void insertPostedRecette(RecettesRESTDto recettesRESTDto) {
        RecettesDto recettesDto = new RecettesDto();
        recettesDto.setNbPortions(recettesRESTDto.getNbPortions());
        recettesDto.setInstructions(recettesRESTDto.getInstructions());
        recettesDto.setNomRecette(recettesRESTDto.getNomRecette());
        List<IngredientsDto> ingredientsDtoList = new ArrayList<>();
        //A ameliorer
        Map<String,Double> mapQuantityUnit = new HashMap<>();

        for (IngredientsRESTDto ingredientsREST :
                recettesRESTDto.getIngredientsRESTDtos()) {
            IngredientsDto ingredientsDto = new IngredientsDto(ingredientsREST.getNomIngredient(), ingredientsREST.getCalories());

        }

        //Source d'erreur comment j'enregistre alos qu'il y a cette reference cyclique
        //ingredientsDtoList.forEach(ingredient -> _ingredientsRepository.save(_ingredientMapper.ingredients(ingredient)));
        recettesDto.setIngredientsDtoList(ingredientsDtoList);


        Recettes recetteEntity = _recetteMapper.recettes(recettesDto);
        //recetteEntity.setIngredients(ingredientsDtoList);

        //_recettesRepository.save();
    }


}
