package com.example.demo.domain.ingredientdomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name="ingredients")
@Entity
public @NoArgsConstructor @Getter @Setter class Ingredient {
   
    @Id
    @Type (type = "uuid-char")
    private UUID id;

    @NotBlank
    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @Column (name = "price", nullable = false)
    private BigDecimal price;
    

}
