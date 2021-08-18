package com.example.demo.application.ingredientapplication;

import java.util.List;

import com.example.demo.domain.ingredientdomain.IngredientProjection;

public interface IngredientApplicationReadable {
    
    public List<IngredientProjection> getAll(String name, int page, int size);

}
