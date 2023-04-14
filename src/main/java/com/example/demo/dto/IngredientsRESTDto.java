package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

public class IngredientsRESTDto implements Serializable {

    private double quantity;
    private String unit;
    private String nomIngredient;
    private Double calories;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
}
