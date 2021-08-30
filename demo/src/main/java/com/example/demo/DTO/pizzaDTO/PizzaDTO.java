package com.example.demo.dto.pizzaDTO;
 
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
 
import com.example.demo.domain.imagedomain.Image;
import com.example.demo.domain.ingredientdomain.Ingredient;
 
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
 
public @Getter @Setter @NoArgsConstructor class PizzaDTO {
    private UUID id;
    private String name;
    private Image image;
    private BigDecimal price;
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();
}
