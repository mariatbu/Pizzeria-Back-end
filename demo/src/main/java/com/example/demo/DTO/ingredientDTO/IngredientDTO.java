package com.example.demo.DTO.ingredientDTO;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class IngredientDTO {

    private UUID id;
    private String name;
    private BigDecimal price;
}
