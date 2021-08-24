package com.example.demo.domain.ingredientdomain;

import java.util.UUID;

import com.example.demo.core.FindById;

import java.util.Optional;

public interface IngredientRepositoryWritable extends FindById<Ingredient> {

    public void add(Ingredient ingredient);

    public void update(Ingredient ingredient);

    public void delete(Ingredient ingredient);

    public Optional<Ingredient> findById(UUID id);
    
}

