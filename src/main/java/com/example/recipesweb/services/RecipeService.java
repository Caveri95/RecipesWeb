package com.example.recipesweb.services;

import com.example.recipesweb.model.Recipe;

public interface RecipeService {

    void addRecipe(Recipe recipe);
    void getRecipe(int count);
}
