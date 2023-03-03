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

    @GetMapping("/add")
    public void addIngredient(@RequestParam String name, @RequestParam int count, @RequestParam String measureUnit) {
        ingredientService.addIngredient(new Ingredient(name, count, measureUnit));
    }
}
