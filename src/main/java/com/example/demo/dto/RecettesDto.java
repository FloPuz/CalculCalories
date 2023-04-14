package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;


public class RecettesDto implements Serializable {

    private Long id;
    private String nomRecette;
    private String instructions;
    private int nbPortions;
    private Double calorieRecette;

    //TODO Create a specific dto to store the quantity
    private List<IngredientsDto> ingredientsDtoList;

    public RecettesDto(Long id, String nomRecette, String instructions, int nbPortions) {
        this.id = id;
        this.nomRecette = nomRecette;
        this.instructions = instructions;
        this.nbPortions = nbPortions;
        this.calorieRecette = this.getCalorieRecette();
    }

    public RecettesDto() {

    }

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

    //ToDO
    public Double getCalorieRecette() {
        Double calorie = Double.valueOf(0);
        for (IngredientsDto ingredientsDto:
                ingredientsDtoList ) {
            calorie += ingredientsDto.getCalories();
        }
        calorie = calorie*nbPortions;
        setCalorieRecette(calorie);
        return calorie;
    }

    private void setCalorieRecette(Double calorie){
        this.calorieRecette = calorie;
    }

    public List<IngredientsDto> getIngredientsDtoList() {
        return ingredientsDtoList;
    }

    public void setIngredientsDtoList(List<IngredientsDto> ingredientsDtoList) {
        this.ingredientsDtoList = ingredientsDtoList;
    }
}
