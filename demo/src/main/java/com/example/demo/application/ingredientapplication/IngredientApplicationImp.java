package com.example.demo.application.ingredientapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepository;
import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;
    private final Logger log;

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository, final ModelMapper modelMapper,
            final Logger log) {
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

    @Override
    public IngredientDTO update(UUID id, CreateUpdateIngredientDTO dto) {
        Ingredient ingredient = this.findById(id);
        ingredient = this.modelMapper.map(dto, Ingredient.class);
        ingredient.setId(id);
        if (this.ingredientRepository.exists(ingredient.getName())) {
            ingredient.validate();
        } else {
            ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientRepository.exists(name));
        }
        this.ingredientRepository.update(ingredient);
        this.log.info(this.serializeObject(ingredient, "updated."));

        return this.modelMapper.map(ingredient, IngredientDTO.class);
    }

    @Override
    public void delete(UUID id) {
        Ingredient ingredient = this.findById(id);
        this.ingredientRepository.delete(ingredient);
        this.log.info(this.serializeObject(ingredient, "deleted."));
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size) {
        return this.ingredientRepository.getAll(name, page, size);
    }

}
