package com.example.demo.domain.ingredientdomain;

import com.example.demo.domain.ingredientdomain.Ingredient;
import java.util.UUID;
import java.util.List;

public interface IngredientRepositoryReadable {
    public List<Ingredient> getAll();
}
