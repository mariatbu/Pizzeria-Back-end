package com.example.demo.application.ingredientapplication;

import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;
import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository, final ModelMapper modelMapper) {
        super((id) -> ingredientRepository.findById(id));
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IngredientDTO add(CreateUpdateIngredientDTO dto) {
        Ingredient ingredient = this.modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientRepository.exists(name));
        this.ingredientRepository.add(ingredient);
        log.info("Ingredient created: " +ingredient.getName()); 
        return this.modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.findById(id);
        IngredientDTO ingredientDTO = this.modelMapper.map(ingredient, IngredientDTO.class);
        return ingredientDTO;
    }

}
