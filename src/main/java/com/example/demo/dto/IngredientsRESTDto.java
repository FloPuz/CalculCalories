package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

public class IngredientsRESTDto implements Serializable {

    private double quantity;
    private String unit;
    private IngredientsDto ingredientsDto;



}
