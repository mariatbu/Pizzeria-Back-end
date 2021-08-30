package com.example.demo.domain.pizzadomain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.example.demo.core.EntityBase;
import com.example.demo.domain.imagedomain.Image;
import com.example.demo.domain.ingredientdomain.Ingredient;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
@Table(name="pizzas")
@Entity
public @Getter @Setter @NoArgsConstructor class Pizza extends EntityBase {
    
    @NotBlank
    @Column (name="name", nullable=false, unique=true)
    private String name;

    @Embedded
    private Image image;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @ManyToMany @JoinTable(name="pizzas_ingredients",
    joinColumns = @JoinColumn(name="pizza_id"),
    inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    final private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    @Column(nullable = false, name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
    }

    public BigDecimal calculatePrice(){
        BigDecimal total = new BigDecimal(0.0);
        BigDecimal addPrice = new BigDecimal(1.2);
        for(Ingredient ingredient: this.ingredients){
            total = total.add(ingredient.getPrice());
        }
        total = total.multiply(addPrice);
        total = total.setScale(2, RoundingMode.HALF_EVEN);
        return total;
    }

    @Override
    public String toString() {
        return String.format("Pizza {id: %s, name: %s, price: %s, with ingredients:[%s]}", this.getId(), this.getName(), this.getPrice(), this.getIngredients().toString());
    }    
}
