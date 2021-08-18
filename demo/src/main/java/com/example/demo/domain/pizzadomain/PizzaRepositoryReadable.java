package com.example.demo.domain.pizzadomain;

import java.util.List;


public interface PizzaRepositoryReadable {
    
    public List<PizzaProjection> getAll(String name, int page, int size);
        
}
