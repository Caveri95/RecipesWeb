package com.example.recipesweb.controllers;

import com.example.recipesweb.model.Recipe;
import com.example.recipesweb.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "CRUD операции и др.эндпоинты для работы с рецептами")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    @Operation(summary = "Добавление рецепта", description = "Введите название рецепта, время его приготовления и необходимые ингредиенты")
    @ApiResponse(responseCode = "200", description = "Рецепт добавлен", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
    })
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe createRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(createRecipe);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск рецепта по его номеру", description = "Введите номер рецепта")
    @ApiResponse(responseCode = "200", description = "Рецепт найден", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
    })
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактирование рецепта", description = "Добавьте новый рецепт и выберите номер уже существующего для его редактирования")
    @ApiResponse(responseCode = "200", description = "Рецепт отредактирован", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
    })
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe recipe1 = recipeService.editRecipe(id, recipe);
        if (recipe1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe1);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление рецепта", description = "Введите номер рецепта, который нужно удалить")
    @ApiResponse(responseCode = "200", description = "Рецепт удален", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
    })
    public ResponseEntity<Void> deleteRecipeById(@PathVariable long id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Получить все имеющиеся рецепты")
    @ApiResponse(responseCode = "200", description = "Вывод всех рецептов", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
    })
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        if (allRecipes.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allRecipes);
    }
}
