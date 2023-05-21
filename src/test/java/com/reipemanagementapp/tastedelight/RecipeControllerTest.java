package com.reipemanagementapp.tastedelight;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RecipeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private com.recipemanagementapp.tastedelight.controller.RecipeController recipeController;

    @Autowired
    private com.recipemanagementapp.tastedelight.service.RecipeService recipeService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @After
    public void tearDown() {
        EasyMock.verify(recipeService);
    }

    @Test
    public void testGetAllRecipes() {

        List<com.recipemanagementapp.tastedelight.entity.Recipe> recipes = new ArrayList<>();
        EasyMock.expect(recipeService.getAllRecipes()).andReturn(recipes);
        EasyMock.replay(recipeService);
        List<com.recipemanagementapp.tastedelight.entity.Recipe> result = recipeController.getAllRecipes();
        assertEquals(recipes, result);
    }

    @Test
    public void testAddRecipe() {

        com.recipemanagementapp.tastedelight.entity.Recipe recipe = new com.recipemanagementapp.tastedelight.entity.Recipe();
        EasyMock.expect(recipeService.addRecipe(recipe)).andReturn(recipe);
        EasyMock.replay(recipeService);
        com.recipemanagementapp.tastedelight.entity.Recipe result = recipeController.addRecipe(recipe);
        assertEquals(recipe, result);
    }
}



