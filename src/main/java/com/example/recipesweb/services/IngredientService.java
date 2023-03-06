package com.example.recipesweb.services;

import com.example.recipesweb.model.Ingredient;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient);
    Ingredient getIngredient(int count);
}
