package com.example.demo.domain.ingredientdomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.example.demo.core.EntityBase;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name="ingredients")
@Entity
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {
   
    @NotBlank(message = "No cojas los melocotones gordos")
    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @DecimalMin(value = "0.0", inclusive = false)
    @Column (name = "price", nullable = false)
    private BigDecimal price;

}
