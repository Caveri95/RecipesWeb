package com.example.recipesweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingredient {

    private String ingredient;
    private int ingredientCount;
    private String ingredientMeasure;
}
