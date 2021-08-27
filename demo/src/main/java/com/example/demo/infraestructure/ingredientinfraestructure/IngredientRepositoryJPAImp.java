package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryJPAImp implements IngredientRepository {

    private final IngredientRepositoryJPA ingredientRepositoryJPA;

    @Autowired
    public IngredientRepositoryJPAImp(final IngredientRepositoryJPA ingredientRepositoryJPA){
        this.ingredientRepositoryJPA = ingredientRepositoryJPA;
    }

    public void add(Ingredient ingredient){
        this.ingredientRepositoryJPA.save(ingredient);
    }

    public Optional<Ingredient> findById(UUID id){
        return this.ingredientRepositoryJPA.findById(id);
    }

    @Override
    public boolean exists(String name) {
        return this.ingredientRepositoryJPA.exists(name);
    }

    @Override
    public void update(Ingredient ingredient){
        this.ingredientRepositoryJPA.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient){
        this.ingredientRepositoryJPA.delete(ingredient);
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size){
        return this.ingredientRepositoryJPA.findByCriteria(name, PageRequest.of(page, size));
    }

}
