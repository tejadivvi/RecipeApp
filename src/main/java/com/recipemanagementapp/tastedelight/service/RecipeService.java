package com.recipemanagementapp.tastedelight.service;

import com.recipemanagementapp.tastedelight.entity.Recipe;
import com.recipemanagementapp.tastedelight.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void removeRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    public List<Recipe> getVegetarianRecipes() {
        return recipeRepository.findByVegetarianTrue();
    }

    public List<Recipe> getRecipesByServings(int count) {
        return recipeRepository.findByServings(count);
    }

    public List<Recipe> getRecipesByIngredients(List<String> includeIngredients, List<String> excludeIngredients) {
        if (includeIngredients != null && !includeIngredients.isEmpty()) {
            if (excludeIngredients != null && !excludeIngredients.isEmpty()) {
                return recipeRepository.findByIngredientsInAndIngredientsNotIn(includeIngredients, excludeIngredients);
            } else {
                return recipeRepository.findByIngredientsIn(includeIngredients);
            }
        } else if (excludeIngredients != null && !excludeIngredients.isEmpty()) {
            return recipeRepository.findByIngredientsNotIn(excludeIngredients);
        }

        // If no ingredients provided, return all recipes
        return recipeRepository.findAll();
    }

    public List<Recipe> getRecipesByInstructions(String keyword) {
        return recipeRepository.findByInstructionsContainingIgnoreCase(keyword);
    }

}