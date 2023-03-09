package com.example.recipesweb.controllers;

import com.example.recipesweb.model.Ingredient;
import com.example.recipesweb.services.IngredientService;
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
@RequestMapping("/ingredient")
@Tag(name = "Ингредиенты", description = "CRUD операции и др.эндпоинты для работы с ингредиентами")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @Operation(summary = "Добавление ингредиента", description = "Введите название ингредиента, его количество и меру")
    @ApiResponse(responseCode = "200", description = "Ингредиент добавлен", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ingredient.class)))
    })
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск ингредиента по его номеру", description = "Введите номер ингредиента")
    @ApiResponse(responseCode = "200", description = "Ингредиент найден", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ingredient.class)))
    })
    public ResponseEntity<Ingredient> getIngredient(@PathVariable long id) {
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактирование ингредиента", description = "Добавьте новый ингредиент и выберите номер уже существующего для его редактирования")
    @ApiResponse(responseCode = "200", description = "Ингредиент отредактирован", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ingredient.class)))
    })
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
        Ingredient ingredient1 = ingredientService.editIngredient(id, ingredient);
        if (ingredient1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient1);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление ингредиента", description = "Введите номер ингредиента, который нужно удалить")
    @ApiResponse(responseCode = "200", description = "Ингредиент удален", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ingredient.class)))
    })
    public ResponseEntity<Void> deleteIngredientById(@PathVariable long id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Получить все имеющиеся ингредиенты")
    @ApiResponse(responseCode = "200", description = "Вывод всех ингредиентов", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ingredient.class)))
    })
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> allIngredients = ingredientService.getAllIngredients();
        if (allIngredients.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allIngredients);
    }
}
