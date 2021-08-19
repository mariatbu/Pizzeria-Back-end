package com.example.demo.DTO.ingredientDTO;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class CreateUpdateIngredientDTO {
    private String name;
    private BigDecimal price;
}
