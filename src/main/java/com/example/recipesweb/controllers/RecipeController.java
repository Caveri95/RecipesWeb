package com.example.recipesweb.controllers;

import com.example.recipesweb.model.Ingredient;
import com.example.recipesweb.model.Recipe;
import com.example.recipesweb.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/get")
    public void getRecipe(@RequestParam int count) {
        recipeService.getRecipe(count);
    }

    @GetMapping("/add")
    public void addRecipe(@RequestParam String name, @RequestParam int time, @RequestParam ArrayList<Ingredient> ingredients, @RequestParam ArrayList<String> instruction) {
        recipeService.addRecipe(new Recipe(name, time, ingredients, instruction));
    }
}
