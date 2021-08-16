package com.example.demo.domain.ingredientdomain;
import java.util.UUID;

public interface IngredientProjection {
    
    UUID getId();

    String getName();

    Double getPrice();
}
