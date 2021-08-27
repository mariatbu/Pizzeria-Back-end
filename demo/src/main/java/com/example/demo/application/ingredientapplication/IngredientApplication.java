package com.example.demo.application.ingredientapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.dto.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.dto.ingredientDTO.IngredientDTO;


public interface IngredientApplication {
    
    public IngredientDTO add(CreateUpdateIngredientDTO dto);
    public IngredientDTO get(UUID id);
    public IngredientDTO update(UUID id, CreateUpdateIngredientDTO dto);
    public void delete(UUID id);
    public List<IngredientProjection> getAll(String name, int page, int size);
}
