package com.example.demo.domain.ingredientdomain;

import java.util.UUID;

import com.example.demo.core.FindById;

public interface IngredientRepositoryWritable extends FindById<Ingredient, UUID> {

    public void add(Ingredient ingredient);

    public void update(Ingredient ingredient);

    public void delete(Ingredient ingredient);

    public boolean exists(String name);
    
}

