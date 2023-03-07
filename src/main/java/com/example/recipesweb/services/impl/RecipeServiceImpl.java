package com.example.recipesweb.services.impl;

import com.example.recipesweb.model.Recipe;
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
        return recipes.get(count);
    }
}
