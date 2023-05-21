package com.reipemanagementapp.tastedelight;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipemanagementapp.tastedelight.entity.Recipe;
import com.recipemanagementapp.tastedelight.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RecipeService recipeService;

    @Test
    void addRecipe_shouldReturnNewRecipe() throws Exception {

        Recipe recipe = new Recipe("Salmon Fry in gas", false, 4, Arrays.asList("salmon", "spices", "Mint"), "Preheat the oven to 400°F (200°C). Season the salmon with spices and marinate for 15 minutes. Bake in the preheated oven for 12-15 minutes or until the salmon is cooked through. Garnish with fresh mint leaves and serve hot.");
        when(recipeService.addRecipe(any(Recipe.class))).thenReturn(recipe);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/recipes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipe)))
                .andExpect(status().isOk())
                .andReturn();
        Recipe responseRecipe = objectMapper.readValue(result.getResponse().getContentAsString(), Recipe.class);
        assertThat(responseRecipe).isEqualTo(recipe);
    }

    @Test
    void removeRecipe_shouldReturnNoContent() throws Exception {
        Long recipeId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/recipes/{recipeId}", recipeId))
                .andExpect(status().isNoContent());
    }

    @Test
    void getAllRecipes_shouldReturnListOfRecipes() throws Exception {

        Recipe recipe1 = new Recipe("Recipe 1", true, 2, Arrays.asList("Ingredient 1", "Ingredient 2"), "Instructions");
        Recipe recipe2 = new Recipe("Recipe 2", false, 4, Arrays.asList("Ingredient 3", "Ingredient 4"), "Instructions");
        List<Recipe> recipes = Arrays.asList(recipe1, recipe2);
        when(recipeService.getAllRecipes()).thenReturn(recipes);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/recipes"))
                .andExpect(status().isOk())
                .andReturn();

        List<Recipe> responseRecipes = Arrays.asList(objectMapper.readValue(result.getResponse().getContentAsString(), Recipe[].class));
        assertThat(responseRecipes).containsExactlyInAnyOrderElementsOf(recipes);
    }

    @Test
    void getVegetarianRecipes_shouldReturnListOfVegetarianRecipes() throws Exception {

        Recipe recipe1 = new Recipe("Recipe 1", true, 2, Arrays.asList("Ingredient 1", "Ingredient 2"), "Instructions");
        Recipe recipe2 = new Recipe("Recipe 2", false, 4, Arrays.asList("Ingredient 3", "Ingredient 4"), "Instructions");
        List<Recipe> recipes = Collections.singletonList(recipe1);
        when(recipeService.getVegetarianRecipes()).thenReturn(recipes);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/recipes/vegetarian"))
                .andExpect(status().isOk())
                .andReturn();
        List<Recipe> responseRecipes = Arrays.asList(objectMapper.readValue(result.getResponse().getContentAsString(), Recipe[].class));
        assertThat(responseRecipes).containsExactlyInAnyOrderElementsOf(recipes);
    }

    @Test
    void getRecipesByServings_shouldReturnListOfRecipesWithGivenServings() throws Exception {

        int servings = 4;
        Recipe recipe1 = new Recipe("Recipe 1", true, 2, Arrays.asList("Ingredient 1", "Ingredient 2"), "Instructions");
        Recipe recipe2 = new Recipe("Recipe 2", false, 4, Arrays.asList("Ingredient 3", "Ingredient 4"), "Instructions");
        List<Recipe> recipes = Collections.singletonList(recipe2);
        when(recipeService.getRecipesByServings(servings)).thenReturn(recipes);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/recipes/servings/{count}", servings))
                .andExpect(status().isOk())
                .andReturn();
        List<Recipe> responseRecipes = Arrays.asList(objectMapper.readValue(result.getResponse().getContentAsString(), Recipe[].class));
        assertThat(responseRecipes).containsExactlyInAnyOrderElementsOf(recipes);
    }
    @Test
    void getRecipesByInstructions_shouldReturnListOfRecipesWithMatchingInstructions() throws Exception {

        String keyword = "Instructions";
        Recipe recipe1 = new Recipe("Recipe 1", true, 2, Arrays.asList("Ingredient 1", "Ingredient 2"), "Instructions");
        Recipe recipe2 = new Recipe("Recipe 2", false, 4, Arrays.asList("Ingredient 3", "Ingredient 4"), "Instructions");
        List<Recipe> recipes = Arrays.asList(recipe1, recipe2);
        when(recipeService.getRecipesByInstructions(keyword)).thenReturn(recipes);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/recipes/instructions")
                .param("keyword", keyword))
                .andExpect(status().isOk())
                .andReturn();
        List<Recipe> responseRecipes = Arrays.asList(objectMapper.readValue(result.getResponse().getContentAsString(), Recipe[].class));
        assertThat(responseRecipes).containsExactlyInAnyOrderElementsOf(recipes);
    }
}