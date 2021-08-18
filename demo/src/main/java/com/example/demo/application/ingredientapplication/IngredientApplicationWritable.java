package com.example.demo.application.ingredientapplication;

import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;


public interface IngredientApplicationWritable {
    
    public IngredientDTO add(CreateUpdateIngredientDTO dto);
    public IngredientDTO get(UUID id);
    public void update (UUID id, CreateUpdateIngredientDTO dtos);
    public void delete (UUID id);
}
