package com.example.recipesweb.services;

import com.example.recipesweb.model.Recipe;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);
    Recipe getRecipe(int count);
}
