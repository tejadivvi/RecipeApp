package com.recipemanagementapp.tastedelight.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@javax.persistence.Entity
@javax.persistence.Table(name = "recipes")
@Getter
@Setter
public class Recipe {

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean vegetarian;

    private int servings;

    @javax.persistence.ElementCollection
    @javax.persistence.CollectionTable(name = "recipe_ingredients", joinColumns = @javax.persistence.JoinColumn(name = "recipe_id"))
    @javax.persistence.Column(name = "ingredient")
    private List<String> ingredients;

    private String instructions;

    // Constructors

    public Recipe() {
    }

    public Recipe(String name, boolean vegetarian, int servings, List<String> ingredients, String instructions) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Override toString() to provide a meaningful representation of the object
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", servings=" + servings +
                ", ingredients=" + ingredients +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    public void setId(Long recipeId) {
    }
}