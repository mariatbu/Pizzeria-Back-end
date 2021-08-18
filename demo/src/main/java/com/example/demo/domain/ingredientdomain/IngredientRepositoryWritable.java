package com.example.demo.domain.ingredientdomain;

import java.util.UUID;
import java.util.Optional;

public interface IngredientRepositoryWritable {

    public void add(Ingredient ingredient);

    public void update(Ingredient ingredient);

    public void delete(Ingredient ingredient);

    public Optional<Ingredient> findById(UUID id);
    
}

