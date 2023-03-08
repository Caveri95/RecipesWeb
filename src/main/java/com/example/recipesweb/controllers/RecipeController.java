package com.example.recipesweb.controllers;

import com.example.recipesweb.model.Recipe;
import com.example.recipesweb.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe createRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(createRecipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe recipe1 = recipeService.editRecipe(id, recipe);
        if (recipe1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable long id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        if (allRecipes.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allRecipes);
    }
}
