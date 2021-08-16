package com.example.demo.domain.ingredientdomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import java.util.UUID;

@Entity
public class Ingredient {

    @Id
    @Type (type= "uuid-char")
    private UUID id;

    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @Column (name = "price", nullable = false)
    private Double price;

}
