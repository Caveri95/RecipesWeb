package com.example.recipesweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class Recipe {

    private String recipeTitle;
    private int cookingTimeMin;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> cookingInstruction;
}
