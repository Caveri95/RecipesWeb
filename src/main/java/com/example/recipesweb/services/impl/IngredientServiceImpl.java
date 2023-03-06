package com.example.recipesweb.services.impl;

import com.example.recipesweb.model.Ingredient;
import com.example.recipesweb.services.IngredientNotFoundException;
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
        return null;
    }

    @Override
    public Ingredient getIngredient(int count) {
        try {
            if (ingredients.get(count) != null) {
                ingredients.get(count);
            } else throw new IngredientNotFoundException("Нет такого ингредиента!");
        } catch (IngredientNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return ingredients.get(count);
    }
}

