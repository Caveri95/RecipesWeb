package com.example.recipesweb.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Tag(name = "Учебный контроллер", description = "его я создал первым")
public class FirstController {

    @GetMapping("/")
    public String helloWeb() {
        return "Приложение запущено!";
    }

    @GetMapping("/info")
    public String info() {
        String name = "Юрий Б.";
        String project = "Recipes Web";
        LocalDate data = LocalDate.of(2023, 2, 22);
        return "автор - " + name +
                " название проекта - " + project +
                " дата создания - " + data +
                " Это первое тестовое веб-приложение для хранения рецептов";
    }
}
