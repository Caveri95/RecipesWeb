package com.example.recipesweb.services.impl;

import com.example.recipesweb.model.Ingredient;
import com.example.recipesweb.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Service
public class IngredientServiceImpl implements IngredientService {

    public static long ingredientCounter = 0L;
    private static final Map<Long, Ingredient> ingredients = new TreeMap<>();

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(ingredientCounter++, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient getIngredient(long count) {
        return ingredients.get(count);
    }

    @Override
    public Ingredient editIngredient(long id, Ingredient ingredient) {
        if (ingredients.containsKey(id)) {
            ingredients.put(id, ingredient);
            return ingredient;
        }
        return null;
    }

    @Override
    public Boolean deleteIngredient(long id) {
        if (ingredients.containsKey(id)) {
            ingredients.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> allIngredients = new ArrayList<>();
        for(Map.Entry<Long, Ingredient> entry : ingredients.entrySet()){
            allIngredients.add(entry.getValue());
        }
        return allIngredients;
    }
}

