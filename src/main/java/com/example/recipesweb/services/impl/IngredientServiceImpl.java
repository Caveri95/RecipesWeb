package com.example.recipesweb.services.impl;

import com.example.recipesweb.model.Ingredient;
import com.example.recipesweb.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class IngredientServiceImpl implements IngredientService {

    public static int ingredientCounter = 0;
    private static final Map<Integer, Ingredient> ingredients = new TreeMap<>();

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(ingredientCounter++, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int count) {
        return ingredients.get(count);
    }
}

