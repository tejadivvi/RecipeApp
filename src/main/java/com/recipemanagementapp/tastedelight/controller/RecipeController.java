package com.recipemanagementapp.tastedelight.controller;

import com.recipemanagementapp.tastedelight.entity.Recipe;
import com.recipemanagementapp.tastedelight.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@PathVariable Long recipeId, @RequestBody Recipe recipe) {
        recipe.setId(recipeId);
        return recipeService.updateRecipe(recipe);
    }

    @DeleteMapping("/{recipeId}")
    public void removeRecipe(@PathVariable Long recipeId) {
        recipeService.removeRecipe(recipeId);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipeService.getVegetarianRecipes();
    }

    @GetMapping("/servings/{count}")
    public List<Recipe> getRecipesByServings(@PathVariable int count) {
        return recipeService.getRecipesByServings(count);
    }

    @GetMapping("/ingredients")
    public List<Recipe> getRecipesByIngredients(@RequestParam("include") List<String> includeIngredients,
                                                @RequestParam(value = "exclude", required = false) List<String> excludeIngredients) {
        return recipeService.getRecipesByIngredients(includeIngredients, excludeIngredients);
    }

    @GetMapping("/instructions")
    public List<Recipe> getRecipesByInstructions(@RequestParam("keyword") String keyword) {
        return recipeService.getRecipesByInstructions(keyword);
    }
}