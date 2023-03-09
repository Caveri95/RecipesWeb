package com.example.recipesweb.services;

import com.example.recipesweb.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient);
    Ingredient getIngredient(long count);
    Ingredient editIngredient(long id, Ingredient ingredient);
    Boolean deleteIngredient(long id);
    List<Ingredient> getAllIngredients();
}
