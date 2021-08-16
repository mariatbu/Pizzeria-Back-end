package com.example.demo.domain.ingredientdomain;

import com.example.demo.domain.pizzadomain.Pizza;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Type;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Ingredient {

    @Id @GeneratedValue
    @Type (type= "uuid-char")
    public UUID id;

    @Column (name = "name", nullable = false, unique = true)
    public String name;

    @Column (name = "price", nullable = false)
    public Double price;

    public @ManyToMany (mappedBy = "ingredients") Set<Pizza> pizzas = new HashSet<>();

}
