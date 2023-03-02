package com.example.recipesweb.controllers;

import com.example.recipesweb.model.Ingredient;
import com.example.recipesweb.services.IngredientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/get")
    public void getIngredient(@RequestParam int count) {
        ingredientService.getIngredient(count);
    }

    @PostMapping("/add")
    public void addIngredient(@RequestParam Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }
}
