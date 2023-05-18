package com.recipemanagementapp.tastedelight.repository;

import com.recipemanagementapp.tastedelight.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByVegetarianTrue();

    List<Recipe> findByServings(int count);

    List<Recipe> findByIngredientsIn(List<String> includeIngredients);

    List<Recipe> findByIngredientsNotIn(List<String> excludeIngredients);

    List<Recipe> findByIngredientsInAndIngredientsNotIn(List<String> includeIngredients, List<String> excludeIngredients);

    List<Recipe> findByInstructionsContainingIgnoreCase(String keyword);

}