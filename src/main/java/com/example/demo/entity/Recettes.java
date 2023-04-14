package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recettes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recette")
    private Long idRecette;
    @Column(name = "nom_recette")
    private String nomRecette;
    @Column(name = "instructions")
    private String instructions;
    @Column(name = "nb_portions")
    private int nbPortions;
    @ManyToMany
    @JoinTable(
            name="recette_ingredient",
            joinColumns=@JoinColumn(name="id_recette"),
            inverseJoinColumns=@JoinColumn(name="id_ingredient"))
    private List<Ingredients> ingredients = new ArrayList<>();

    public Recettes() {
    }

    public Recettes(Long idRecette, String nomRecette, String instructions, int nbPortions) {
        this.idRecette = idRecette;
        this.nomRecette = nomRecette;
        this.instructions = instructions;
        this.nbPortions = nbPortions;
    }

    public Long getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Long idRecette) {
        this.idRecette = idRecette;
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

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
