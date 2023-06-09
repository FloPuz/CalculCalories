package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ingredient")
    private Long idIngredient;
    @Column(name = "nom_ingredient")
    private String nomIngredient;
    @Column(name = "calories")
    private Double calories;
    @ManyToMany(mappedBy = "ingredients")
    private List<Recettes> recettes = new ArrayList<>();


    public Ingredients(String nomIngredient, Double calories) {
        this.nomIngredient = nomIngredient;
        this.calories = calories;
    }

    public Ingredients() {
    }

    public Ingredients(Long idIngredient, String nomIngredient, Double calories) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
        this.calories = calories;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
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

    public List<Recettes> getRecettes() {
        return recettes;
    }

    public void setRecettes(List<Recettes> recettes) {
        this.recettes = recettes;
    }
}
