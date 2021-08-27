package com.example.demo.domain.ingredientdomain;

import java.util.List;

public interface IngredientRepositoryReadable {
    public List<IngredientProjection> getAll(String name, int page, int size);
}
