package com.example.demo.domain.ingredientdomain;
import java.math.BigDecimal;
import java.util.UUID;

public interface IngredientProjection {

    UUID getId();

    String getName();

    BigDecimal getPrice();
}
