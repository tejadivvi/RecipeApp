package com.reipemanagementapp.tastedelight;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@org.springframework.boot.test.context.SpringBootTest(classes = com.recipemanagementapp.tastedelight.TasteDelightApplication.class)
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private com.recipemanagementapp.tastedelight.service.RecipeService recipeService;

    @Autowired
    private com.recipemanagementapp.tastedelight.controller.RecipeController recipeController;

    @Test
    public void testGetAllRecipes() {
        List<com.recipemanagementapp.tastedelight.entity.Recipe> recipes = new ArrayList<>();
        when(recipeService.getAllRecipes()).thenReturn(recipes);

        List<com.recipemanagementapp.tastedelight.entity.Recipe> result = recipeController.getAllRecipes();

        assertEquals(recipes, result);
    }
}