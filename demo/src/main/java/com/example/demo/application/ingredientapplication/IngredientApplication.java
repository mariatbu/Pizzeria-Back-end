package com.example.demo.application.ingredientapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;
import com.example.demo.domain.ingredientdomain.IngredientProjection;


public interface IngredientApplication {
    
    public IngredientDTO add(CreateUpdateIngredientDTO dto);
    public IngredientDTO get(UUID id);
    public IngredientDTO update(UUID id, CreateUpdateIngredientDTO dto);
    public void delete(UUID id);
    public List<IngredientProjection> getAll(String name, int page, int size);
}
