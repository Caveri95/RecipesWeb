package com.example.recipesweb.services;

public class IngredientNotFoundException extends Exception {

    public IngredientNotFoundException(String message) {
        super(message);
    }
}
