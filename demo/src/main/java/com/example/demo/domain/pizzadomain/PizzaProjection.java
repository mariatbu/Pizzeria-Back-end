package com.example.demo.domain.pizzadomain;

import java.math.BigDecimal;

public interface PizzaProjection {
    
    String getName();

    public BigDecimal getPrice();

    public Image getImage();
    
    public interface Image{
        public String getPublic_id();
    };
}
