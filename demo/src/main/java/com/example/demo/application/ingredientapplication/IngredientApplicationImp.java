package com.example.demo.application.ingredientapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class IngredientApplicationImp implements IngredientApplication{

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = new ModelMapper(); //TODO: no instanciar aquí hablar con Juan Carlos
    }

    @Override
    public IngredientDTO add(CreateUpdateIngredientDTO dto) {
        Ingredient  ingredient= this.modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        //ingredient.validate();
        this.ingredientRepository.add(ingredient);
        return this.modelMapper.map(ingredient,IngredientDTO.class);  
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        return this.modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public void update(UUID id, CreateUpdateIngredientDTO dto) {
        /*Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        ingredient.setName(dto.getName());
        ingredient.setPrice(dto.getPrice());
        this.ingredientRepository.update(ingredient);*/
    }

    @Override
    public void delete(UUID id) {
        /*Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        this.ingredientRepository.delete(ingredient);*/
        
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size) {
        return this.ingredientRepository.getAll(name, page, size);
    }
    
}
