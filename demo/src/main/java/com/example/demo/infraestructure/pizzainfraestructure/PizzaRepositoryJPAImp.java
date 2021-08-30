package com.example.demo.infraestructure.pizzainfraestructure;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.pizzadomain.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepositoryJPAImp implements PizzaRepository{

   private final PizzaRepositoryJPA pizzaRepositoryJPA;

   @Autowired
   public PizzaRepositoryJPAImp (final PizzaRepositoryJPA pizzaRepositoryJPA){
       this.pizzaRepositoryJPA = pizzaRepositoryJPA;
   }

   @Override
   public void add(Pizza pizza){
       this.pizzaRepositoryJPA.save(pizza);
   }

    @Override
    public Optional<Pizza> findById(UUID id) {
        return this.pizzaRepositoryJPA.findById(id);
    }

    @Override
    public boolean exists(String name) {
        return this.pizzaRepositoryJPA.exists(name);
    }

    @Override
    public void update(Pizza pizza){
        this.pizzaRepositoryJPA.save(pizza);
    }
}
