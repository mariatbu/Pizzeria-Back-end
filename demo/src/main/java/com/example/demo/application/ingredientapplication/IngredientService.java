package com.example.demo.application.ingredientapplication;

import java.util.UUID;

import com.example.demo.dto.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.dto.ingredientDTO.IngredientDTO;
import com.example.demo.domain.ingredientdomain.Ingredient;

public class IngredientService {
    
    public static Ingredient create(CreateUpdateIngredientDTO dto){
        Ingredient ingredient = new Ingredient();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        ingredient.id = UUID.randomUUID();
        return ingredient;
    }

    public static IngredientDTO createDTO(Ingredient ingredient){
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.id = ingredient.id;
        ingredientDTO.name = ingredient.name;
        ingredientDTO.price = ingredient.price;
        return ingredientDTO;
    }
}
