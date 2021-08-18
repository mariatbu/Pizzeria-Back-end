package com.example.demo.application.ingredientapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepositoryReadable;
import com.example.demo.domain.ingredientdomain.IngredientRepositoryWritable;

import org.springframework.beans.factory.annotation.Autowired;

public class IngredientApplicationImp implements IngredientApplicationReadable, IngredientApplicationWritable{

    private final IngredientRepositoryReadable ingredientRepositoryReadable;
    private final IngredientRepositoryWritable ingredientRepositoryWritable;

    @Autowired
    public IngredientApplicationImp(final IngredientRepositoryReadable ingredientRepositoryReadable, final IngredientRepositoryWritable ingredientRepositoryWritable){
        this.ingredientRepositoryWritable = ingredientRepositoryWritable;
        this.ingredientRepositoryReadable = ingredientRepositoryReadable;
    }

    @Override
    public IngredientDTO add(CreateUpdateIngredientDTO dto) {
        Ingredient ingredient = IngredientService.create(dto);
        this.ingredientRepositoryWritable.add(ingredient);
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.ingredientRepositoryWritable.findById(id).orElseThrow();
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public void update(UUID id, CreateUpdateIngredientDTO dtos) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
