package com.example.demo.domain.ingredientdomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import java.math.BigDecimal;

@Entity
public @NoArgsConstructor @Getter @Setter class Ingredient {

    @Id
    @Type (type= "uuid-char")
    private UUID id;

    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @Column (name = "price", nullable = false)
    private BigDecimal price;
    
    @Override
    public boolean equals(Object obj)    {
        if (!(obj instanceof Ingredient)) {
            return false;
        }
        Ingredient tmp = (Ingredient)obj;
        return tmp.id.equals(this.id);
    }
   
    @Override
    public int hashCode() {
        return this.id.toString().hashCode();
    }
}
