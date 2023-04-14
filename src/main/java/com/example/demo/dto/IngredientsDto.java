package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

public class IngredientsDto implements Serializable {

    private Long id;
    private String nomIngredient;
    private Double calories;
    @JsonBackReference
    private List<RecettesDto> recettesDtosList;


    public IngredientsDto() {
    }

    public IngredientsDto(Long id, String nomIngredient, Double calories) {
        this.id = id;
        this.nomIngredient = nomIngredient;
        this.calories = calories/100;
    }

    public IngredientsDto(String nomIngredient, Double calories) {
        this.nomIngredient = nomIngredient;
        this.calories = calories/100;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public List<RecettesDto> getRecettesDtosList() {
        return recettesDtosList;
    }

    public void setRecettesDtosList(List<RecettesDto> recettesDtosList) {
        this.recettesDtosList = recettesDtosList;
    }
}
