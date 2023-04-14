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
public class IngredientMapper {

    @Autowired
    private RecetteMapper recetteMapper;

    public IngredientsDto ingredientsDto(Ingredients ingredients){
        if (ingredients == null) {
            return null;
        }
        IngredientsDto ingredientsDto = new IngredientsDto(ingredients.getIdIngredient(),ingredients.getNomIngredient(),ingredients.getCalories());
        List<RecettesDto> recettesDto = ingredients.getRecettes().stream()
                .map(recette -> recetteMapper.recettesDto(new Recettes(recette.getIdRecette(),recette.getNomRecette(),recette.getInstructions(), recette.getNbPortions())))
                .collect(Collectors.toList());

        ingredientsDto.setRecettesDtosList(recettesDto);
        return ingredientsDto;
    }

    public Ingredients ingredients(IngredientsDto ingredientsDto) {
        if (ingredientsDto == null) {
            return null;
        }
        Ingredients ingredients = new Ingredients(ingredientsDto.getNomIngredient(),ingredientsDto.getCalories());

        return ingredients;
    }
}
