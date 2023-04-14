package com.example.demo.service.mapper;

import com.example.demo.dto.IngredientsDto;
import com.example.demo.dto.RecettesDto;
import com.example.demo.entity.Ingredients;
import com.example.demo.entity.Recettes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecetteMapper {

    @Autowired
    private IngredientMapper ingredientMapper;

    public RecettesDto recettesDto(Recettes recettes){
        if (recettes == null) {
            return null;
        }

        List<IngredientsDto> ingredientDtos = recettes.getIngredients().stream()
                .map(ingredient -> ingredientMapper.ingredientsDto(new Ingredients(ingredient.getIdIngredient(),ingredient.getNomIngredient(),ingredient.getCalories())))
                .collect(Collectors.toList());

        RecettesDto recettesDto = new RecettesDto();
        recettesDto.setId(recettes.getIdRecette());
        recettesDto.setNomRecette(recettes.getNomRecette());
        recettesDto.setInstructions(recettes.getInstructions());
        recettesDto.setNbPortions(recettes.getNbPortions());
        recettesDto.setIngredientsDtoList(ingredientDtos);

        return recettesDto;
    }
}
