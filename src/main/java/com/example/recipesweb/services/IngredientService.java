package com.example.recipesweb.services;

import com.example.recipesweb.model.Ingredient;

public interface IngredientService {

    void addIngredient(Ingredient ingredient);
    void getIngredient(int count);
}
