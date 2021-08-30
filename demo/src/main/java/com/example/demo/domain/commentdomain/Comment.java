package com.example.demo.domain.commentdomain;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.core.EntityBase;
import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.userdomain.User;

import org.hibernate.annotations.Type;




@Entity
@Table(name = "comments")
public @NoArgsConstructor @Getter @Setter class Comment extends EntityBase {
    

    @Column(nullable = false)
    @NotNull 
    public String text;

    @Column(nullable = false)
    @NotNull 
    public BigDecimal rating;

    @Type(type = "uuid-char")
    @Column(name="user_id")
    private UUID userId;
 
  
    @NotNull
    @Type(type = "uuid-char")
    @Column(name="pizza_id", nullable = false)
    private UUID pizzaId;

 
    private @ManyToOne @JoinColumn (name ="user_id", insertable = false, updatable=false) User user;
 

    private @ManyToOne @JoinColumn (name="pizza_id", insertable = false, updatable=false) Pizza pizza;

    @Override
    public String toString() {
        return String.format("Comment {id: %s, text: %s, rating: %s, user: %s, pizza: %s}", 
        this.getId(), this.getText(), this.getRating(), this.getUserId(), this.getPizzaId());
    }
    
}
