package com.example.demo.DTO.ingredientDTO;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class CreateUpdateIngredientDTO {
    @NotBlank
    private String name;

    @DecimalMin(value = "0.0",  inclusive = false)
    private BigDecimal price;
}
