package com.example.recipesweb.services.impl;

import com.example.recipesweb.model.Recipe;
import com.example.recipesweb.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    public static long recipeCounter = 0L;
    private static final Map<Long, Recipe> recipes = new TreeMap<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(recipeCounter++, recipe);
        return recipe;
    }
    @Override
    public Recipe getRecipe(long count) {
        return recipes.get(count);
    }
    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            return recipe;
        }
        return null;
    }
    @Override
    public Boolean deleteRecipe(long id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> allRecipes = new ArrayList<>();
        for(Map.Entry<Long, Recipe> entry : recipes.entrySet()){
            allRecipes.add(entry.getValue());
        }
        return allRecipes;
    }
}
