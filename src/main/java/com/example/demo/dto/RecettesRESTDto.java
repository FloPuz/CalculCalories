package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RecettesRESTDto implements Serializable {

    private Long id;
    private String nomRecette;
    private String instructions;
    private int nbPortions;
    private Double calorieRecette;
    private List<IngredientsRESTDto> ingredientsRESTDtos = new ArrayList<IngredientsRESTDto>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getNbPortions() {
        return nbPortions;
    }

    public void setNbPortions(int nbPortions) {
        this.nbPortions = nbPortions;
    }

    public Double getCalorieRecette() {
        Double calorie = Double.valueOf(0);
        for (IngredientsRESTDto ingredientsDto:
                ingredientsRESTDtos ) {
            calorie += ingredientsDto.getCalories();
        }
        calorie = calorie*nbPortions;
        setCalorieRecette(calorie);
        return calorie;
    }

    public void setCalorieRecette(Double calorieRecette) {
        this.calorieRecette = calorieRecette;
    }

    public List<IngredientsRESTDto> getIngredientsRESTDtos() {
        return ingredientsRESTDtos;
    }

    public void setIngredientsRESTDtos(List<IngredientsRESTDto> ingredientsRESTDtos) {

        for (IngredientsRESTDto ingredientsRESTDto :
                ingredientsRESTDtos) {
            this.ingredientsRESTDtos.add(ingredientsRESTDto);
        }
    }
}
