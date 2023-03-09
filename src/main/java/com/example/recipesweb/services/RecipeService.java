package com.example.recipesweb.services;

import com.example.recipesweb.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);
    Recipe getRecipe(long count);
    Recipe editRecipe(long id, Recipe recipe);
    Boolean deleteRecipe(long id);
    List<Recipe> getAllRecipes();
}
