package com.example.demo.application.ingredientapplication;

import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;


public interface IngredientApplication {
    
    public IngredientDTO add(CreateUpdateIngredientDTO dto);
    public IngredientDTO get(UUID id);

}
