package com.example.recipesweb.controllers;

import com.example.recipesweb.model.Recipe;
import com.example.recipesweb.services.RecipeService;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping("/add")
    public void addRecipe(@RequestParam Recipe recipe) {
        recipeService.addRecipe(recipe);
    }
}
