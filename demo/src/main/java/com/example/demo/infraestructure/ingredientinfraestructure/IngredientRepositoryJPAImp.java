package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepositoryReadable;
import com.example.demo.domain.ingredientdomain.IngredientRepositoryWritable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryJPAImp implements IngredientRepositoryWritable, IngredientRepositoryReadable {

    private final IngredientRepositoryJPA ingredientRepositoryJPA;

    @Autowired
    public IngredientRepositoryJPAImp(final IngredientRepositoryJPA ingredientRepositoryJPA){
        this.ingredientRepositoryJPA = ingredientRepositoryJPA;
    }

    public void add(Ingredient ingredient){
        this.ingredientRepositoryJPA.save(ingredient);
    }
    
    public void update(Ingredient ingredient){
        this.ingredientRepositoryJPA.save(ingredient);
    }

    public void delete(Ingredient ingredient){
        this.ingredientRepositoryJPA.delete(ingredient);
    }

    public Optional<Ingredient> findById(UUID id){
        return this.ingredientRepositoryJPA.findById(id);
    }

    public List<IngredientProjection> getAll(String name, int page, int size){
        return this.ingredientRepositoryJPA.findByCriteria(
            name, 
            PageRequest.of(page, size, Sort.by("name").descending())
            );
    }
}
