package com.example.demo.dto.pizzaDTO;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.demo.domain.imagedomain.Image;
import com.example.demo.domain.ingredientdomain.Ingredient;

public class PizzaDTO {
    public UUID id;
    public String name;
    public Image image;
    public BigDecimal price;
    public Set<Ingredient> ingredients = new HashSet<Ingredient>();
}
