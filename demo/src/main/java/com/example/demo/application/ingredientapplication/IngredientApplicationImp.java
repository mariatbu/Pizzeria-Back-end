package com.example.demo.application.ingredientapplication;

import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;
import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;
    private final Logger log;

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository, final ModelMapper modelMapper, final Logger log) {
        super((id) -> ingredientRepository.findById(id));
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
        this.log = log;
    }

    @Override
    public IngredientDTO add(CreateUpdateIngredientDTO dto) {
        Ingredient ingredient = this.modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientRepository.exists(name));
        this.ingredientRepository.add(ingredient);
        this.log.info(this.serializeObject(ingredient, "added.")); 
        return this.modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.findById(id);
        IngredientDTO ingredientDTO = this.modelMapper.map(ingredient, IngredientDTO.class);
        return ingredientDTO;
    }


    private String serializeObject(Ingredient ingredient, String messege){
        
        return String.format("Ingredient {id: %s, name: %s, price: %s} %s succesfully.",
                            ingredient.getId(), ingredient.getName(),
                            ingredient.getPrice().toString(),
                            messege);
    }

}
