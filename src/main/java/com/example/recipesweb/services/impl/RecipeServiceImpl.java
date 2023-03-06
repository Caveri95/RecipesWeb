package com.example.recipesweb.services.impl;

import com.example.recipesweb.model.Recipe;
import com.example.recipesweb.services.RecipeNotFoundException;
import com.example.recipesweb.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    public static int recipeCounter = 0;
    private static final Map< Integer, Recipe> recipes = new TreeMap<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(recipeCounter++, recipe);
        return recipe;
    }
    @Override
    public Recipe getRecipe(int count) {
        try {
            if (recipes.get(count) != null) {
                recipes.get(count);
            } else throw new RecipeNotFoundException("Нет такого рецепта!");
        } catch (RecipeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return recipes.get(count);
    }
}
