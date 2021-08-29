package com.example.demo.domain.ingredientdomain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.example.demo.core.EntityBase;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
@Table(name="ingredients")
@Entity
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {
   
    @NotBlank
    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @DecimalMin(value = "0.0", inclusive = false)
    @Column (name = "price", nullable = false)
    private BigDecimal price;

    @Override
    public String toString() {

        return String.format("Ingredient {id: %s, name: %s, price: %s}", this.getId(), this.getName(), this.getPrice());
    }
}
